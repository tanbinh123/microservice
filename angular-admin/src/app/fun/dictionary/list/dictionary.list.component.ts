import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ResultPage} from '../../../model/ResultPage';
import {DictionaryListRequest} from '../../../model/dictionary/DictionaryListRequest';


@Component({
  selector: 'app-web-dictionary-list',
  templateUrl: './dictionary.list.html',
  styleUrls: ['./dictionary.list.scss'],
  providers:[]
})

export class DictionaryListComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){
    this.dictionaryListZone = authService.canShow(ApiConstant.SYS_DICTIONARY_LIST);
    this.dictionaryDeleteZone = authService.canShow(ApiConstant.SYS_DICTIONARY_DELETE);
    this.dictionaryAddZone = authService.canShow(ApiConstant.SYS_DICTIONARY_ADD);
    this.dictionaryModifyZone = authService.canShow(ApiConstant.SYS_DICTIONARY_MODIFY);
    this.dictionaryDetailZone = authService.canShow(ApiConstant.SYS_DICTIONARY_DETAIL);
  }

  /** 操作权限 start */
  dictionaryListZone:boolean;//字典列表
  dictionaryDeleteZone:boolean;//删除字典
  dictionaryAddZone:boolean;//新增字典
  dictionaryModifyZone:boolean;//修改字典
  dictionaryDetailZone:boolean;//字典详情
  /** 操作权限 end */

  public dictionaryListRequest:DictionaryListRequest = new DictionaryListRequest();//字典列表搜索条件
  public resultPage:ResultPage = new ResultPage();//分页结果初始化

  //初始化
  ngOnInit(): void {
    /** 若需修改分页大小或其它请求参数请注释后自行调整，这里使用默认值
    this.dictionaryListRequest.currentPage = 1;
    this.dictionaryListRequest.pageSize = 5;
    */
    this.dictionaryListFunction(this.dictionaryListRequest);//初始化字典列表
  }

  //搜索按钮
  public dictionarySearch(currentPage):void{
    this.resultPage = new ResultPage();//对每次搜索初始化分页
    this.dictionaryListRequest.currentPage = currentPage;
    this.dictionaryListFunction(this.dictionaryListRequest);
  }

  //重置
  public reset():void{
    this.dictionaryListRequest = new DictionaryListRequest();
  }

  //字典列表
  public dictionaryListFunction(dictionaryListRequest:DictionaryListRequest):void {
    this.httpService.requestJsonData(ApiConstant.SYS_DICTIONARY_LIST,JSON.stringify(dictionaryListRequest)).subscribe(
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

  //新增字典
  public dictionaryAddFunction():void {
    this.router.navigate(['add'],{relativeTo:this.activatedRoute});
  }

  //删除字典
  public dictionaryDeleteFunction(dictionaryId:string):void {
    this.httpService.requestJsonData(ApiConstant.SYS_DICTIONARY_DELETE,null,new Map([['dictionaryId',dictionaryId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.dictionarySearch(1);
            alert('字典删除成功');
          }else{
            alert('字典删除失败');
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //字典详情
  public dictionaryDetailFunction(dictionaryId:string):void {
    this.router.navigate(['detail'],{relativeTo:this.activatedRoute,queryParams:{dictionaryId:dictionaryId}});
  }

  //修改字典
  public dictionaryModifyFunction(dictionaryId:string):void {
    this.router.navigate(['modify'],{relativeTo:this.activatedRoute,queryParams:{dictionaryId:dictionaryId}});
  }

}
