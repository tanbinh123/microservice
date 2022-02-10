import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './home.component';
import {CenteralModule} from './centeral/centeral.module';
import {SidebarModule} from './sidebar/sidebar.module';
import {HeaderModule} from './header/header.module';
import {UserModule} from '../user/user.module';
import {RoleModule} from '../role/role.module';
import {ModuleModule} from '../module/module.module';
import {DictionaryModule} from '../dictionary/dictionary.module';
import {OperationLogModule} from '../operationLog/operation.log.module';
import {ScheduleModule} from '../schedule/schedule.module';
import {InterfacesModule} from '../interfaces/interfaces.module';
import {OnlineChatModule} from '../onlineChat/online.chat.module';
import {OnlineUserModule} from '../onlineUser/online.user.module';
import {DbTablesModule} from '../dbTables/db.tables.module';
import {SystemLogModule} from '../systemLog/system.log.module';
import {FileModule} from '../file/file.module';
import {ConfigModule} from '../config/config.module';
import {RoleRestrictModule} from '../roleRestrict/role.restrict.module';

@NgModule({
  imports:[CommonModule,RouterModule,
           HeaderModule,SidebarModule,CenteralModule,
           UserModule,RoleModule,RoleRestrictModule,ModuleModule,ConfigModule,
           DictionaryModule,OperationLogModule,ScheduleModule,
           InterfacesModule,OnlineChatModule,OnlineUserModule,
           DbTablesModule,SystemLogModule,FileModule
  ],
  declarations:[HomeComponent],
  exports:[HomeComponent]
})

export class HomeModule {

}
