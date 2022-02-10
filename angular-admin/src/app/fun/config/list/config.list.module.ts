import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {ConfigListComponent} from './config.list.component';


@NgModule({
  imports: [CommonModule, RouterModule, FormsModule],
  declarations:[ConfigListComponent],
  exports:[ConfigListComponent]
})

export class ConfigListModule {

}
