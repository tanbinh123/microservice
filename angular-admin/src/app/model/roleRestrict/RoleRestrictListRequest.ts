import {CommonConstant} from '../../constant/CommonConstant';

export class RoleRestrictListRequest {

  roleName:string = CommonConstant.EMPTY;//角色名

  province:string = CommonConstant.EMPTY;//省（不限为all，本省为self）

  city:string = CommonConstant.EMPTY;//市（不限为all，本市为self）
  
  district:string = CommonConstant.EMPTY;//区（不限为all，本区为self）

  currentPage = 1;//当前页数

  pageSize = 10;//每页显示多少条

}
