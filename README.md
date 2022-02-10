# 版本最新升级后基本可用，但还有许多BUG持续修复中          

# 微服务 V1.0          
# 一、项目启动说明          
当新建一个纯净的项目引入eureka-client-admin只需要排除默认数据源配置即可：@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})    
1、angular-admin    
为eureka-client-admin的前端，运行：npm install->npm start->http://localhost:4200    
2、common为大部分后端项目的共有依赖    
3、eureka-server    
server1:1001    
server2:1002    
server3:1003    
运行：要起3个服务，application.properties中spring.profiles.active分别为s1、s2、s3，同时需要设置hosts，具体参见application.properties        
4、eureka-client-admin    
client1:2001    
为angular-admin的后端，默认监控信息暂不接入（因为写的不够好），如果要接入，需要：    
①解注application.properties里management开头的三行配置信息    
②解注pom.xml里spring-boot-starter-actuator和spring-boot-admin-starter-client    
③解注InterfaceLimitFilter的httpServletRequest.getServletPath().startsWith("/actuator")的判断条件    
5、eureka-client-actuator    
client2:2002    
6、eureka-client-gateway    
client3:2003    
# 二、项目重要说明          
1、本项目有很多不足和BUG（水平有限），尤其是前端angular（正在考虑是否替换，所以目前仅做页面简单的展示下），因此更新会比较频繁、改动会比较大，请见谅（更新代码时也请同步更新JavaWeb2-eureka-client-user/src/main/resources/sql/init.sql并重新cnpm install）    
2、本项目默认使用自己“造的轮子”——数据库通用CRUD接口，还有很多不足，比如新增成功后目前无法返回主键ID    
3、本项目暂时未对请求体和返回体进行加解密，即明文传输；加解密后端暂时可以参考SecretRequest.java，前端暂时可以参考HttpService.ts和SecretUtil.ts    
4、本项目前后端分离在session上没有使用spring-session-redis，而是自己“造的轮子”    
5、本项目后端几乎所有的增删改查操作都是物理操作（忽略数据库表中的del_flag字段），如果想做逻辑操作（使用数据库表中的del_flag字段）需要重写相关SQL语句    
6、本项目所有增删改查操作只是简单的校验了下，有些甚至都没有校验，如有需要请自行增加、修改、优化    
7、本项目所有SQL语句均未优化且没有索引等，如有需要请自行优化    
8、本项目所有主键都是字符串类型，而不是数字（或数字自增）类型，主要考虑到两方面：①分布式及数据迁移；②当数字类型超过16位时，前后端交互时，前端会有精度误差，当然前端转化下或后端转化下就可以了，这里主要是为了避免相互转换的麻烦，但是写入的依然是数字，即类型是字符串类型但是值是数字。另外前端传字符串后端JAVA依然可以用类似Long封装类型接收，原理就是Long.parseLong不报错即可；同理，数据库查出来数字类型，后端JAVA依然可以用字符串接收，原理就是String.valueOf不报错即可；当然，一般不推荐这么写。另外，大数字前端作为字符串传来，后端JSON解析时建议先转为字符串再转为数字，类似JSONObject.getLong('key')时就会出现精度丢失。对于新、老数据的迁移、合并，systemNo的值是区分关键，参考SecretUtil的defaultGenUniqueStr方法    
9、integration-demo.zip包括了一些常用技术与SpringBoot组合的示例，基本验证通过，但是不同版本写法会有差异（hbase、kafka、netty、solr、切面处理、mongodb、websocket（SpringBoot版和Netty版）、elasticsearch、neo4j、barcode（一维条形码）、kaptcha（二维码）、邮件发送、redis、restTemplate、quartz（分布式）定时任务、文件上传下载、activiti、camunda、swagger2、qq、wechat、poi-excel、HTTPS和HTTP2.0、本项目作为第三方的接入（Oauth2）、接口对接（对方请求我们的数据）、中文分词器、轻量级文件服务器minio、FastDFS、SpringBatch批处理、JNI、重写RequestBody数据格式、webservice、实体类字段脱敏处理、请求参数分组校验）    
10、注册中心有很多，比如eureka、zookeeper、consul、nacos等，这些不在本项目范围内，请自行研究，本项目用的是eureka    
11、微服务还有其它组件，如：SpringCloudConfig、SpringCloudSleuth、SpringCloudSecurity等，这些不在本项目范围内，请自行研究    
12、自动化运维，如：docker、k8s、jenkins等，这些不在本项目范围内，请自行研究    
13、tomcat容器顺序：【Filter->Servlet->Inteceptor->Aspect->Controller】，因此在本项目中形成了：InterfaceLimitFilter（接口限流-所有编写有效的接口）->WebPermissionInterceptor（权限控制-所有权限受控的接口）->OperateLogAspect（日志切面-所有需要记录日志的接口）    
14、文件分隔常会用逗号（,）分隔，但是更建议用星号（\*）或竖线（\|）分隔    
15、模糊查询不建议使用like '%xxx%'或like CONCAT('%',#{userName},'%')，建议mysql使用REGEXP，oralce使用REGEXP_LIKE。另外，为了避免%和\的问题，顺便说下转义处理：    
oracle：select * from 表名 where 字段 like '%\%%' ESCAPE '\';    
mysql：select * from 表名 where 字段like '%\%abc%';    
16、关于接口请求：后端接口为/a，页面//a或者/////a都是可以请求到/a的    
17、当传参类型为json时，加不加@RequestBody都能通过实体类接收到    
18、在oracle中VARCHAR2(3)默认是VARCHAR2(3 byte)，也就是说3个中文是存不了的，要真正做到3个字符，需要显式设计为VARCHAR2(3 CHAR)    
# 三、项目使用说明          
1、除了涉及事务的service加上@Transactional，建议涉及事务的Controller也加上@Transactional，另外不建议try、catch，除非能确保无数据库相关事务操作或确保Controller内的方法不会抛出异常；另外自定义异常如果继承Exception的话，方法需要显式抛出异常，而如果继承RuntimeException，方法不需要显式抛出异常    
2、关于@Configuration的类，配置代码常用的有两种写法，一是通过常量类配置，二是通过配置文件配置，若不想该配置类生效，可以加上如：@ConditionalOnProperty(name="http.server.on",havingValue="true")    
3、src/main/resources下的静态资源文件在SpringBoot中的默认（未添加拦截器等情况下）的查找顺序为：META/resources->resources->static->public    
4、读取配置文件一般有以下三种常用写法    
A、@Autowired private Environment environment    
B、@Value("${server.port}") private String port    
C、@ConfigurationProperties(prefix="com.demo")//写了prefix后com.demo.a.b.c可以变为a.b.c；另外写了prefix就可以不写@Value了，如果写了@Value那就优先读取@Value的值    
@Component    
@PropertySource({"classpath:application.properties"})    
public class Test{    
   ......    
}    
@Autowired private Test test    
5、指定读取配置文件的几种常用方式    
A、java -jar demo.jar --spring.config.location=/tmp/test/application.properties    
B、java -jar demo.jar --spring.profiles.active=dev    
C、java -jar demo.jar然后在同一目录下建一个config文件夹，里面放个配置文件：application.properties    
如果读取war包的话参考JavaWeb2-integration-demo里的pom.xml    
6、满足相关条件再注入可以使用@Conditional及其扩展    
@Conditional    
@ConditionalOnBean：当容器里有指定Bean的条件下    
@ConditionalOnClass：当类路径下有指定类的条件下    
@ConditionalOnExpression：基于SpEL表达式作为判断条件    
@ConditionalOnJava：基于JAVA版本作为判断条件    
@ConditionalOnJndi：在JNDI存在的条件下差在指定的位置    
@ConditionalOnMissingBean：当容器里没有指定Bean的情况下    
@ConditionalOnMissingClass：当类路径下没有指定类的条件下    
@ConditionalOnNotWebApplication：当前项目不是Web项目的条件下    
@ConditionalOnProperty：指定的属性是否有指定的值    
@ConditionalOnResource：类路径是否有指定的值    
@ConditionalOnSingleCandidate：当指定Bean在容器中只有一个，或者虽然有多个但是指定首选Bean    
@ConditionalOnWebApplication：当前项目是Web项目的条件下    
# 四、项目主要特点          
1、微服务    
2、前后端分离    
3、多数据源    
4、国际化    
5、mybatis共通dao（位于项目common）    
6、websocket    
7、数据权限：本项目的数据权限全部围绕接口展开的，使用时在Controller的方法上加上@ControllerMethod(dataPermissionEntity=UserListResponse.class)，默认/web开头的接口都是权限受控的，参考：UserController中的userList    
8、代码自动生成    
9、ID自动生成：作为@Component组件实现IdAutoCreate接口并且实体类@Column加入idAutoCreate=true    
10、分布式定时任务：在task包下执行定时任务的方法上加上@DistributedTimedTask(taskUniqueName="项目任务全局唯一名称")。当然做的更好的话还是建议使用XXL-JOB、ELASTIC-JOB、QUARTZ等框架然后加上定时任务作为接口调用来处理    
# 五、项目对redis的应用          
1、用户登录信息、token、数据查询结果、数据字典、配置信息等的存储（字符串）：valueOperations.set(key,value,timeout)    
2、接口限流（计数器）：increment(key,count)+valueOperations.get(key)+valueOperations.set(key,value,timeout)    
3、分布式定时任务（分布式锁）：setIfAbsent(key,value,time,timeUnit)    
4、接口调用次数统计（哈希计数器）：opsForHash().increment(key,hashKey,count)    
5、配置信息集群变更同步通知（发布订阅）：convertAndSend(channel,message)、MessageListener、MessageListenerAdapter、RedisMessageListenerContainer    
# 六、开发计划          
1、用户角色权限关系一览    
2、多数据源改造（不再采用多数据源和AOP切换的方式）并支持XA分布式事务    
3、优化权限体系    
4、持续优化迭代各已有功能    
5、完善纵向数据权限（数据权限：select a from test和select a,b from test）和横向数据权限（角色限定：select a from test where a = 10和select a from test where b = 20）    
6、整合hadoop、spark、storm等大数据技术    
7、将分出两个版本，一个是现有jdk8版本，另一个将采用jdk11（因为这是一个长期支持版本），然后过渡到JAVA16+，并慢慢加入函数式、异步编程（包括WebFlux/RxJava2/Netty） 等    
8、优化、增加常用算法（主要基于算法导论）    
9、将部分JAVA算法改用C语言实现，JAVA本地调用C语言的实现方法    
# 七、后期侧重点          
数学、算法、人工智能、机器学习、编程语言底层实现    
# 八、其它          
1、后端多个jar执行可以写个脚本，如在windows上可以写为：    
cd C:\Users\admin\Desktop    
start cmd /c "title s1 && java -jar s1.jar"    
start cmd /c "title s2 && java -jar s2.jar"    
start cmd /c "title s3 && java -jar s3.jar"    
2、一些地址参考    
https://start.spring.io    
https://spring.io/projects/spring-cloud    
https://angular.io/start    
