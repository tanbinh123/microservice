import { CommonConstant } from "../../constant/CommonConstant";

export class RequestHeader {

  //1（application/json）；2（multipart/form-data）；3（application/x-www-form-urlencoded）
  requestContentType:string = '1';

  contentType:string = 'application/json';

  token:string = CommonConstant.EMPTY;

  nonce:string = CommonConstant.EMPTY;

  time:string = CommonConstant.EMPTY;

  alias:string = CommonConstant.EMPTY;

}
