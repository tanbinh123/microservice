import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login.components';
import { LoginKeyDownDirective } from 'src/app/directive/LoginKeyDownDirective';
import { ButtonModule } from 'primeng/button';

@NgModule({
  imports:[CommonModule,FormsModule,RouterModule,ButtonModule],
  declarations:[LoginComponent,LoginKeyDownDirective],
  exports:[LoginComponent]
})

export class LoginModule{

}
