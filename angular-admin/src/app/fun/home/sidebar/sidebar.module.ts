import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SidebarComponent } from './sidebar.component';
import { PanelMenuModule } from "primeng/panelmenu";

@NgModule({
  imports:[CommonModule,RouterModule,PanelMenuModule],
  declarations:[SidebarComponent],
  exports:[SidebarComponent]
})

export class SidebarModule{

}
