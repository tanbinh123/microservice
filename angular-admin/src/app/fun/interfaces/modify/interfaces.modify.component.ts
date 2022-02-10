import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {InterfacesModifyRequest} from '../../../model/interfaces/InterfacesModifyRequest';

@Component({
  selector: 'app-web-interfaces-modify',
  templateUrl: './interfaces.modify.html',
  styleUrls: ['./interfaces.modify.scss'],
  providers:[]
})

export class InterfacesModifyComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public interfacesModifyRequest:InterfacesModifyRequest = new InterfacesModifyRequest();//接口修改

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let id = queryParam.id;
      this.interfacesModifyRequest.id = id;
      this.interfacesDetail(id);
    });
  }

  //接口详情
  public interfacesDetail(id:string):void{
    this.httpService.requestJsonData(ApiConstant.SYS_INTERFACES_DETAIL,null,new Map([['interfacesId',id]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.interfacesModifyRequest.name = result.data.name;//接口名称
            this.interfacesModifyRequest.times = result.data.times;//时间
            this.interfacesModifyRequest.unit = result.data.unit;//单位
            this.interfacesModifyRequest.counts = result.data.counts;//次数
            this.interfacesModifyRequest.logRecord = result.data.logRecord;//（0：不记录；1：记录）
            this.interfacesModifyRequest.remark = result.data.remark;//备注
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //修改接口
  public interfacesModify():void{
    this.httpService.requestJsonData(ApiConstant.SYS_INTERFACES_MODIFY,JSON.stringify(this.interfacesModifyRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('修改接口成功');
            this.router.navigate(['../'],{relativeTo:this.activatedRoute});
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

  //返回
  public interfacesModifyBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
