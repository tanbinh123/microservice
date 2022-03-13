import { AbstractControl, ValidatorFn, Validators } from '@angular/forms';
import { NzSafeAny } from 'ng-zorro-antd/core/types';
import { CommonValidatorUtil } from './CommonValidatorUtil';

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
    if(CommonValidatorUtil.isStringEmpty(value)){
      return { notEmpty: { 'zh-cn': `不能为空`, en: `不能为空` } };
    }
    return null;
  }

  public static mobile(control: AbstractControl): MyValidationErrors | null {
    const value = control.value;
    if(CommonValidatorUtil.isStringEmpty(value)){
      return { mobile: { 'zh-cn': `手机号码不能为空`, en: `手机号码不能为空` } };
    }
    if(CommonValidatorUtil.isNotMobile(value)){
      return { mobile: { 'zh-cn': `手机号码格式不正确`, en: `手机号码格式不正确` } };
    }
    return null;
  }

}
