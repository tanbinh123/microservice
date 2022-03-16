import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { HttpService } from '../../../service/HttpService';
import { AuthService } from '../../../service/AuthService';
import { SessionService } from '../../../service/SessionService';
import { ApiConstant } from '../../../constant/ApiConstant';
import { ResultPage } from '../../../model/ResultPage';
import { RoleListRequest } from '../../../model/role/RoleListRequest';
import { finalize } from 'rxjs';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NzModalService } from 'ng-zorro-antd/modal';

@Component({
  selector: 'app-web-role-list',
  templateUrl: './role.list.html',
  styleUrls: ['./role.list.scss'],
  providers:[NzModalService]
})

export class RoleListComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService,
              public nzMessageService:NzMessageService,
              public nzModalService: NzModalService){
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

  /** 分页及查询 start */
  roleListRequest:RoleListRequest = new RoleListRequest();//角色列表搜索条件
  resultPage:ResultPage = new ResultPage();//分页结果初始化
  loading = false;//数据加载
  /** 分页及查询 end */

  //初始化
  ngOnInit(): void {
    /** 若需修改分页大小或其它请求参数请注释后自行调整，这里使用默认值
    this.roleListRequest.currentPage = 1;
    this.roleListRequest.pageSize = 5;
    */
    this.roleListFunction(this.roleListRequest);//初始化角色列表
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
            this.resultPage = new ResultPage(result.data);
          }else{
            this.nzMessageService.error(result.message);
          }
        },
        error:e => {
          this.nzMessageService.error(e.message);
        },
        complete:() => {
          //do nothing
        }
      }
    );
  }

  //新增角色
  public roleAddFunction():void {
    this.router.navigate(['add'],{relativeTo:this.activatedRoute});
  }

  //删除角色
  public roleDeleteFunction(roleId:string):void {
    this.nzModalService.confirm({
      nzTitle: '删除确认',
      nzContent: '确定删除吗？',
      nzOkText: '确定',
      nzCancelText: '取消',
      nzOnOk: () => {
        this.httpService.requestJsonData(ApiConstant.SYS_ROLE_DELETE, null, new Map([['roleId', roleId]])).subscribe(
          {
            next: (result: any) => {
              //console.log(result);
              if (result.code == 200) {
                this.search(1);
                this.nzMessageService.info('角色删除成功');
              } else {
                this.nzMessageService.error(result.message);
              }
            },
            error: e => {
              this.nzMessageService.error(e.message);
            },
            complete: () => {
              //do nothing
            }
          }
        );
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
