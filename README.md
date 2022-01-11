# JavaWeb V1.0
# JavaWeb基础框架：
spring-mvc+mybatis+mysql+tomcat+java8+bootstrap+angularjs                     
# 说明：
# 一、本项目简介
1、为什么会有这个项目：软件行业从事了几年，之前也正好在为公司搭建一个小小的框架，也正好借此机会，吸取公司搭建框架中的经验，慢慢运用Java8自己重新搭建项目。这是一个很菜的项目，很多地方写的很烂，本人才疏学浅，能力低微，不足之处尽管批评指正，但是你要喷，请你别来看了            
2、项目简介：本项目是一个JavaWeb基础框架，本项目为开源项目(Apache License V2.0)     
3、特别说明：本项目前端框架运用了[SB Admin v2.0 rewritten in AngularJS]，并进行了小部分改造       
（ github地址：https://github.com/start-angular/sb-admin-angular.git ）    
4、兼容性较差，有些页面内容可能无法显示，有些按钮或操作可能由于angularjs的兼容性导致事件、操作无效，因此推荐谷歌浏览器版本50左右，火狐浏览器版本50左右（本项目所有操作、功能均在火狐50.0.1版本下通过）     
5、本项已不再维护，仅偶尔会升级下jar包版本或解决一些发现的BUG      
# 二、使用技术
1、spring-mvc-restful作为后端主体  
2、mybats作为数据库层的操作  
3、maven作为jar包管理    
4、tomcat作为应用服务器   
5、java8作为后端主体开发语言     
6、mysql5.6作为后端主体关系型数据库   
7、mongodb作为后端辅助非关系型数据库   
8、shiro作为后端权限管理框架   
9、bootstrap作为前端主要开发框架   
10、angularjs作为前端主要开发框架   
# 三、如何快速部署运行本项目
1、安装jdk8或更高版本   
2、安装tomcat7或更高版本    
3、安装mysql5.6或更高版本    
4、安装maven较新版本   
5、导入maven项目   
6、将/src/main/resources/config/sql/backup.sql导入数据库，数据库配置见：src/main/resources/config/props/jdbc.properties   
7、进入src/main/webapp/app下，运行npm install         
注：我的项目未包含bower_components文件夹，但是如果你用npm或bower安装依赖js文件，实际运行后有四个文件是不包含的，它们分别是：bootstrap-datetimepicker-master、bootstrap-fileinput、ng-infinite-scroll、zTree，因此一个简单做法可以直接从百度网盘"http://pan.baidu.com/s/1pKHoaaJ" 下载已经编译好的bower_components，将其放在src/main/webapp/app下即可           
8、进入项目目录运行：mvn clean install                                        
9、进入项目下的target目录，找到JavaWeb.war                    
10、将JavaWeb.war拷贝至tomcat的webapp目录下，然后运行tomcat即可          
# 四、其它说明
1、关于框架                 
框架有很多不完善，但是满足简单的功能要求还是没问题的               
2、关于业务代码编写方式               
只需要关注controller（请求分发、跳转及异常处理）->service（业务逻辑处理）->dao（数据库访问）就可以了              
3、关于单元测试                
从controller->service->dao都可以分层测试，也有页面可以测试API返回的json数据             
4、这里的angularjs指的是angular1，而angular指的是2及其以上   
