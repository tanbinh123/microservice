import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ResultPage} from '../../../model/ResultPage';
import {ModuleListRequest} from '../../../model/module/ModuleListRequest';


@Component({
  selector: 'app-web-module-list',
  templateUrl: './module.list.html',
  styleUrls: ['./module.list.scss'],
  providers:[]
})

export class ModuleListComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){
    this.moduleListZone = authService.canShow(ApiConstant.SYS_MODULE_LIST);
    this.moduleDeleteZone = authService.canShow(ApiConstant.SYS_MODULE_DELETE);
    this.moduleAddZone = authService.canShow(ApiConstant.SYS_MODULE_ADD);
    this.moduleModifyZone = authService.canShow(ApiConstant.SYS_MODULE_MODIFY);
    this.moduleDetailZone = authService.canShow(ApiConstant.SYS_MODULE_DETAIL);
  }

  /** 操作权限 start */
  moduleListZone:boolean;//模块列表
  moduleDeleteZone:boolean;//删除模块
  moduleAddZone:boolean;//新增模块
  moduleModifyZone:boolean;//修改模块
  moduleDetailZone:boolean;//模块详情
  /** 操作权限 end */

  public moduleListRequest:ModuleListRequest = new ModuleListRequest();//模块列表搜索条件
  public resultPage:ResultPage = new ResultPage();//分页结果初始化

  public moduleListModuleTypeFromDictionaryData:any;

  //初始化
  ngOnInit(): void {
    /** 若需修改分页大小或其它请求参数请注释后自行调整，这里使用默认值
    this.moduleListRequest.currentPage = 1;
    this.moduleListRequest.pageSize = 5;
    */
    this.moduleListFunction(this.moduleListRequest);//初始化模块列表
    this.getModuleTypeFromDictionary();
  }

  //搜索按钮
  public moduleSearch(currentPage):void{
    this.resultPage = new ResultPage();//对每次搜索初始化分页
    this.moduleListRequest.currentPage = currentPage;
    this.moduleListFunction(this.moduleListRequest);
  }

  //重置
  public reset():void{
    this.moduleListRequest = new ModuleListRequest();
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

  //下拉联动
  public selectChange($event):void {
    //console.log($event.target.value);
    this.moduleListRequest.moduleType = $event.target.value;
  }

  //模块列表
  public moduleListFunction(moduleListRequest:ModuleListRequest):void {
    this.httpService.requestJsonData(ApiConstant.SYS_MODULE_LIST,JSON.stringify(moduleListRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            let ret = result.data;
            this.resultPage = new ResultPage(ret);
          }else{
            this.router.navigate(['webLogin']);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //新增模块
  public moduleAddFunction():void {
    this.router.navigate(['add'],{relativeTo:this.activatedRoute});
  }

  //删除模块
  public moduleDeleteFunction(moduleId:string):void {
    this.httpService.requestJsonData(ApiConstant.SYS_MODULE_DELETE,null,new Map([['moduleId',moduleId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.moduleSearch(1);
            alert('模块删除成功');
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //模块详情
  public moduleDetailFunction(moduleId:string):void {
    this.router.navigate(['detail'],{relativeTo:this.activatedRoute,queryParams:{moduleId:moduleId}});
  }

  //修改用户
  public moduleModifyFunction(moduleId:string):void {
    this.router.navigate(['modify'],{relativeTo:this.activatedRoute,queryParams:{moduleId:moduleId}});
  }

}
