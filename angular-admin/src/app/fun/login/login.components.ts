import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { Base64 } from 'js-base64';
import { UserLoginRequest } from 'src/app/model/user/UserLoginRequest';
import { HttpService } from 'src/app/service/HttpService';
import { ApiConstant } from 'src/app/constant/ApiConstant';
import { SessionService } from 'src/app/service/SessionService';
import { RequestUrl } from 'src/app/model/common/RequestUrl';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgZorroValidatorUtil } from '../../util/NgZorroValidatorUtil';
import { RequestHeader } from '../../model/common/RequestHeader';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-web-login',
  templateUrl: './login.html',
  styleUrls: ['./login.scss']
})

export class LoginComponent implements OnInit {

  validateForm!:FormGroup;
  version:string = ApiConstant.API_VERSION;
  userLoginRequest:UserLoginRequest = new UserLoginRequest();

  constructor(public router:Router,
              public httpService:HttpService,
              public sessionService:SessionService,
              public datePipe:DatePipe,
              public formBuilder:FormBuilder,
              public nzMessageService:NzMessageService) {
    //do nothing
  }

  ngOnInit() {
    this.initValidateForm();
  }

  public initValidateForm():void {
    this.validateForm = this.formBuilder.group({
      username: [null, [NgZorroValidatorUtil.empty]],
      password: [null, [NgZorroValidatorUtil.empty]]
    });
  }

  //回车事件
  public keydownEnter($event:any):void {
    //console.log($event);
    this.login();
  }

  //用户登录
  public login():void {
    if (this.validateForm.valid) {
      //console.log(this.validateForm.value);
      let newUserLoginRequest:UserLoginRequest = new UserLoginRequest();
      let time = this.datePipe.transform(new Date(),'yyyyMMddHHmmss');
      newUserLoginRequest.username = this.userLoginRequest.username;
      newUserLoginRequest.password = this.encodePassword(this.userLoginRequest.password,time);
      newUserLoginRequest.clientType = this.userLoginRequest.clientType;
      newUserLoginRequest.loginWay = this.userLoginRequest.loginWay;
      newUserLoginRequest.time = time;
      this.httpService.requestJsonData(ApiConstant.WEB_LOGIN,JSON.stringify(newUserLoginRequest)).subscribe(
        {
          next:(result:any) => {
            //console.log(result);
            if(200==result.code){
              let requestHeader:RequestHeader = this.sessionService.getHeadToken();
              requestHeader.token = result.data;
              this.httpService.requestJsonData(ApiConstant.GET_REDIS_TOKEN_DATA,null,null,requestHeader).subscribe({
                next:(result:any) => {
                  if(200==result.code){
                    let ret = result.data;
                    //console.log(ret);
                    this.sessionService.setTokenData(JSON.stringify(ret));
                    //更新ApiConstant->URL_MAP里的信息
                    //console.log('更新前：',ApiConstant.URL_MAP);
                    this.refreshUrlMap(ret.interfaceInfoResponseList);
                    //console.log('更新后：',ApiConstant.URL_MAP);
                    this.router.navigate(['web']);
                  }else{
                    this.nzMessageService.error(result.message);
                  }
                },
                error:e => {
                  this.nzMessageService.error(e.message);
                },
                complete:() => {}
              });
            }else{
              this.nzMessageService.error(result.message);
            }
          },
          error:e => {
            this.nzMessageService.error(e.message)
          },
          complete:() => {}
        }
      );
    } else {
      Object.values(this.validateForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }

  //示例
  public demo():void {
    this.router.navigate(['demo']);
  }

  //简单登录密码加密
  public encodePassword(passwod:string,time:string):string {
    //console.log(passwod,time);
    let passwordEncod:string;
    let position = Number.parseInt(time)%2;
    if(position==0){//偶数
      passwordEncod = Base64.encode(passwod+time);
    }else{//奇数
      passwordEncod = Base64.encode(time+passwod);
    }
    let temArray:Array<any> = new Array(passwordEncod.length);
    for(let i=0;i<passwordEncod.length;i++){
      temArray[i] = passwordEncod.charAt(i);
    }
    let one:any,another:any,tmp:any;
    for(let i=0;i<time.length;){
      one = time.charAt(i++);
      another = time.charAt((i++));
      tmp = temArray[one];
      temArray[one] = temArray[another];
      temArray[another] = tmp;
    }
    passwordEncod = temArray.toString().replace(new RegExp(',','g'),'');
    return passwordEncod;
  }

  //刷新URL_MAP
  public refreshUrlMap(interfaceInfoResponseList:any):void {
    for(let i=0;i<interfaceInfoResponseList.length;i++){
      let each = interfaceInfoResponseList[i];
      let requestUrl:RequestUrl = ApiConstant.URL_MAP.get(each.url);
      if(requestUrl != undefined && requestUrl != null){
        requestUrl.setRequestDataSecret(each.requestDataSecret);
        requestUrl.setResponseDataSecret(each.responseDataSecret);
        ApiConstant.URL_MAP.set(each.url,requestUrl);
        break;
      }
    }
  }

}
