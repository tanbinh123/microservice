import {Component, inject, Input, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {UserRoleAssignmentRequest} from '../../../model/user/UserRoleAssignmentRequest';


@Component({
  selector: 'app-web-user-user-role-assignment',
  templateUrl: './user.userRoleAssignment.html',
  styleUrls: ['./user.userRoleAssignment.scss'],
  providers:[]
})

export class UserRoleAssignmentComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public needUserId:string;

  public userRoleInfoData:any;

  public userRoleStrategyFromDictionaryData:any;

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let userId = queryParam.userId;
      this.needUserId = userId;
      this.userRoleInfo();
    });
  }

  //获取用户角色列表
  public userRoleInfo():void {
    this.httpService.requestJsonData(ApiConstant.SYS_USER_ROLE_INFO,null,new Map([['userId',this.needUserId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.userRoleInfoData = result.data;
            this.getStrategyFromDictionary();
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //用户角色分配
  public userRoleAssignment():void {
    let array:Array<UserRoleAssignmentRequest> = new Array<UserRoleAssignmentRequest>();
    let _userRoleInfoData = this.userRoleInfoData;
    //console.log(_userRoleInfoData);
    for(let i=0;i<_userRoleInfoData.length;i++){
      if(_userRoleInfoData[i].checkFlag){
        let userRoleAssignmentRequest:UserRoleAssignmentRequest = new UserRoleAssignmentRequest();
        userRoleAssignmentRequest.roleId = _userRoleInfoData[i].roleId;
        userRoleAssignmentRequest.moduleStrategy = _userRoleInfoData[i].moduleStrategy;
        userRoleAssignmentRequest.dataStrategy = _userRoleInfoData[i].dataStrategy;
        array.push(userRoleAssignmentRequest);
      }
    }
    //console.log(JSON.stringify(array));
    this.httpService.requestJsonData(ApiConstant.SYS_USER_ROLE_ASSIGNMENT,JSON.stringify(array),new Map([['userId',this.needUserId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('用户角色分配成功');
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

  //获取策略字典数据
  public getStrategyFromDictionary():void {
    this.httpService.requestJsonData(ApiConstant.GET_DICTIONARY,JSON.stringify({dataType:'user_role_strategy'})).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.userRoleStrategyFromDictionaryData = result.data;
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //下拉联动
  public selectChangeModule($event,eachData:any):void {
    //console.log($event.target.value);
    eachData.moduleStrategy = $event.target.value;
  }
  public selectChangeData($event,eachData:any):void {
    //console.log($event.target.value);
    eachData.dataStrategy = $event.target.value;
  }

  //返回
  public userRoleAssignmentBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
