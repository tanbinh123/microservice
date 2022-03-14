import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SidebarComponent } from './sidebar.component';
import { PanelMenuModule } from "primeng/panelmenu";
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { NzIconModule } from 'ng-zorro-antd/icon';

@NgModule({
  imports: [CommonModule, RouterModule, PanelMenuModule, NzMenuModule, NzIconModule],
  declarations:[SidebarComponent],
  exports:[SidebarComponent]
})

export class SidebarModule{

}
