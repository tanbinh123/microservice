import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {InterfacesTestRequest} from '../../../model/interfaces/InterfacesTestRequest';
import {ApiConstant} from '../../../constant/ApiConstant';

@Component({
  selector: 'app-web-interfaces-test',
  templateUrl: './interfaces.test.html',
  styleUrls: ['./interfaces.test.scss'],
  providers:[]
})

export class InterfacesTestComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public responseOut:string = null;
  public interfacesTestRequest:InterfacesTestRequest = new InterfacesTestRequest();//接口测试

  //初始化
  ngOnInit(): void {

  }

  //返回
  public interfacesTestBack():void {
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

  //提交
  public interfacesTest():void {
    //console.log(this.interfacesTestRequest);
    this.httpService.requestJsonData(ApiConstant.SYS_INTERFACES_TEST,JSON.stringify(this.interfacesTestRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.responseOut = result.data;
            alert('测试成功');
          }else{
            alert(result.message);
            //this.router.navigate(['webLogin']);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

}
