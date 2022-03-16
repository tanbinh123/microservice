import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { HttpService } from '../../../service/HttpService';
import { AuthService } from '../../../service/AuthService';
import { SessionService } from '../../../service/SessionService';
import { ApiConstant } from '../../../constant/ApiConstant';
import { NzFormatEmitEvent } from 'ng-zorro-antd/tree';
import { NzMessageService } from 'ng-zorro-antd/message';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-web-role-role-module-assignment',
  templateUrl: './role.roleModuleAssignment.html',
  styleUrls: ['./role.roleModuleAssignment.scss'],
  providers:[]
})

export class RoleModuleAssignmentComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService,
              public nzMessageService:NzMessageService){
    //do nothing
  }

  //引入子组件（若使用子组件中的静态变量则不需要引入）
  //@ViewChild('userModuleAssignmentModuleRecursionComponent',{static:false})
  //userModuleAssignmentModuleRecursionComponent:UserModuleAssignmentModuleRecursionComponent;

  loading = false;//数据加载
  needRoleId:string;
  moduleTree:any;
  idList:Array<string> = new Array<string>();
  checkedKeys:Array<string> = [];
  nzCheckBoxChangeEvent:NzFormatEmitEvent;

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let roleId = queryParam.roleId;
      this.needRoleId = roleId;
      this.roleModuleInfo();
    });
  }

  //获取角色模块信息
  public roleModuleInfo():void {
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_MODULE_INFO,null,new Map([['roleId',this.needRoleId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.idList = result.data.filter(e=>e.checkFlag==true).map(e=>e.moduleId);//数据库原始数据
            this.moduleTree = this.setTreeList(result.data,null);//组件的树形结构封装
            /** 真正的checkedKeys集合 start */
            this.checkedKeys = result.data.filter(e => (e.checkFlag==true)&&(e.level==3)).map(e=>e.moduleId);//勾选的checkbox
            this.specHandleCheckedKeys(this.moduleTree);//特殊处理，递归获取级别是2（菜单）的且没有子节点的
            /** 真正的checkedKeys集合 end */
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

  //checkbox勾选事件
  public nzCheckBoxChange(event: NzFormatEmitEvent){
    this.nzCheckBoxChangeEvent = event;
  }

  //角色模块分配
  public roleModuleAssignment():void{
    this.getCheckedIds();
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_MODULE_ASSIGNMENT,JSON.stringify(this.idList),new Map([['roleId',this.needRoleId]]))
      .pipe(finalize(()=>this.loading=false)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.nzMessageService.success('角色模块分配成功');
            this.router.navigate(['../'],{relativeTo:this.activatedRoute});
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
  public roleModuleAssignmentBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

  private specHandleCheckedKeys(moduleTree:any):void {
    if(moduleTree!=null&&moduleTree.length>0){
      for(let i=0;i<moduleTree.length;i++){
        let each = moduleTree[i];
        if(each.level==2&&each.seflChecked==true&&each.children==null){
          this.checkedKeys.push(each.key);
        }else{
          this.specHandleCheckedKeys(each.children);
        }
      }
    }
  }

  private getCheckedIds():void{
    if(this.nzCheckBoxChangeEvent != undefined){
      let keys = this.nzCheckBoxChangeEvent.checkedKeys;
      this.idList = new Array<string>();
      if(keys.length>0){
        this.getChildrenIdList(keys);
        for(let i=0;i<keys.length;i++){
          this.getParentIdList(keys[i]);
        }
        this.idList = Array.from(new Set(this.idList));//去重
      }
    }
    //console.log(this.idList);
  }

  private getChildrenIdList(keys:any):void{
    for(let i=0;i<keys.length;i++){
      let eachKey = keys[i];
      if(eachKey.children==null||eachKey.children.length==0){//无子节点
        this.idList.push(eachKey.key);
      }else{
        this.idList.push(eachKey.key);
        this.getChildrenIdList(eachKey.children);
      }
    }
  }

  private getParentIdList(key:any):void{
    if(key.parentNode!=null){//有父节点
      this.idList.push(key.key);
      this.getParentIdList(key.parentNode);
    }else{
      this.idList.push(key.key);
    }
  }

  //树形结构递归封装符合NgZorro框架中Tree组件的数据格式要求（这里后端返回的moduleTree并未封装成树形，主要考虑到以后如果换前端组件，可能数据格式又是另一个了）
  private setTreeList(moduleTree:any,eachMenu:any):any {
    let menuList:Array<any> = [];
    for(let i=0;i<moduleTree.length;i++) {
      let currentEach = moduleTree[i];
      let changeEach = {
        'key': currentEach.moduleId,
        'title': currentEach.moduleName,
        'expanded': (currentEach.level == 1),
        'level': currentEach.level,
        'isLeaf': (currentEach.level == 3),
        'seflChecked': currentEach.checkFlag
      };
      if((eachMenu!=null&&eachMenu.moduleId==currentEach.parentId)||(eachMenu==null&&currentEach.parentId==null)) {
        changeEach['children'] = this.setTreeList(moduleTree,currentEach);
        if(changeEach['children']==null){
          changeEach['isLeaf'] = true;
        }
        menuList.push(changeEach);
      }
    }
    if(menuList.length==0){
      menuList = null;
    }
    return menuList;
  }

}
