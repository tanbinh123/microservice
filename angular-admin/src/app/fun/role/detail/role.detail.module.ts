import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { RoleDetailComponent } from './role.detail.component';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';

@NgModule({
  imports: [
    CommonModule, RouterModule, FormsModule,
    NzLayoutModule, NzGridModule, NzFormModule, NzInputModule, NzButtonModule
  ],
  declarations:[RoleDetailComponent],
  exports:[RoleDetailComponent]
})

export class RoleDetailModule {

}
