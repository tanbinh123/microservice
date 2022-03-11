import { Component,OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { HttpService } from '../../../service/HttpService';
import { AuthService } from '../../../service/AuthService';
import { SessionService } from '../../../service/SessionService';
import { ApiConstant } from '../../../constant/ApiConstant';
import { RoleAddRequest } from '../../../model/role/RoleAddRequest';
import { MessageService } from "primeng/api";

@Component({
  selector: 'app-web-role-add',
  templateUrl: './role.add.html',
  styleUrls: ['./role.add.scss'],
  providers:[MessageService]
})

export class RoleAddComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService,
              public messageService:MessageService){

  }

  roleAddRequest:RoleAddRequest = new RoleAddRequest();//角色新增

  //初始化
  ngOnInit(): void {

  }

  //新增角色
  addFlag:boolean = false;
  public roleAdd():void{
    this.addFlag = true;
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_ADD,JSON.stringify(this.roleAddRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.messageService.add({severity:'info',summary:'新增',detail:'角色新增成功'});
            setTimeout(()=>{
              this.messageService.clear();
              this.router.navigate(['../'],{relativeTo:this.activatedRoute});
            },1000);
          }else{
            this.messageService.add({severity:'error',summary:'错误',detail:'角色新增失败'});
            setTimeout(()=>{this.messageService.clear()},1000);
            this.addFlag = false;
          }
        },
        error:e => {
          this.addFlag = false;
        },
        complete:() => {}
      }
    );
  }

  //返回
  public roleAddBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
