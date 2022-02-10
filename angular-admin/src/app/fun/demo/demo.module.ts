import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {DemoComponent} from './demo.components';
import {DemoChildComponent} from './demo.child.component';
import {FormsModule} from '@angular/forms';
import { DateFormatPipe } from 'src/app/pipe/DateFormatPipe';

@NgModule({
    imports:[CommonModule,RouterModule,FormsModule],
    declarations:[DemoComponent,DemoChildComponent,DateFormatPipe],
    exports:[DemoComponent]
})

export class DemoModule{

}
