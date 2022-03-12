import {AbstractControl, FormControl, ValidatorFn, Validators} from '@angular/forms';
import { NzSafeAny } from 'ng-zorro-antd/core/types';

export type MyErrorsOptions = { 'zh-cn': string; en: string } & Record<string, NzSafeAny>;
export type MyValidationErrors = Record<string, MyErrorsOptions>;

export class NgZorroValidatorUtil extends Validators {

  public static emptyWithMessage(message:string): ValidatorFn {
    return (control: AbstractControl): MyValidationErrors | null => {
      if (NgZorroValidatorUtil.empty(control) === null) {
        return null;
      }
      return { maxlength: { 'zh-cn': message, en: message } };
    };
  }

  public static empty(control: AbstractControl): MyValidationErrors | null {
    const value = control.value;
    if(NgZorroValidatorUtil.isStringEmpty(value)){
      return { notEmpty: { 'zh-cn': `不能为空`, en: `不能为空` } };
    }
    return null;
  }

  public static mobile(control: AbstractControl): MyValidationErrors | null {
    const value = control.value;
    if(NgZorroValidatorUtil.isStringEmpty(value)){
      return { mobile: { 'zh-cn': `手机号码不能为空`, en: `手机号码不能为空` } };
    }
    if(NgZorroValidatorUtil.isNotMobile(value)){
      return { mobile: { 'zh-cn': `手机号码格式不正确`, en: `手机号码格式不正确` } };
    }
    return null;
  }

  //为空校验
  public static isStringEmpty(value:string):boolean {
    return value == null || value.length == 0 || value.replace(/(^\s*)|(\s*$)/, '') == '';
  }

  //手机号校验
  public static isNotMobile(value:string):boolean {
    return !(/^1[3456789]\d{9}$/.test(value));
  }

}
