import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {RoleRestrictListComponent} from './role.restrict.list.component';

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule],
  declarations:[RoleRestrictListComponent],
  exports:[RoleRestrictListComponent]
})

export class RoleRestrictListModule {

}
