import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ModuleModifyRequest} from '../../../model/module/ModuleModifyRequest';
import {CommonConstant} from '../../../constant/CommonConstant';

@Component({
  selector: 'app-web-module-modify',
  templateUrl: './module.modify.html',
  styleUrls: ['./module.modify.scss'],
  providers:[]
})

export class ModuleModifyComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  moduleModifyRequest:ModuleModifyRequest = new ModuleModifyRequest();//模块修改
  moduleListModuleTypeFromDictionaryData:any;
  moduleNameAndIdListData:any;
  pageUrlFlag:boolean = true;
  apiUrlFlag:boolean = true;

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let moduleId = queryParam.moduleId;
      this.moduleModifyRequest.moduleId = moduleId;
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
            this.getModuleTypeFromDictionary();
            this.moduleModifyRequest.moduleType = result.data.moduleType;//模块类型
            this.moduleModifyRequest.parentId = result.data.parentId;//上级模块ID
            this.moduleModifyRequest.moduleName = result.data.moduleName;//模块名
            this.moduleModifyRequest.alias = result.data.alias;//别名
            this.moduleModifyRequest.pageUrl = result.data.pageUrl;//页面URL
            this.moduleModifyRequest.apiUrl = result.data.apiUrl;//api的URL
            this.moduleModifyRequest.icon = result.data.icon;//图标
            this.moduleModifyRequest.orders = result.data.orders;//模块顺序
            this.moduleModifyRequest.remark = result.data.remark;//备注
            this.radioChange(null,this.moduleModifyRequest.moduleType);
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

  //单选联动事件
  public radioChange($event,moduleType):void {
    if(moduleType==1){//目录
      this.pageUrlFlag = true;
      this.apiUrlFlag = true;
    }else if(moduleType==2){//菜单
      this.pageUrlFlag = false;
      this.apiUrlFlag = true;
    }else if(moduleType==3){//功能
      this.pageUrlFlag = true;
      this.apiUrlFlag = false;
    }
    this.moduleModifyRequest.moduleType = moduleType;
    //获得上级模块
    this.httpService.requestJsonData(ApiConstant.SYS_MODULE_MODULE_ID_AND_NAME_LIST,null,new Map([['moduleType',moduleType]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.moduleNameAndIdListData = result.data;
            /** 这是新增时的处理，修改不需要
            if(moduleType==1){
              this.moduleModifyRequest.parentId = CommonConstant.EMPTY;
            }else{
              try {
                this.moduleModifyRequest.parentId = this.moduleNameAndIdListData[0].moduleId;//第一个总是默认被选中的
              }catch (e) {
                this.moduleModifyRequest.parentId = CommonConstant.EMPTY;
              }
            }
            */
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //下拉联动事件
  public selectChange($event):void {
    this.moduleModifyRequest.parentId = $event.target.value;
  }

  //修改模块
  public moduleModify():void{
    //console.log(this.moduleModifyRequest.parentId);
    this.httpService.requestJsonData(ApiConstant.SYS_MODULE_MODIFY,JSON.stringify(this.moduleModifyRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('修改模块成功');
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
  public moduleModifyBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
