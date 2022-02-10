import {Component,OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {HttpService} from '../../../service/HttpService';
import {AuthService} from '../../../service/AuthService';
import {SessionService} from '../../../service/SessionService';
import {ApiConstant} from '../../../constant/ApiConstant';
import {UserDetailResponse} from '../../../model/user/UserDetailResponse';
import {CommonConstant} from '../../../constant/CommonConstant';

@Component({
  selector: 'app-web-user-detail',
  templateUrl: './user.detail.html',
  styleUrls: ['./user.detail.scss'],
  providers:[]
})

export class UserDetailComponent implements OnInit {

  constructor(public router:Router,
              public activatedRoute:ActivatedRoute,
              public httpService:HttpService,
              public authService:AuthService,
              public sessionService:SessionService){

  }

  public userDetailResponse:UserDetailResponse = new UserDetailResponse();//用户详情
  public userPortraitSrc;

  //初始化
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(queryParam => {
      let userId = queryParam.userId;
      this.userDetail(userId);
      //this.userPortraitSrc = ApiConstant.SYS_USER_PORTRAIT+'?userId='+userId+'&token='+this.sessionService.getHeadToken().token+'&t='+new Date().getTime();
    });
  }

  //用户详情
  public userDetail(userId:string):void{
    this.httpService.requestJsonData(ApiConstant.SYS_USER_DETAIL,null,new Map([['userId',userId]])).subscribe(
      {
        next:(result:any) => {
          //console.log(result);
          if(result.code==200){
            this.userDetailResponse.userName = result.data.userName;//用户名
            this.userDetailResponse.personName = result.data.personName;//用户姓名
            this.userDetailResponse.idCard= result.data.idCard;//身份证号码
            this.userDetailResponse.email = result.data.email;//电子邮箱
            this.userDetailResponse.phone = result.data.phone;//手机号码
            this.userDetailResponse.status = result.data.status;//用户状态
            this.userDetailResponse.remark = result.data.remark;//备注
            //this.userPortrait(userId,result.data.portrait);
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
  public userDetailBack():void{
    this.router.navigate(['../'],{relativeTo:this.activatedRoute});
  }

  /**
  public userPortrait(userId:string,portrait:string):void {
    if(portrait==null||portrait==CommonConstant.EMPTY){
      let img = document.getElementById('img');
      // @ts-ignore
      img.src = '../../../../assets/image/user/portrait.jpg';
      img.onload = () => {
        // @ts-ignore
        URL.revokeObjectURL(img.src);
      }
    }else{
      Object.defineProperty(Image.prototype, 'authSrc', {
        writable : true,
        enumerable : true,
        configurable : true
      });
      let img = document.getElementById('img');
      //let url = img.getAttribute('authSrc');
      let request = new XMLHttpRequest();
      request.responseType = 'blob';
      request.open('get',ApiConstant.SYS_USER_PORTRAIT+'/'+userId, true);
      request.setRequestHeader('token', this.sessionService.getHeadToken().token);
      request.onreadystatechange = e => {
        if (request.readyState == XMLHttpRequest.DONE && request.status == 200) {
          // @ts-ignore
          img.src = URL.createObjectURL(request.response);
          img.onload = () => {
            // @ts-ignore
            URL.revokeObjectURL(img.src);
          }
        }
      };
      request.send(null);
    }
  }
  */

}
