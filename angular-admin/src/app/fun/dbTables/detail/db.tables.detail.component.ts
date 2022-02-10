import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';

@Component({
  selector: 'app-web-db-tables-detail',
  templateUrl: './db.tables.detail.html',
  styleUrls: ['./db.tables.detail.scss'],
  providers:[]
})

export class DbTablesDetailComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  resultList:any;

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let tableName = queryParam.tableName;
      this.dbTablesDetail(tableName);
    });
  }

  //用户详情
  public dbTablesDetail(tableName:string):void{
    this.httpService.requestJsonData(ApiConstant.SYS_DB_TABLES_DETAIL,null,new Map([['tableName',tableName]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.resultList = result.data;
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
  public dbTablesDetailBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
