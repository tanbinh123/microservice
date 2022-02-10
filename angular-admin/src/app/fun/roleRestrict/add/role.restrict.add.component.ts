import {Component,OnInit} from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {HttpClient} from '@angular/common/http';
import {RoleRestrictAddRequest} from 'src/app/model/roleRestrict/RoleRestrictAddRequest';

@Component({
  selector: 'app-web-role-restrict-add',
  templateUrl: './role.restrict.add.html',
  styleUrls: ['./role.restrict.add.scss'],
  providers:[]
})

export class RoleRestrictAddComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpClient:HttpClient,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  roleRestrictAddRequest:RoleRestrictAddRequest = new RoleRestrictAddRequest();//角色限定新增
  roleData:any;
  roleRestrictWayFromDictionaryData:any;
  getProvinceData:any;
  getCityData:any;
  getDistrictData:any;
  provinceDisableTag:boolean=false;
  cityDisableTag:boolean=false;
  districtDisableTag:boolean=false;

  //初始化
  ngOnInit(): void {
    this.getRoleListAll();
    this.getProvince();
    this.getRoleRestrictWayFromDictionary();
  }

  //新增角色限定
  public roleRestrictAdd():void{
    //console.log(this.roleRestrictAddRequest);
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_RESTRICT_ADD,JSON.stringify(this.roleRestrictAddRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('新增角色限定成功');
            this.router.navigate(['../'],{relativeTo:this.activatedRoute});
          }else{
            alert(result.message);
            //this.router.navigate(['webLogin']);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //获取角色限定方式字典数据
  public getRoleRestrictWayFromDictionary():void {
    this.httpService.requestJsonData(ApiConstant.GET_DICTIONARY,JSON.stringify({dataType:'role_restrict_way'})).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.roleRestrictWayFromDictionaryData = result.data;
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //获取角色列表
  public getRoleListAll():void {
    this.httpService.requestJsonData(ApiConstant.SYS_ROLE_LIST_ALL).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.roleData = result.data;
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
  public roleRestrictAddBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

  /* -------------------- 下面的省市区等下拉事件逻辑前端简单处理了 -------------------- */

  //角色下拉事件
  public selectChangeRole($event):void{
    this.roleRestrictAddRequest.roleId=$event.target.value;
  }

  //角色限定方式下拉事件
  public selectChangeRestrictWay($event):void{
    let restrictWay = $event.target.value;
    if(restrictWay==1){//本人
      this.provinceDisableTag=true;
      this.cityDisableTag=true;
      this.districtDisableTag=true;
    }else{
      this.provinceDisableTag=false;
      this.cityDisableTag=false;
      this.districtDisableTag=false;
    }
    this.roleRestrictAddRequest.restrictWay = restrictWay;
  }

  //省下拉
  public selectChangeProvince($event):void{
    let provinceCode = $event.target.value;
    if(provinceCode!=null&&provinceCode!=''){
      if(provinceCode!='self'&&provinceCode!='all'){
        this.getCity(provinceCode);
      }
      this.roleRestrictAddRequest.province = provinceCode;
    }
  }

  //市下拉
  public selectChangeCity($event):void{
    let cityCode = $event.target.value;
    if(cityCode!=null&&cityCode!=''){
      if(cityCode!='self'&&cityCode!='all'){
        this.getDistrict(cityCode);
      }
      this.roleRestrictAddRequest.city = cityCode;
    }
  }

  //区下拉
  public selectChangeDistrict($event):void{
    let districtCode = $event.target.value;
    if(districtCode!=null&&districtCode!=''){
      this.roleRestrictAddRequest.district = districtCode;
    }
  }

  //省
  public getProvince():void{
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
    if(provinceCode!=null&&provinceCode!=''&&provinceCode!='self'&&provinceCode!='all'){
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
    if(cityCode!=null&&cityCode!=''&&cityCode!='self'&&cityCode!='all'){
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

}
