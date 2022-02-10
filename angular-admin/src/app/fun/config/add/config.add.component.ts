import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {ConfigAddRequest} from '../../../model/config/ConfigAddRequest';

@Component({
  selector: 'app-web-config-add',
  templateUrl: './config.add.html',
  styleUrls: ['./config.add.scss'],
  providers:[]
})

export class ConfigAddComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService) {

  }

  configAddRequest:ConfigAddRequest = new ConfigAddRequest();//配置新增

  //初始化
  ngOnInit(): void {

  }

  //新增配置
  public configAdd():void{
    this.httpService.requestJsonData(ApiConstant.SYS_CONFIG_ADD,JSON.stringify(this.configAddRequest)).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            alert('新增配置成功');
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
  public configAddBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

}
