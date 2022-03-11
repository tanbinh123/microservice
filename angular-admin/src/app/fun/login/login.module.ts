import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login.components';
import { LoginKeyDownDirective } from 'src/app/directive/LoginKeyDownDirective';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';

@NgModule({
  imports: [CommonModule, FormsModule, RouterModule, NzButtonModule, ReactiveFormsModule, NzFormModule, NzInputModule],
  declarations: [LoginComponent, LoginKeyDownDirective],
  exports: [LoginComponent]
})

export class LoginModule{

}
