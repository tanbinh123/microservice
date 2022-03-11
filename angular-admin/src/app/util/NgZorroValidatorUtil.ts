import { AbstractControl, Validators } from '@angular/forms';
import { NzSafeAny } from 'ng-zorro-antd/core/types';

export type MyErrorsOptions = { 'zh-cn': string; en: string } & Record<string, NzSafeAny>;
export type MyValidationErrors = Record<string, MyErrorsOptions>;

export class NgZorroValidatorUtil extends Validators {

  public static mobile(control: AbstractControl): MyValidationErrors | null {
    const value = control.value;
    if(NgZorroValidatorUtil.isStringEmpty(value)){
      return { mobile: { 'zh-cn': `手机号码不能为空`, en: `Mobile phone number is not empty` } };
    }
    if(NgZorroValidatorUtil.isNotMobile(value)){
      return { mobile: { 'zh-cn': `手机号码格式不正确`, en: `Mobile phone number is not valid` } };
    }
    return null;
  }

  //为空校验
  public static isStringEmpty(value:string):boolean {
    return value == undefined || value == null || value.length == 0 || value.replace(/(^\s*)|(\s*$)/, '') == '';
  }

  //手机号校验
  public static isNotMobile(value:string):boolean {
    return !(/^1[3456789]\d{9}$/.test(value));
  }

}
