export class CommonValidatorUtil {

  //为空校验
  public static isStringEmpty(value:string):boolean {
    return value == null || value.length == 0 || value.replace(/(^\s*)|(\s*$)/, '') == '';
  }

  //手机号校验
  public static isNotMobile(value:string):boolean {
    return !(/^1[3456789]\d{9}$/.test(value));
  }

}
