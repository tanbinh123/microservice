import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {DbTablesOperateComponent} from './db.tables.operate.component';

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule],
    declarations:[DbTablesOperateComponent],
    exports:[DbTablesOperateComponent]
})

export class DbTablesOperateModule {

}
