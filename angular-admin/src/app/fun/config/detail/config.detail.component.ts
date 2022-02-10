import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ConfigDetailResponse} from '../../../model/config/ConfigDetailResponse';

@Component({
  selector: 'app-web-config-detail',
  templateUrl: './config.detail.html',
  styleUrls: ['./config.detail.scss'],
  providers:[]
})

export class ConfigDetailComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService) {

  }

  public configDetailResponse:ConfigDetailResponse = new ConfigDetailResponse();//配置详情

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let configId = queryParam.configId;
      this.configDetailResponse.id = configId;
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
            this.configDetailResponse.dataType = result.data.dataType;//数据类型
            this.configDetailResponse.keyCode = result.data.keyCode;//key值
            this.configDetailResponse.valueCode = result.data.valueCode;//value值
            this.configDetailResponse.categoryName = result.data.categoryName;//分类名称
            this.configDetailResponse.categoryCode = result.data.categoryCode;//分类代码
            this.configDetailResponse.means = result.data.means;//含义
            this.configDetailResponse.remark = result.data.remark;//备注
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //返回
  public configDetailBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
