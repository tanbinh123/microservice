import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {DictionaryAddRequest} from '../../../model/dictionary/DictionaryAddRequest';

@Component({
  selector: 'app-web-dictionary-add',
  templateUrl: './dictionary.add.html',
  styleUrls: ['./dictionary.add.scss'],
  providers:[]
})

export class DictionaryAddComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  dictionaryAddRequest:DictionaryAddRequest = new DictionaryAddRequest();//字典新增

  //初始化
  ngOnInit(): void {

  }

  //新增字典
  public dictionaryAdd():void{
    this.httpService.requestJsonData(ApiConstant.SYS_DICTIONARY_ADD,JSON.stringify(this.dictionaryAddRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('新增字典成功');
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
  public dictionaryAddBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
