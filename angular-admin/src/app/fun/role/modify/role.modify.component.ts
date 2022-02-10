import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {UserModifyRequest} from '../../../model/user/UserModifyRequest';
import {RoleModifyRequest} from '../../../model/role/RoleModifyRequest';

@Component({
  selector: 'app-web-role-modify',
  templateUrl: './role.modify.html',
  styleUrls: ['./role.modify.scss'],
  providers:[]
})

export class RoleModifyComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

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
  public roleModify():void{
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_MODIFY,JSON.stringify(this.roleModifyRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('修改角色成功');
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
  public roleModifyBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
