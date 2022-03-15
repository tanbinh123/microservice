import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { RoleAddComponent } from './role.add.component';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';

@NgModule({
  imports: [
    CommonModule, RouterModule, FormsModule,
    NzLayoutModule, NzGridModule, NzInputModule, NzButtonModule, NzFormModule, ReactiveFormsModule
  ],
  declarations:[RoleAddComponent],
  exports:[RoleAddComponent]
})

export class RoleAddModule {

}
