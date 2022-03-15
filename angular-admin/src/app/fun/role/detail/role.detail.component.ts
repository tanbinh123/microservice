import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { HttpService } from '../../../service/HttpService';
import { AuthService } from '../../../service/AuthService';
import { SessionService } from '../../../service/SessionService';
import { ApiConstant } from '../../../constant/ApiConstant';
import { RoleDetailResponse } from '../../../model/role/RoleDetailResponse';
import {NzMessageService} from 'ng-zorro-antd/message';

@Component({
  selector: 'app-web-role-detail',
  templateUrl: './role.detail.html',
  styleUrls: ['./role.detail.scss'],
  providers:[]
})

export class RoleDetailComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService,
              public nzMessageService:NzMessageService){
    //do nothing
  }

  roleDetailResponse:RoleDetailResponse = new RoleDetailResponse();//角色详情

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let roleId = queryParam.roleId;
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
            this.roleDetailResponse.roleName = result.data.roleName;//角色名称
            this.roleDetailResponse.roleCode = result.data.roleCode;//角色代码
            this.roleDetailResponse.remark = result.data.remark;//备注
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

  //返回
  public roleDetailBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
