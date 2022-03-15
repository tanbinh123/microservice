import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { RoleListComponent } from './role.list.component';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzTypographyModule } from 'ng-zorro-antd/typography';

@NgModule({
  imports: [
    CommonModule, RouterModule, FormsModule,
    NzTableModule, NzButtonModule, NzInputModule, NzGridModule, NzLayoutModule, NzTypographyModule
  ],
  declarations:[RoleListComponent],
  exports:[RoleListComponent]
})

export class RoleListModule {

}
