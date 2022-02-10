import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {RoleRestrictComponent} from './role.restrict.component';
import {RoleRestrictListModule} from './list/role.restrict.list.module';
import {RoleRestrictAddModule} from './add/role.restrict.add.module';

@NgModule({
  imports:[
    CommonModule,RouterModule,
    RoleRestrictListModule,RoleRestrictAddModule
  ],
  declarations:[RoleRestrictComponent],
  exports:[RoleRestrictComponent]
})

export class RoleRestrictModule{

}
