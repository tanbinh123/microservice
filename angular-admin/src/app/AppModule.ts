import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './AppRoutingModule';
import {AppComponent} from './AppComponent';
import {LoginModule} from './fun/login/login.module';
import {HttpService} from './service/HttpService';
import {HttpClientModule} from '@angular/common/http';
import {SessionService} from './service/SessionService';
import {AuthService} from './service/AuthService';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CommonModule} from '@angular/common';
import {HomeModule} from './fun/home/home.module';
import {FormsModule} from '@angular/forms';
import {DemoModule} from './fun/demo/demo.module';
import {DatePipe} from '@angular/common';
import * as AllIcons from '@ant-design/icons-angular/icons';
import {IconDefinition} from '@ant-design/icons-angular';
import {NZ_ICONS} from 'ng-zorro-antd/icon';

/** NgZorro全局icon引入 start */
const antDesignIcons = AllIcons as {
  [key: string]: IconDefinition;
};
const icons: IconDefinition[] = Object.keys(antDesignIcons).map(key => antDesignIcons[key])
const NzIcon = {provide:NZ_ICONS,useValue:icons}
/** NgZorro全局icon引入 end */

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    CommonModule,FormsModule,BrowserModule,BrowserAnimationsModule,HttpClientModule,
    AppRoutingModule,
    LoginModule,HomeModule,DemoModule
  ],
  providers: [DatePipe,HttpService,SessionService,AuthService,NzIcon],
  bootstrap: [AppComponent]
})
export class AppModule {

}
