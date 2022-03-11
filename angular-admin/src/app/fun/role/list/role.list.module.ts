import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { RoleListComponent } from './role.list.component';
import { TableModule } from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from "primeng/confirmdialog";
import { MessagesModule } from "primeng/messages";

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule, TableModule, InputTextModule, ButtonModule, ConfirmDialogModule, MessagesModule],
  declarations:[RoleListComponent],
  exports:[RoleListComponent]
})

export class RoleListModule {

}
