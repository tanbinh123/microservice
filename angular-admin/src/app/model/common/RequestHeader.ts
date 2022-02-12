import { CommonConstant } from '../../constant/CommonConstant';

export class RequestHeader {

  //1（application/json）；2（multipart/form-data）；3（application/x-www-form-urlencoded）
  requestContentType = '1';

  contentType = 'application/json';

  token:string = CommonConstant.EMPTY;

  nonce:string = CommonConstant.EMPTY;

  time:string = CommonConstant.EMPTY;

  alias:string = CommonConstant.EMPTY;

}
