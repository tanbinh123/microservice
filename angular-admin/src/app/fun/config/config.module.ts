import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';

import {ConfigComponent} from './config.component';
import {ConfigListModule} from './list/config.list.module';
import {ConfigModifyModule} from './modify/config.modify.module';
import {ConfigDetailModule} from './detail/config.detail.module';
import {ConfigAddModule} from './add/config.add.module';

@NgModule({
  imports:[
    CommonModule,RouterModule,
    ConfigListModule,ConfigModifyModule,ConfigDetailModule,ConfigAddModule
  ],
  declarations:[ConfigComponent],
  exports:[ConfigComponent]
})

export class ConfigModule{

}
