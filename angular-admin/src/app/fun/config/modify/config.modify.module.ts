import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {ConfigModifyComponent} from './config.modify.component';


@NgModule({
  imports: [CommonModule, RouterModule, FormsModule],
    declarations:[ConfigModifyComponent],
    exports:[ConfigModifyComponent]
})

export class ConfigModifyModule {

}
