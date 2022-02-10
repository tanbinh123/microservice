import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {DbTablesComponent} from './db.tables.component';
import {DbTablesListModule} from './list/db.tables.list.module';
import {DbTablesDetailModule} from './detail/db.tables.detail.module';
import { DbTablesOperateModule } from './operate/db.tables.operate.module';


@NgModule({
  imports:[
    CommonModule,RouterModule,
    DbTablesListModule,DbTablesDetailModule,DbTablesOperateModule
  ],
  declarations:[DbTablesComponent],
  exports:[DbTablesComponent]
})

export class DbTablesModule{

}
