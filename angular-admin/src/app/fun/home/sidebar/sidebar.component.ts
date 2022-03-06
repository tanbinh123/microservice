import { Component, OnInit } from '@angular/core';
import { SessionService } from '../../../service/SessionService';
import { MenuItem/*, PrimeIcons*/ } from 'primeng/api';

@Component({
  selector: 'app-web-home-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  public items: MenuItem[];//组件写法
  //public menuListForTree:any;//原生写法

  constructor(public sessionService:SessionService) {

  }

  ngOnInit(): void {
    let tokenData:any = this.sessionService.getTokenData();
    let menuListForTree:any = tokenData.menuListForTree;
    //console.log(menuListForTree);
    this.items = this.setTreeList(menuListForTree,null);//组件写法
    //this.menuListForTree = tokenData.menuListForTree;//原生写法
  }

  //树形结构递归封装符合PrimeNG框架中PanelMenu组件的数据格式要求（这里后端返回的menuListForTree并未封装成树形，主要考虑到以后如果换前端组件，可能数据格式又是另一个了）
  private setTreeList(menuListForTree:any,eachMenu:any):any {
    let menuList:Array<any> = [];
    for(let i=0;i<menuListForTree.length;i++) {
      let currentEach = menuListForTree[i];
      let changeEach = {"label":currentEach.moduleName,"icon":currentEach.icon,"routerLink":currentEach.pageUrl};
      if((eachMenu!=null&&eachMenu.moduleId==currentEach.parentId)||(eachMenu==null&&currentEach.parentId==null)) {
        changeEach['items'] = this.setTreeList(menuListForTree,currentEach);
        menuList.push(changeEach);
      }
    }
    if(menuList.length==0){
      menuList = null;
    }
    return menuList;
  }

}
