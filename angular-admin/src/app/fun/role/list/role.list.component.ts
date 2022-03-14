import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { HttpService } from '../../../service/HttpService';
import { AuthService } from '../../../service/AuthService';
import { SessionService } from '../../../service/SessionService';
import { ApiConstant } from '../../../constant/ApiConstant';
import { ResultPage } from '../../../model/ResultPage';
import { RoleListRequest } from '../../../model/role/RoleListRequest';
import { ConfirmationService, ConfirmEventType, Message, MessageService } from 'primeng/api';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-web-role-list',
  templateUrl: './role.list.html',
  styleUrls: ['./role.list.scss'],
  providers:[ConfirmationService,MessageService]
})

export class RoleListComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService,
              public confirmationService:ConfirmationService,
              public messageService:MessageService){
    this.roleListZone = authService.canShow(ApiConstant.SYS_ROLE_LIST);
    this.roleDeleteZone = authService.canShow(ApiConstant.SYS_ROLE_DELETE);
    this.roleAddZone = authService.canShow(ApiConstant.SYS_ROLE_ADD);
    this.roleModifyZone = authService.canShow(ApiConstant.SYS_ROLE_MODIFY);
    this.roleDetailZone = authService.canShow(ApiConstant.SYS_ROLE_DETAIL);
    this.roleModuleAssignmentZone = authService.canShow(ApiConstant.SYS_ROLE_MODULE_ASSIGNMENT);
  }

  /** 操作权限 start */
  roleListZone:boolean;//角色列表
  roleDeleteZone:boolean;//删除角色
  roleAddZone:boolean;//新增角色
  roleModifyZone:boolean;//修改角色
  roleDetailZone:boolean;//角色详情
  roleModuleAssignmentZone:boolean;//角色模块分配
  /** 操作权限 end */

  public roleListRequest:RoleListRequest = new RoleListRequest();//角色列表搜索条件
  public resultPage:ResultPage = new ResultPage();//分页结果初始化
  public loading = false;//数据加载

  //初始化
  ngOnInit(): void {
    /** 若需修改分页大小或其它请求参数请注释后自行调整，这里使用默认值
    this.roleListRequest.currentPage = 1;
    this.roleListRequest.pageSize = 5;
    */
    this.roleListFunction(this.roleListRequest);//初始化用户列表
  }

  //搜索按钮
  public search(currentPage):void{
    this.resultPage = new ResultPage();//对每次搜索初始化分页
    this.roleListRequest.currentPage = currentPage;
    this.roleListFunction(this.roleListRequest);
  }

  //重置
  public reset():void{
    this.roleListRequest = new RoleListRequest();
  }

  //角色列表
  public roleListFunction(roleListRequest:RoleListRequest):void {
    this.loading = true;
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_LIST,JSON.stringify(roleListRequest))
      .pipe(finalize(()=>this.loading=false)).subscribe({
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

  //新增角色
  public roleAddFunction():void {
    this.router.navigate(['add'],{relativeTo:this.activatedRoute});
  }

  //删除角色
  public roleDeleteFunction(roleId:string):void {
    this.confirmationService.confirm({
      message: '您确定要删除该条记录吗？',
      header: '删除确认',
      icon: 'pi pi-exclamation-triangle',
      key: 'deleteRoleButtonDialog_'+roleId,
      accept: () => {
        this.httpService.requestJsonData(ApiConstant.SYS_ROLE_DELETE,null,new Map([['roleId',roleId]])).subscribe(
          {
            next:(result:any) => {
              //console.log(result);
              if(result.code==200){
                this.search(1);
                this.messageService.add({severity:'info',summary:'确定',detail:'角色删除成功'});
                setTimeout(()=>{this.messageService.clear()},1000);
              }else{
                this.messageService.add({severity:'error',summary:'错误',detail:'角色删除失败'});
                setTimeout(()=>{this.messageService.clear()},1000);
              }
            },
            error:e => {},
            complete:() => {}
          }
        );
      },
      reject: (type) => {
        //case ConfirmEventType.REJECT,case ConfirmEventType.CANCEL
        this.messageService.add({severity:'warn',summary:'取消',detail:'取消删除'});
        setTimeout(()=>{this.messageService.clear()},1000);
      }
    });
  }

  //角色详情
  public roleDetailFunction(roleId:string):void {
    this.router.navigate(['detail'],{relativeTo:this.activatedRoute,queryParams:{roleId:roleId}});
  }

  //修改角色
  public roleModifyFunction(roleId:string):void {
    this.router.navigate(['modify'],{relativeTo:this.activatedRoute,queryParams:{roleId:roleId}});
  }

  //角色模块分配
  public roleModuleAssignmentFunction(roleId:string):void {
    this.router.navigate(['roleModuleAssignment'],{relativeTo:this.activatedRoute,queryParams:{roleId:roleId}});
  }

}
