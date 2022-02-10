import {Component,OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpService} from '../../service/HttpService';
import {AuthService} from '../../service/AuthService';
import {DemoEntityComponent} from './demo.entity.component';

@Component({
  selector: 'app-web-demo',
  templateUrl: './demo.html',
  styleUrls: ['./demo.scss'],
  providers:[]
})

export class DemoComponent implements OnInit {

  demo1_1:string;
  demo1_2:any[];
  demo1_3:string;
  demo1_6:DemoEntityComponent = new DemoEntityComponent('张三',30);
  demo1_8 = 'red';
  demo1_10 = '我是[(ngModel)]';
  demo1_11 = new Date();

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService){

  }

  ngOnInit(): void {
    this.demo1_1 = '{{内容}}';
    this.demo1_2 = ['a',1,'b',2,'c',3];
    this.demo1_3 = '';
  }

  public demo1_4(v1,v2):void {
    alert(`v1=${v1.value},v2=${v2.value}`)
  }

  //用于接收子组件的数据
  public wordsClick($event):void {
    console.log($event);
  }

  public demo1_7():boolean {
    return true;
  }

}
