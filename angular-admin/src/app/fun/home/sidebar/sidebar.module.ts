import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SidebarComponent } from './sidebar.component';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { NzIconModule } from 'ng-zorro-antd/icon';

@NgModule({
  imports: [CommonModule, RouterModule, NzMenuModule, NzIconModule],
  declarations:[SidebarComponent],
  exports:[SidebarComponent]
})

export class SidebarModule{

}
