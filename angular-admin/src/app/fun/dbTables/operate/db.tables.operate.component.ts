import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {HttpClient} from '@angular/common/http';
import {ApiConstant} from 'src/app/constant/ApiConstant';
import {DbTablesOperateRequest} from 'src/app/model/dbTables/DbTablesOperateRequest';


@Component({
  selector: 'app-web-db-tables-operate',
  templateUrl: './db.tables.operate.html',
  styleUrls: ['./db.tables.operate.scss'],
  providers:[]
})

export class DbTablesOperateComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public httpClient:HttpClient,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public dbOperateTypeFromDictionaryData:any;
  public sql:string;
  public dbInfo:any;
  public dbTablesOperateRequest:DbTablesOperateRequest = new DbTablesOperateRequest();

  //初始化
  ngOnInit(): void {
    this.getModuleTypeFromDictionary();
  }

  //获取数据库操作类型字典数据
  public getModuleTypeFromDictionary():void {
    this.httpService.requestJsonData(ApiConstant.GET_DICTIONARY,JSON.stringify({dataType:'db_operate_type'})).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.dbOperateTypeFromDictionaryData = result.data;
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
  public selectChange($event):void {
    this.dbTablesOperateRequest.operateType = $event.target.value;
  }

  //发送
  public sendFunction():void {
    this.dbTablesOperateRequest.sql = this.sql;
    this.httpService.requestJsonData(ApiConstant.SYS_DB_TABLES_OPERATE,JSON.stringify(this.dbTablesOperateRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            let out = result.data;
            if(out==null||out==undefined||out==''||this.dbTablesOperateRequest.operateType!=1){
              this.dbInfo = out;
            }else{
              this.dbInfo = JSON.stringify(out);
            }
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
