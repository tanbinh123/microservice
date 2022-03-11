import {Component,OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { HttpService } from '../../../service/HttpService';
import { AuthService } from '../../../service/AuthService';
import { SessionService } from '../../../service/SessionService';
import { ApiConstant } from '../../../constant/ApiConstant';
import { RoleModifyRequest } from '../../../model/role/RoleModifyRequest';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-web-role-modify',
  templateUrl: './role.modify.html',
  styleUrls: ['./role.modify.scss'],
  providers:[MessageService]
})

export class RoleModifyComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService,
              public messageService:MessageService){

  }

  public roleModifyRequest:RoleModifyRequest = new RoleModifyRequest();//角色修改

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let roleId = queryParam.roleId;
      this.roleModifyRequest.roleId = roleId;
      this.roleDetail(roleId);
    });
  }

  //角色详情
  public roleDetail(roleId:string):void{
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_DETAIL,null,new Map([['roleId',roleId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.roleModifyRequest.roleName = result.data.roleName;//角色名称
            this.roleModifyRequest.roleCode = result.data.roleCode;//角色代码
            this.roleModifyRequest.remark = result.data.remark;//备注
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //修改角色
  modifyFlag:boolean = false;
  public roleModify():void{
    this.modifyFlag = true;
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_MODIFY,JSON.stringify(this.roleModifyRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.messageService.add({severity:'info',summary:'修改',detail:'角色修改成功'});
            setTimeout(()=>{
              this.messageService.clear();
              this.router.navigate(['../'],{relativeTo:this.activatedRoute});
            },1000);
          }else{
            this.messageService.add({severity:'error',summary:'错误',detail:'角色修改失败'});
            setTimeout(()=>{this.messageService.clear()},1000);
            this.modifyFlag = false;
          }
        },
        error:e => {
          this.modifyFlag = false;
        },
        complete:() => {}
      }
    );
  }

  //返回
  public roleModifyBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
