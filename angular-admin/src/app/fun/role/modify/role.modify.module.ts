import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { RoleModifyComponent } from './role.modify.component';
import { TableModule } from "primeng/table";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule, TableModule, InputTextModule, ButtonModule],
  declarations:[RoleModifyComponent],
  exports:[RoleModifyComponent]
})

export class RoleModifyModule {

}
