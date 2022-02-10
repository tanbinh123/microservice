import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';

import {RoleRestrictAddComponent} from './role.restrict.add.component';

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule],
    declarations:[RoleRestrictAddComponent],
    exports:[RoleRestrictAddComponent]
})

export class RoleRestrictAddModule {

}
