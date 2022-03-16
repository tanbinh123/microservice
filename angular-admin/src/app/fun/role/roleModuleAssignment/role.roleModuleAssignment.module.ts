import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { RoleModuleAssignmentComponent } from './role.roleModuleAssignment.component';
import { NzTreeModule } from 'ng-zorro-antd/tree';
import { NzButtonModule } from 'ng-zorro-antd/button';

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule, NzTreeModule, NzButtonModule],
    declarations:[RoleModuleAssignmentComponent],
    exports:[RoleModuleAssignmentComponent]
})

export class RoleModuleAssignmentModule {

}
