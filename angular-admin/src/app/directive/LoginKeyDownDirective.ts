import { Directive, HostBinding, HostListener } from '@angular/core';

const rgbNum:any = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'];

//使用：在@NgModule中的declarations中引入LoginKeyDownDirective
//注意：A directive must belong to exactly one NgModule. Do not re-declare a directive imported from another module.
@Directive({
  selector: '[appLoginKeyDown]'
})
export class LoginKeyDownDirective {

  @HostBinding('style.color')
  public color:string;

  @HostBinding('style.borderColor')
  public borderColor:string;

  @HostListener('keydown')
  public onKeydown():void {
    let rgb = '#';
    for(let i=0;i<6;i++){
      let index = Math.floor(Math.random() * rgbNum.length);
      rgb += rgbNum[index];
    }
    this.color = this.borderColor = rgb;
  }

}
