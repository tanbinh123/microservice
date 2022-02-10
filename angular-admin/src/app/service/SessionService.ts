import { Injectable } from '@angular/core';
import { SystemConstant } from '../constant/SystemConstant';
import { RequestHeader } from '../model/common/RequestHeader';

const SESSION_STORAGE:any = window.sessionStorage;

@Injectable()
export class SessionService {

  public setSessionValueBykey(key:string,value:string):void {
    SESSION_STORAGE.setItem(key,value);
  }

  public getSessionValueByKey(key:string):string {
    return SESSION_STORAGE.getItem(key);
  }

  public removeSessionValueByKey(key:string):void {
    SESSION_STORAGE.removeItem(key);
  }

  /** -------------------- 本项目自定义处理 -------------------- */

  public setTokenData(tokenData:string):void {
    this.setSessionValueBykey(SystemConstant.TOKEN_DATA,tokenData);
  }

  public getTokenData():any {
    try {
      return JSON.parse(this.getSessionValueByKey(SystemConstant.TOKEN_DATA));
    } catch (e) {
      return null;
    }
  }

  public removeTokenData():void {
    this.removeSessionValueByKey(SystemConstant.TOKEN_DATA);
  }

  public getHeadToken():RequestHeader {
    let requestHeader:RequestHeader = new RequestHeader();
    try {
      requestHeader.token = this.getTokenData().token;
    } catch (e) {
      //do nothing
    }
    return requestHeader;
  }

}
