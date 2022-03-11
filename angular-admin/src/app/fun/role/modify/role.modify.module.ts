import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { RoleModifyComponent } from './role.modify.component';
import { TableModule } from "primeng/table";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";
import { MessagesModule } from "primeng/messages";

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule, TableModule, InputTextModule, ButtonModule, MessagesModule],
  declarations:[RoleModifyComponent],
  exports:[RoleModifyComponent]
})

export class RoleModifyModule {

}
