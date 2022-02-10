import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {RoleModifyRequest} from '../../../model/role/RoleModifyRequest';
import {DictionaryModifyRequest} from '../../../model/dictionary/DictionaryModifyRequest';

@Component({
  selector: 'app-web-dictionary-modify',
  templateUrl: './dictionary.modify.html',
  styleUrls: ['./dictionary.modify.scss'],
  providers:[]
})

export class DictionaryModifyComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public dictionaryModifyRequest:DictionaryModifyRequest = new DictionaryModifyRequest();//字典修改

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let dictionaryId = queryParam.dictionaryId;
      this.dictionaryModifyRequest.id = dictionaryId;
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
            this.dictionaryModifyRequest.dataType = result.data.dataType;//数据类型
            this.dictionaryModifyRequest.keyCode = result.data.keyCode;//key值
            this.dictionaryModifyRequest.valueCode = result.data.valueCode;//value值
            this.dictionaryModifyRequest.categoryName = result.data.categoryName;//分类名称
            this.dictionaryModifyRequest.categoryCode = result.data.categoryCode;//分类代码
            this.dictionaryModifyRequest.means = result.data.means;//含义
            this.dictionaryModifyRequest.remark = result.data.remark;//备注
          }else{
            alert(result.message);
          }
        },
        error:e => {},
        complete:() => {}
      }
    );
  }

  //修改字典
  public dictionaryModify():void{
    console.log(this.dictionaryModifyRequest);
    this.httpService.requestJsonData(ApiConstant.SYS_DICTIONARY_MODIFY,JSON.stringify(this.dictionaryModifyRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('修改字典成功');
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

  //返回
  public dictionaryModifyBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
