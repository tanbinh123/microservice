import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ResultPage} from '../../../model/ResultPage';
import {ConfigListRequest} from '../../../model/config/ConfigListRequest';


@Component({
  selector: 'app-web-config-list',
  templateUrl: './config.list.html',
  styleUrls: ['./config.list.scss'],
  providers:[]
})

export class ConfigListComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){
    this.configListZone = authService.canShow(ApiConstant.SYS_CONFIG_LIST);
    this.configDeleteZone = authService.canShow(ApiConstant.SYS_CONFIG_DELETE);
    this.configAddZone = authService.canShow(ApiConstant.SYS_CONFIG_ADD);
    this.configModifyZone = authService.canShow(ApiConstant.SYS_CONFIG_MODIFY);
    this.configDetailZone = authService.canShow(ApiConstant.SYS_CONFIG_DETAIL);
  }

  /** 操作权限 start */
  configListZone:boolean;//配置列表
  configDeleteZone:boolean;//删除配置
  configAddZone:boolean;//新增配置
  configModifyZone:boolean;//修改配置
  configDetailZone:boolean;//配置详情
  /** 操作权限 end */

  public configListRequest:ConfigListRequest = new ConfigListRequest();//配置列表搜索条件
  public resultPage:ResultPage = new ResultPage();//分页结果初始化

  //初始化
  ngOnInit(): void {
    /** 若需修改分页大小或其它请求参数请注释后自行调整，这里使用默认值
    this.configListRequest.currentPage = 1;
    this.configListRequest.pageSize = 5;
    */
    this.configListFunction(this.configListRequest);//初始化配置列表
  }

  //搜索按钮
  public configSearch(currentPage):void{
    this.resultPage = new ResultPage();//对每次搜索初始化分页
    this.configListRequest.currentPage = currentPage;
    this.configListFunction(this.configListRequest);
  }

  //重置
  public reset():void{
    this.configListRequest = new ConfigListRequest();
  }

  //配置列表
  public configListFunction(configListRequest:ConfigListRequest):void {
    this.httpService.requestJsonData(ApiConstant.SYS_CONFIG_LIST,JSON.stringify(configListRequest)).subscribe(
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

  //新增配置
  public configAddFunction():void {
    this.router.navigate(['add'],{relativeTo:this.activatedRoute});
  }

  //删除配置
  public configDeleteFunction(configId:string):void {
    this.httpService.requestJsonData(ApiConstant.SYS_CONFIG_DELETE,null,new Map([['configId',configId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.configSearch(1);
            alert('配置删除成功');
          }else{
            alert('配置删除失败');
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //配置详情
  public configDetailFunction(configId:string):void {
    this.router.navigate(['detail'],{relativeTo:this.activatedRoute,queryParams:{configId:configId}});
  }

  //修改配置
  public configModifyFunction(configId:string):void {
    this.router.navigate(['modify'],{relativeTo:this.activatedRoute,queryParams:{configId:configId}});
  }

}
