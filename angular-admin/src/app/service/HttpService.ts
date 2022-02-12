import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { RequestHeader } from "../model/common/RequestHeader";
import { ApiConstant } from '../constant/ApiConstant';
import { DatePipe } from '@angular/common';
import { SecretUtil } from '../util/SecretUtil';
import { SessionService } from "./SessionService";
import { RequestUrl } from '../model/common/RequestUrl';
import { CommonConstant } from '../constant/CommonConstant';

@Injectable()
export class HttpService {

  constructor(public httpClient:HttpClient,
              public datePipe:DatePipe,
              public sessionService:SessionService) {

  }

  public getOptions(requestHeader:RequestHeader = null):any {
    if(requestHeader == null){
      requestHeader = this.sessionService.getHeadToken();
    }
    let headers:HttpHeaders = new HttpHeaders({
        'Content-Type':requestHeader.contentType,
        'Access-Control-Allow-Headers':'Authorization',
        'Api-Version':ApiConstant.API_VERSION,
        requestContentType:requestHeader.requestContentType,
        nonce:requestHeader.nonce,
        token:requestHeader.token,
        time:requestHeader.time,
        alias:requestHeader.alias
    });
    let options = {headers:headers,withCredentials:true};
    return options;
  }

  public requestJsonData(url:string, body:string = null, parameterReplaceMap:Map<String,String> = null, requestHeader:RequestHeader = null) {
    let requestUrl:RequestUrl = ApiConstant.URL_MAP.get(url);
    if(requestUrl.getRequestDataSecret()==1){//请求加密
      if(requestUrl.getRequestMethod()==CommonConstant.POST || requestUrl.getRequestMethod()==CommonConstant.PUT) {
        let time = this.datePipe.transform(new Date(),'yyyyMMddHHmmss');
        let secretInfo = this.getSecretInfo(body,time);
        body = JSON.stringify(secretInfo['body']);
        requestHeader = this.sessionService.getHeadToken();
        requestHeader.nonce = secretInfo['nonce'];
        requestHeader.time = time;
        requestHeader.alias = requestUrl.getAlias();
      }
    }
    if(requestUrl.getRequestMethod()==CommonConstant.GET) {
      return this.httpClient.get(this.urlReplace(url,parameterReplaceMap), this.getOptions(requestHeader));
    }
    if(requestUrl.getRequestMethod()==CommonConstant.DELETE) {
      return this.httpClient.delete(this.urlReplace(url,parameterReplaceMap), this.getOptions(requestHeader));
    }
    if(requestUrl.getRequestMethod()==CommonConstant.POST) {
      return this.httpClient.post(this.urlReplace(url,parameterReplaceMap), body, this.getOptions(requestHeader));
    }
    if(requestUrl.getRequestMethod()==CommonConstant.PUT) {
      return this.httpClient.put(this.urlReplace(url,parameterReplaceMap), body, this.getOptions(requestHeader));
    }
  }

  public getSecretInfo(body:string,time:string):any {
    let tokenData:any = this.sessionService.getTokenData();
    let nonce = SecretUtil.getNonce(24,true);//未加密的nonce
    let secretNonce = SecretUtil.rsaEncrypt(nonce,tokenData.rsaPublicKey1);//加密的nonce
    let code = SecretUtil.cryptoAesEncrypt(body,nonce);
    let sign = SecretUtil.rsaSign(SecretUtil.getMd5(time+','+nonce+','+body),tokenData.rsaPrivateKey2);
    let newBody = {'code':code,'sign':sign};
    return {'body':newBody,'nonce':secretNonce};
  }

  public urlReplace(url:string,parameterReplaceMap:Map<String,String>):string {
    if(parameterReplaceMap!=null){
      parameterReplaceMap.forEach((value:string, key:string) => {
        url = url.replace(key, value);
      });
    }
    url = url.replace('{','').replace('}','');
    url = ApiConstant.HTTP_REQUEST_PREFIX + url;//全路径
    return url;
  }

  public getHttpClient():HttpClient {
    /*
    this.httpClient.get(url);
    this.httpClient.post(url,body,options);
    this.httpClient.put(url,body,options);
    this.httpClient.delete(url);
    */
    return this.httpClient;
  }

}
