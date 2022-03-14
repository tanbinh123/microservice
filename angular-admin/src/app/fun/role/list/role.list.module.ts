import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { RoleListComponent } from './role.list.component';
import { TableModule } from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { MessagesModule } from 'primeng/messages';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzInputModule } from 'ng-zorro-antd/input';
import {NzGridModule} from 'ng-zorro-antd/grid';

@NgModule({
  imports: [
    CommonModule, RouterModule, FormsModule,
    TableModule, InputTextModule, ButtonModule, ConfirmDialogModule, MessagesModule, NzTableModule, NzButtonModule, NzInputModule, NzGridModule
  ],
  declarations:[RoleListComponent],
  exports:[RoleListComponent]
})

export class RoleListModule {

}
