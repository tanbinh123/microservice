import { CommonConstant } from 'src/app/constant/CommonConstant';

export class RequestUrl {

  private url:string;//URL通配

  private requestMethod:string;//请求方法

  private alias:string;//别名

  private requestDataSecret:number;//请求数据加密（0：不加密；1：加密）

  private responseDataSecret:number;//返回数据加密（0：不加密；1：加密）

  constructor(url:string,
              requestMethod:string,
              alias:string = CommonConstant.EMPTY,
              requestDataSecret:number = 0,
              responseDataSecret:number = 0) {
    this.url = url;
    this.requestMethod = requestMethod;
    this.alias = alias;
    this.requestDataSecret = requestDataSecret;
    this.responseDataSecret = responseDataSecret;
  }

  public getUrl():string {
    return this.url;
  }

  public getRequestMethod():string {
    return this.requestMethod;
  }

  public getAlias():string {
    return this.alias;
  }

  public getRequestDataSecret():number {
    return this.requestDataSecret;
  }

  public getResponseDataSecret():number {
    return this.responseDataSecret;
  }

  public setRequestDataSecret(value:number) {
    this.requestDataSecret = value;
  }

  public setResponseDataSecret(value:number) {
    this.responseDataSecret = value;
  }

}
