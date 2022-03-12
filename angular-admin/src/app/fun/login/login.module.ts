import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login.components';
import { LoginKeyDownDirective } from 'src/app/directive/LoginKeyDownDirective';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzTypographyModule } from 'ng-zorro-antd/typography';

@NgModule({
  imports: [
    CommonModule, FormsModule, RouterModule, ReactiveFormsModule,
    NzButtonModule, NzFormModule, NzInputModule, NzTypographyModule
  ],
  declarations: [LoginComponent, LoginKeyDownDirective],
  exports: [LoginComponent]
})

export class LoginModule{

}
