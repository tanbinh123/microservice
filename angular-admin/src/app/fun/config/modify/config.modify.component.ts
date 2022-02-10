import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ConfigModifyRequest} from '../../../model/config/ConfigModifyRequest';

@Component({
  selector: 'app-web-config-modify',
  templateUrl: './config.modify.html',
  styleUrls: ['./config.modify.scss'],
  providers:[]
})

export class ConfigModifyComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public configModifyRequest:ConfigModifyRequest = new ConfigModifyRequest();//配置修改

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let configId = queryParam.configId;
      this.configModifyRequest.id = configId;
      this.configDetail(configId);
    });
  }

  //配置详情
  public configDetail(configId:string):void{
    this.httpService.requestJsonData(ApiConstant.SYS_CONFIG_DETAIL,null,new Map([['configId',configId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.configModifyRequest.dataType = result.data.dataType;//数据类型
            this.configModifyRequest.keyCode = result.data.keyCode;//key值
            this.configModifyRequest.valueCode = result.data.valueCode;//value值
            this.configModifyRequest.categoryName = result.data.categoryName;//分类名称
            this.configModifyRequest.categoryCode = result.data.categoryCode;//分类代码
            this.configModifyRequest.means = result.data.means;//含义
            this.configModifyRequest.remark = result.data.remark;//备注
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //修改配置
  public configModify():void{
    this.httpService.requestJsonData(ApiConstant.SYS_CONFIG_MODIFY,JSON.stringify(this.configModifyRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('修改配置成功');
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
  public configModifyBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
