import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {ConfigDetailComponent} from './config.detail.component';

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule],
    declarations:[ConfigDetailComponent],
    exports:[ConfigDetailComponent]
})

export class ConfigDetailModule {

}
