import {Component,OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { HttpService } from '../../../service/HttpService';
import { AuthService } from '../../../service/AuthService';
import { SessionService } from '../../../service/SessionService';
import { ApiConstant } from '../../../constant/ApiConstant';
import { RoleModifyRequest } from '../../../model/role/RoleModifyRequest';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NgZorroValidatorUtil } from '../../../util/NgZorroValidatorUtil';
import { finalize } from 'rxjs';

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
              public sessionService:SessionService,
              public formBuilder:FormBuilder,
              public nzMessageService:NzMessageService){
    //do nothing
  }

  validateForm!:FormGroup;
  loading = false;//数据加载
  roleModifyRequest:RoleModifyRequest = new RoleModifyRequest();//角色修改

  //初始化
  ngOnInit(): void {
    this.initValidateForm();
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let roleId = queryParam.roleId;
      this.roleModifyRequest.roleId = roleId;
      this.roleDetail(roleId);
    });
  }
  public initValidateForm():void {
    this.validateForm = this.formBuilder.group({
      roleName: [null, [NgZorroValidatorUtil.empty]],
      roleCode: [null, [NgZorroValidatorUtil.empty]],
      remark: [null]
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
    if (this.validateForm.valid) {
      this.loading=true;
      this.httpService.requestJsonData(ApiConstant.SYS_ROLE_MODIFY,JSON.stringify(this.roleModifyRequest))
        .pipe(finalize(()=>this.loading=false)).subscribe({
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.nzMessageService.success('角色修改成功');
            this.router.navigate(['../'],{relativeTo:this.activatedRoute});
          }else{
            this.nzMessageService.error('角色修改失败');
          }
        },
        error:e => {
          this.nzMessageService.error(e.message);
        },
        complete:() => {
          //do nothing
        }
      })
    } else {
      Object.values(this.validateForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }

  //返回
  public roleModifyBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
