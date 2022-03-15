import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { RoleModifyComponent } from './role.modify.component';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';

@NgModule({
  imports: [
    CommonModule, RouterModule, FormsModule,
    NzLayoutModule, NzFormModule, NzInputModule, NzButtonModule, ReactiveFormsModule
  ],
  declarations:[RoleModifyComponent],
  exports:[RoleModifyComponent]
})

export class RoleModifyModule {

}
