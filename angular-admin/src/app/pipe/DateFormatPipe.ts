import { Pipe, PipeTransform } from '@angular/core'
import { CommonConstant } from '../constant/CommonConstant';

//默认日期格式化类型
const DEFAULT_DATE_FORMAT:string = 'yyyy-MM-dd HH:mm:ss';

/**
 * 用例
 * module引入：declarations[DateFormatPipe]
 * {{d | dateFormat}}
 * {{d | dateFormat:('yyyyMMddHHmmss')}}
 */
@Pipe({
    name: 'dateFormat',
    //pure: true//默认值
})
export class DateFormatPipe implements PipeTransform {

  transform(value:Date,format?:string):string {
    try {
      let year = value.getFullYear();
      let month = value.getMonth() + 1;
      let day = value.getDate();
      let hour = value.getHours();
      let minute = value.getMinutes();
      let second = value.getSeconds();
      if(format == null || format.trim() == CommonConstant.EMPTY) {
        format = DEFAULT_DATE_FORMAT;
      }
      format = format.replace('yyyy', year + CommonConstant.EMPTY)
                     .replace('MM', month < 10 ? '0' + month : month + CommonConstant.EMPTY)
                     .replace('dd', day < 10 ? '0' + day : day + CommonConstant.EMPTY)
                     .replace('HH', hour < 10 ? '0' + hour : hour + CommonConstant.EMPTY)
                     .replace('mm', minute < 10 ? '0' + minute : minute + CommonConstant.EMPTY)
                     .replace('ss', second < 10 ? '0' + second : second + CommonConstant.EMPTY);
      return format;
    } catch (error) {
      return CommonConstant.EMPTY;
    }
  }

}
