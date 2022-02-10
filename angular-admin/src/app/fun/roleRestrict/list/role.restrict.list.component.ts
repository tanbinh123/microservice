import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ResultPage} from '../../../model/ResultPage';
import {RoleRestrictListRequest} from 'src/app/model/roleRestrict/RoleRestrictListRequest';
import {CommonConstant} from 'src/app/constant/CommonConstant';

@Component({
  selector: 'app-web-role-restrict-list',
  templateUrl: './role.restrict.list.html',
  styleUrls: ['./role.restrict.list.scss'],
  providers:[]
})

export class RoleRestrictListComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){
    this.roleRestrictListZone = authService.canShow(ApiConstant.SYS_ROLE_RESTRICT_LIST);
    this.roleRestrictAddZone = authService.canShow(ApiConstant.SYS_ROLE_RESTRICT_ADD);
    this.roleRestrictDeleteZone = authService.canShow(ApiConstant.SYS_ROLE_RESTRICT_DELETE);
    this.roleRestrictModifyZone = authService.canShow(ApiConstant.SYS_ROLE_RESTRICT_MODIFY);
    this.roleRestrictDetailZone = authService.canShow(ApiConstant.SYS_ROLE_RESTRICT_DETAIL);
  }

  /** 操作权限 start */
  roleRestrictListZone:boolean;//角色限定列表
  roleRestrictAddZone:boolean;//新增角色限定
  roleRestrictDeleteZone:boolean;//删除角色限定
  roleRestrictModifyZone:boolean;//修改角色限定
  roleRestrictDetailZone:boolean;//角色限定详情
  /** 操作权限 end */

  roleRestrictListRequest:RoleRestrictListRequest = new RoleRestrictListRequest();//角色限定列表搜索条件
  resultPage:ResultPage = new ResultPage();//分页结果初始化
  getProvinceData:any;
  getCityData:any;
  getDistrictData:any;
  provinceDisableTag:boolean = true;
  cityDisableTag:boolean = true;

  //初始化
  ngOnInit(): void {
    /** 若需修改分页大小或其它请求参数请注释后自行调整，这里使用默认值
    this.operationLogListRequest.currentPage = 1;
    this.operationLogListRequest.pageSize = 5;
    */
    this.reset();
    this.roleRestrictListFunction(this.roleRestrictListRequest);//初始化角色限定列表
  }

  //搜索按钮
  public roleRestrictSearch(currentPage):void{
    this.resultPage = new ResultPage();//对每次搜索初始化分页
    this.roleRestrictListRequest.currentPage = currentPage;
    this.roleRestrictListFunction(this.roleRestrictListRequest);
  }

  //重置
  public reset():void{
    this.getProvinceData = null;
    this.getCityData = null;
    this.getDistrictData = null;
    this.provinceDisableTag = true;
    this.cityDisableTag = true;
    this.getProvince();
    //this.getCity(provinceCode);
    //this.getDistrict(cityCode);
    this.roleRestrictListRequest = new RoleRestrictListRequest();
  }

  //角色限定列表
  public roleRestrictListFunction(roleRestrictListRequest:RoleRestrictListRequest):void {
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_RESTRICT_LIST,JSON.stringify(roleRestrictListRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            let ret = result.data;
            this.resultPage = new ResultPage(ret);
          }else{
            this.router.navigate(['webLogin']);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //省下拉
  public selectChangeProvince($event):void{
    let provinceCode = $event.target.value;
    if(provinceCode==null||provinceCode==''){
      this.getCityData = null;
      this.getDistrictData = null;
      this.provinceDisableTag = true;
      this.cityDisableTag = true;
      this.roleRestrictListRequest.province = CommonConstant.EMPTY;
      this.roleRestrictListRequest.city = CommonConstant.EMPTY;
      this.roleRestrictListRequest.district = CommonConstant.EMPTY;
    }else{
      this.roleRestrictListRequest.province = provinceCode;
      this.getCity(provinceCode);
      this.provinceDisableTag = false;
      this.cityDisableTag = true;
    }
  }

  //市下拉
  public selectChangeCity($event):void{
    let cityCode = $event.target.value;
    if(cityCode==null||cityCode==''){
      this.getDistrictData = null;
      this.cityDisableTag = true;
      this.roleRestrictListRequest.city = CommonConstant.EMPTY;
      this.roleRestrictListRequest.district = CommonConstant.EMPTY;
    }else{
      this.roleRestrictListRequest.city = cityCode;
      this.getDistrict(cityCode);
      this.cityDisableTag = false;
    }
  }

  //区下拉
  public selectChangeDistrict($event):void{
    let districtCode = $event.target.value;
    if(districtCode==null||districtCode==''){
      this.roleRestrictListRequest.district = CommonConstant.EMPTY;
    }else{
      this.roleRestrictListRequest.district = districtCode;
    }
  }

  //省
  public getProvince():void{
    this.getProvinceData = null;
    this.getCityData = null;
    this.getDistrictData = null;
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_RESTRICT_PROVINCE).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.getProvinceData = result.data;
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //市
  public getCity(provinceCode:string):void{
    this.getCityData = null;
    this.getDistrictData = null;
    if(provinceCode!=null&&provinceCode!=''){
      this.httpService.requestJsonData(ApiConstant.SYS_ROLE_RESTRICT_CITY,null,new Map([['provinceCode',provinceCode]])).subscribe(
        {
          next:(result:any) => {
            //console.log(result);
            if(result.code==200){
              this.getCityData = result.data;
            }else{
              alert(result.message);
            }
          },
          error:e => {},
          complete:() => {}
        }
      );
    }
  }

  //区
  public getDistrict(cityCode:string):void{
    this.getDistrictData = null;
    if(cityCode!=null&&cityCode!=''){
      this.httpService.requestJsonData(ApiConstant.SYS_ROLE_RESTRICT_DISTRICT,null,new Map([['cityCode',cityCode]])).subscribe(
        {
          next:(result:any) => {
            //console.log(result);
            if(result.code==200){
              this.getDistrictData = result.data;
            }else{
              alert(result.message);
            }
          },
          error:e => {},
          complete:() => {}
        }
      );
    }
  }

  //新增角色限定
  public roleRestrictAddFunction():void {
    this.router.navigate(['add'],{relativeTo:this.activatedRoute});
  }

  //删除角色限定
  public roleRestrictDeleteFunction(roleRestrictId:string):void {
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_RESTRICT_DELETE,null,new Map([['roleRestrictId',roleRestrictId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.roleRestrictSearch(1);
            alert('角色限定删除成功');
          }else{
            alert('角色限定删除失败');
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //角色限定详情
  public roleRestrictDetailFunction(roleRestrictId:string):void {
    //this.router.navigate(['detail'],{relativeTo:this.activatedRoute,queryParams:{roleRestrictId:roleRestrictId}});
    alert('页面暂未开发');
  }

  //修改角色限定
  public roleRestrictModifyFunction(roleRestrictId:string):void {
    //this.router.navigate(['modify'],{relativeTo:this.activatedRoute,queryParams:{roleRestrictId:roleRestrictId}});
    alert('页面暂未开发');
  }

}
