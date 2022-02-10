import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {UserModuleAssignmentModuleRecursionComponent} from './user.userModuleAssignment.module.recursion.component';
import {UserModuleAssignmentRequest} from '../../../model/user/UserModuleAssignmentRequest';

@Component({
  selector: 'app-web-user-user-module-assignment',
  templateUrl: './user.userModuleAssignment.html',
  styleUrls: ['./user.userModuleAssignment.scss'],
  providers:[]
})

export class UserModuleAssignmentComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public needUserId:string;

  public moduleTree:any;

  public userModuleAssignmentRequest:UserModuleAssignmentRequest = new UserModuleAssignmentRequest();//用户模块分配

  //引入子组件（若使用子组件中的静态变量则不需要引入）
  //@ViewChild('userModuleAssignmentModuleRecursionComponent',{static:false})
  //public userModuleAssignmentModuleRecursionComponent:UserModuleAssignmentModuleRecursionComponent;

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let userId = queryParam.userId;
      this.needUserId = userId;
      this.userModuleInfo();
    });
  }

  //获取用户模块信息
  public userModuleInfo():void {
    this.httpService.requestJsonData(ApiConstant.SYS_USER_MODULE_INFO,null,new Map([['userId',this.needUserId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.moduleTree = result.data;
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //用户模块分配
  public userModuleAssignment():void{
    //console.log(UserModuleAssignmentModuleRecursionComponent.idList);
    this.userModuleAssignmentRequest.userId = this.needUserId;
    this.userModuleAssignmentRequest.list = UserModuleAssignmentModuleRecursionComponent.idList;
    this.httpService.requestJsonData(ApiConstant.SYS_USER_MODULE_ASSIGNMENT,JSON.stringify(this.userModuleAssignmentRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('用户模块分配成功');
            UserModuleAssignmentModuleRecursionComponent.idList = [];//分配成功清空子组件中静态变量的值
            this.router.navigate(['../'],{relativeTo:this.activatedRoute});
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //返回
  public userModuleAssignmentBack():void{
    UserModuleAssignmentModuleRecursionComponent.idList = [];//点击返回清空子组件中静态变量的值
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
