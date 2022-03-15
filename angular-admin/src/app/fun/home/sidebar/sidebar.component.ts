import { Component, OnInit } from '@angular/core';
import { SessionService } from '../../../service/SessionService';
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-web-home-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  public menus = [];//组件写法
  public mode = false;//组件写法
  public dark = false;//组件写法
  //public menuListForTree:any;//原生写法

  constructor(public sessionService:SessionService,public router:Router,public activatedRoute:ActivatedRoute) {

  }

  ngOnInit(): void {
    let tokenData:any = this.sessionService.getTokenData();
    let menuListForTree:any = tokenData.menuListForTree;
    //console.log(menuListForTree);
    this.menus = this.setTreeList(menuListForTree,null);//组件写法
    //this.menuListForTree = tokenData.menuListForTree;//原生写法
  }

  //树形结构递归封装符合NgZorro框架中Menu组件的数据格式要求（这里后端返回的menuListForTree并未封装成树形，主要考虑到以后如果换前端组件，可能数据格式又是另一个了）
  private setTreeList(menuListForTree:any,eachMenu:any):any {
    let menuList:Array<any> = [];
    for(let i=0;i<menuListForTree.length;i++) {
      let currentEach = menuListForTree[i];
      let changeEach = {'title':currentEach.moduleName,'icon':currentEach.icon,'open':false,'selected':false,'disabled':false,'level':currentEach.level,'url':currentEach.pageUrl};
      if((eachMenu!=null&&eachMenu.moduleId==currentEach.parentId)||(eachMenu==null&&currentEach.parentId==null)) {
        changeEach['children'] = this.setTreeList(menuListForTree,currentEach);
        menuList.push(changeEach);
      }
    }
    if(menuList.length==0){
      menuList = null;
    }
    return menuList;
  }

  public menuClick(menu):void {
    //console.log(menu);
    this.router.navigate([menu.url],{relativeTo:this.activatedRoute});
  }

}
