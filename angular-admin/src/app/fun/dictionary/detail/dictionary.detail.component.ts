import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {DictionaryDetailResponse} from '../../../model/dictionary/DictionaryDetailResponse';

@Component({
  selector: 'app-web-dictionary-detail',
  templateUrl: './dictionary.detail.html',
  styleUrls: ['./dictionary.detail.scss'],
  providers:[]
})

export class DictionaryDetailComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public dictionaryDetailResponse:DictionaryDetailResponse = new DictionaryDetailResponse();//字典详情

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let dictionaryId = queryParam.dictionaryId;
      this.dictionaryDetailResponse.id = dictionaryId;
      this.dictionaryDetail(dictionaryId);
    });
  }

  //字典详情
  public dictionaryDetail(dictionaryId:string):void{
    this.httpService.requestJsonData(ApiConstant.SYS_DICTIONARY_DETAIL,null,new Map([['dictionaryId',dictionaryId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.dictionaryDetailResponse.dataType = result.data.dataType;//数据类型
            this.dictionaryDetailResponse.keyCode = result.data.keyCode;//key值
            this.dictionaryDetailResponse.valueCode = result.data.valueCode;//value值
            this.dictionaryDetailResponse.categoryName = result.data.categoryName;//分类名称
            this.dictionaryDetailResponse.categoryCode = result.data.categoryCode;//分类代码
            this.dictionaryDetailResponse.means = result.data.means;//含义
            this.dictionaryDetailResponse.remark = result.data.remark;//备注
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
  public roleDetailBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
