import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { UserListComponent } from './user.list.component';
import { NzTypographyModule } from 'ng-zorro-antd/typography';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzLayoutModule } from 'ng-zorro-antd/layout';

@NgModule({
  imports: [
    CommonModule, RouterModule, FormsModule,
    NzTypographyModule, NzGridModule, NzInputModule, NzButtonModule, NzTableModule, NzLayoutModule
  ],
  declarations:[UserListComponent],
  exports:[UserListComponent]
})

export class UserListModule {

}
