import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {ConfigAddComponent} from './config.add.component';

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule],
    declarations:[ConfigAddComponent],
    exports:[ConfigAddComponent]
})

export class ConfigAddModule {

}
