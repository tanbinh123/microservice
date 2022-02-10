import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ResultPage} from '../../../model/ResultPage';
import {DbTablesListRequest} from '../../../model/dbTables/DbTablesListRequest';
import {HttpClient, HttpHeaders} from '@angular/common/http';


@Component({
  selector: 'app-web-db-tables-list',
  templateUrl: './db.tables.list.html',
  styleUrls: ['./db.tables.list.scss'],
  providers:[]
})

export class DbTablesListComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public httpClient:HttpClient,
              public authService:AuthService,
              public sessionService:SessionService){
    this.dbTablesListZone = authService.canShow(ApiConstant.SYS_DB_TABLES_LIST);
    this.dbReductionZone = authService.canShow(ApiConstant.SYS_DB_TABLES_REDUCTION);
    this.dbOperateZone = authService.canShow(ApiConstant.SYS_DB_TABLES_OPERATE);
    this.dbTablesDetailZone = authService.canShow(ApiConstant.SYS_DB_TABLES_DETAIL);
    this.dbTablesCodeGenerateZone = authService.canShow(ApiConstant.SYS_DB_TABLES_CODE_GENERATE);
  }

  /** 操作权限 start */
  dbTablesListZone:boolean;//数据库表列表
  dbReductionZone:boolean;//数据库表还原
  dbOperateZone:boolean;//数据库表操作
  dbTablesDetailZone:boolean;//数据库表详情
  dbTablesCodeGenerateZone:boolean;//代码生成
  /** 操作权限 end */

  dbTablesListRequest:DbTablesListRequest = new DbTablesListRequest();//数据库表列表搜索条件
  resultPage:ResultPage = new ResultPage();//分页结果初始化

  //初始化
  ngOnInit(): void {
    /*若需修改分页大小或其它请求参数请注释后自行调整，这里使用默认值
    this.dbTablesListRequest.currentPage = 1;
    this.dbTablesListRequest.pageSize = 5;
    */
    this.dbTablesListFunction(this.dbTablesListRequest);//初始化数据库表列表
  }

  //搜索按钮
  public dbTablesSearch(currentPage):void{
    this.resultPage = new ResultPage();//对每次搜索初始化分页
    this.dbTablesListRequest.currentPage = currentPage;
    this.dbTablesListFunction(this.dbTablesListRequest);
  }

  //重置
  public reset():void{
    this.dbTablesListRequest = new DbTablesListRequest();
  }

  //数据库表列表
  public dbTablesListFunction(dbTablesListRequest:DbTablesListRequest):void {
    this.httpService.requestJsonData(ApiConstant.SYS_DB_TABLES_LIST,JSON.stringify(dbTablesListRequest)).subscribe(
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

  //数据库表详情
  public dbTablesDetailFunction(tableName:string):void{
    this.router.navigate(['detail'],{relativeTo:this.activatedRoute,queryParams:{tableName:tableName}});
  }

  //代码生成
  public dbTablesCodeGenerateFunction(tableName:string):void{
    let httpHeaders:HttpHeaders = new HttpHeaders({
      'Content-Type':'application/json',
      'Access-Control-Allow-Headers':'Authorization',
      token:this.sessionService.getHeadToken().token
    });
    let options:any = {headers:httpHeaders,withCredentials:true,responseType:'blob'};
    this.httpClient.get(ApiConstant.SYS_DB_TABLES_CODE_GENERATE+'/'+tableName,options).subscribe(
      {
        next:(result:any) => {
          const blob = new Blob([result],{ type:'application/OCTET-STREAM;charset=UTF-8'});
          const url = window.URL.createObjectURL(blob);
          const a = document.createElement('a');
          a.href = url;
          a.download = tableName + '.zip';
          a.click();
          window.URL.revokeObjectURL(url);
        }
      }
    );
  }

  //数据库表还原
  public dbReduction():void{
    this.httpService.requestJsonData(ApiConstant.SYS_DB_TABLES_REDUCTION).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('数据库表还原成功');
          }
          this.logout();
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //数据库操作
  public dbOperate():void{
    this.router.navigate(['operate'],{relativeTo:this.activatedRoute});
  }

  //退出
  public logout():void{
    this.httpService.requestJsonData(ApiConstant.LOGIN_OUT).subscribe(
      {
        next:(result:any) => {
          this.router.navigate(['']);
          this.sessionService.removeTokenData();
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

}
