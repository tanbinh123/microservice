import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ModuleDetailResponse} from '../../../model/module/ModuleDetailResponse';

@Component({
  selector: 'app-web-module-detail',
  templateUrl: './module.detail.html',
  styleUrls: ['./module.detail.scss'],
  providers:[]
})

export class ModuleDetailComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public moduleDetailResponse:ModuleDetailResponse = new ModuleDetailResponse();//模块详情

  public moduleListModuleTypeFromDictionaryData:any;

  //public moduleNameAndIdListData:any;

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let moduleId = queryParam.moduleId;
      this.moduleDetailResponse.moduleId = moduleId;
      this.getModuleTypeFromDictionary();
      this.moduleDetail(moduleId);
    });
  }

  //模块详情
  public moduleDetail(moduleId:string):void{
    this.httpService.requestJsonData(ApiConstant.SYS_MODULE_DETAIL,null,new Map([['moduleId',moduleId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.moduleDetailResponse.moduleType = result.data.moduleType;//模块类型
            this.moduleDetailResponse.parentId = result.data.parentId;//上级模块ID
            this.moduleDetailResponse.parentName = result.data.parentName==null?'无上级模块':result.data.parentName;//上级模块名称
            this.moduleDetailResponse.moduleName = result.data.moduleName;//模块名
            this.moduleDetailResponse.alias = result.data.alias;//别名
            this.moduleDetailResponse.pageUrl = result.data.pageUrl;//页面URL
            this.moduleDetailResponse.apiUrl = result.data.apiUrl;//api的URL
            this.moduleDetailResponse.icon = result.data.icon;//图标
            this.moduleDetailResponse.orders = result.data.orders;//模块顺序
            this.moduleDetailResponse.remark = result.data.remark;//备注
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //获取模块类型字典数据
  public getModuleTypeFromDictionary():void {
    this.httpService.requestJsonData(ApiConstant.GET_DICTIONARY,JSON.stringify({dataType:'module_type'})).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.moduleListModuleTypeFromDictionaryData = result.data;
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
  public moduleDetailBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
