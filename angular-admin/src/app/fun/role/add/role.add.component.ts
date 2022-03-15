import { Component,OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { HttpService } from '../../../service/HttpService';
import { AuthService } from '../../../service/AuthService';
import { SessionService } from '../../../service/SessionService';
import { ApiConstant } from '../../../constant/ApiConstant';
import { RoleAddRequest } from '../../../model/role/RoleAddRequest';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NgZorroValidatorUtil } from '../../../util/NgZorroValidatorUtil';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-web-role-add',
  templateUrl: './role.add.html',
  styleUrls: ['./role.add.scss'],
  providers:[]
})

export class RoleAddComponent implements OnInit {

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
  roleAddRequest:RoleAddRequest = new RoleAddRequest();//角色新增

  //初始化
  ngOnInit(): void {
    this.initValidateForm();
  }

  public initValidateForm():void {
    this.validateForm = this.formBuilder.group({
      roleName: [null, [NgZorroValidatorUtil.empty]],
      roleCode: [null, [NgZorroValidatorUtil.empty]],
      remark: [null]
    });
  }

  //新增角色
  public roleAdd():void{
    if (this.validateForm.valid) {
      this.loading=true;
      this.httpService.requestJsonData(ApiConstant.SYS_ROLE_ADD,JSON.stringify(this.roleAddRequest))
        .pipe(finalize(()=>this.loading=false)).subscribe({
          next:(result:any) => {
            //console.log(result);
            if(result.code==200){
              this.nzMessageService.success('角色新增成功');
              this.router.navigate(['../'],{relativeTo:this.activatedRoute});
            }else{
              this.nzMessageService.error('角色新增失败');
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
  public roleAddBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
