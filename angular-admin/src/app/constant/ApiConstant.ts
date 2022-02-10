import { RequestUrl } from "../model/common/RequestUrl";
import { CommonConstant } from "./CommonConstant";

export class ApiConstant{

  public static API_VERSION = '1.0.0';
  public static HTTP_REQUEST_PREFIX = 'http://127.0.0.1:2001';
  public static WEBSOCKET_ONLINE_CHAT_URL = 'ws://127.0.0.1:2001/ws/onlineChat';
  public static WEBSOCKET_SYSTEM_LOG_URL = 'ws://127.0.0.1:2001/ws/systemLog';

  /** 任何人都能访问 start */
  public static GET_SERVE_TIME = '/getServeTime';//获取服务器时间
  public static WEB_LOGIN = '/webLogin';//用户登录
  /** 任何人都能访问 end */

  /** 登录才能访问 start */
  public static LOGIN_OUT = '/web/loginAccess/logout';//用户退出
  public static GET_REDIS_TOKEN_DATA = '/web/loginAccess/getRedisTokenData';//获取redis中的用户信息
  public static GET_DICTIONARY = '/web/loginAccess/getDictionary';//获取字典信息
  /** 登录才能访问 end */

  /** 拥有权限才能访问 start */
  public static SYS_USER_LIST = '/web/sys/user/list';//用户列表
  public static SYS_USER_DELETE = '/web/sys/user/delete/{userId}';//删除用户
  public static SYS_USER_ADD = '/web/sys/user/add';//新增用户
  public static SYS_USER_MODIFY = '/web/sys/user/modify';//修改用户
  public static SYS_USER_DETAIL = '/web/sys/user/detail/{userId}';//用户详情
  public static SYS_USER_ROLE_INFO = '/web/sys/user/userRoleInfo/{userId}';//用户角色信息
  public static SYS_USER_ROLE_ASSIGNMENT = '/web/sys/user/userRoleAssignment/{userId}';//用户角色分配
  public static SYS_USER_MODULE_INFO = '/web/sys/user/userModuleInfo/{userId}';//用户模块信息
  public static SYS_USER_MODULE_ASSIGNMENT = '/web/sys/user/userModuleAssignment';//用户模块分配
  public static SYS_USER_INIT_PASSWORD = '/web/sys/user/initPassword/{userId}';//初始化密码
  //public static SYS_USER_PORTRAIT_UPLOAD = '/web/sys/user/portraitUpload';//用户头像上传接口
  //public static SYS_USER_PORTRAIT = '/web/sys/user/userPortrait';//获取用户头像接口

  public static SYS_ROLE_LIST = '/web/sys/role/list';//角色列表
  public static SYS_ROLE_DELETE = '/web/sys/role/delete/{roleId}';//删除角色
  public static SYS_ROLE_ADD = '/web/sys/role/add';//新增角色
  public static SYS_ROLE_MODIFY = '/web/sys/role/modify';//修改角色
  public static SYS_ROLE_DETAIL = '/web/sys/role/detail/{roleId}';//角色详情
  public static SYS_ROLE_MODULE_INFO = '/web/sys/role/roleModuleInfo/{roleId}';//角色模块信息
  public static SYS_ROLE_MODULE_ASSIGNMENT = '/web/sys/role/roleModuleAssignment/{roleId}';//角色模块分配
  public static SYS_ROLE_LIST_ALL = '/web/sys/role/listAll';//角色列表

  public static SYS_ROLE_RESTRICT_LIST = '/web/sys/roleRestrict/list';//角色限定列表
  public static SYS_ROLE_RESTRICT_DELETE = '/web/sys/roleRestrict/delete/{roleRestrictId}';//删除角色限定
  public static SYS_ROLE_RESTRICT_ADD = '/web/sys/roleRestrict/add';//新增角色限定
  public static SYS_ROLE_RESTRICT_MODIFY = '/web/sys/roleRestrict/modify';//修改角色限定
  public static SYS_ROLE_RESTRICT_DETAIL = '/web/sys/roleRestrict/detail/{roleRestrictId}';//角色限定详情
  public static SYS_ROLE_RESTRICT_PROVINCE = '/web/sys/roleRestrict/getProvince';//获得省信息接口（角色限定）
  public static SYS_ROLE_RESTRICT_CITY = '/web/sys/roleRestrict/getCity/{provinceCode}';//获得市信息接口（角色限定）
  public static SYS_ROLE_RESTRICT_DISTRICT = '/web/sys/roleRestrict/getDistrict/{cityCode}';//获得区信息接口（角色限定）

  public static SYS_MODULE_LIST = '/web/sys/module/list';//模块列表
  public static SYS_MODULE_DELETE = '/web/sys/module/delete/{moduleId}';//删除模块
  public static SYS_MODULE_ADD = '/web/sys/module/add';//新增模块
  public static SYS_MODULE_MODIFY = '/web/sys/module/modify';//修改模块
  public static SYS_MODULE_MODULE_ID_AND_NAME_LIST = '/web/sys/module/getModuleIdAndNameList/{moduleType}';//获取模块ID和模块名称列表
  public static SYS_MODULE_DETAIL = '/web/sys/module/detail/{moduleId}';//模块详情

  public static SYS_CONFIG_LIST = '/web/sys/config/list';//配置列表
  public static SYS_CONFIG_DELETE = '/web/sys/config/delete/{configId}';//删除配置
  public static SYS_CONFIG_ADD = '/web/sys/config/add';//新增配置
  public static SYS_CONFIG_MODIFY = '/web/sys/config/modify';//修改配置
  public static SYS_CONFIG_DETAIL = '/web/sys/config/detail/{configId}';//配置详情

  public static SYS_DICTIONARY_LIST = '/web/sys/dictionary/list';//字典列表
  public static SYS_DICTIONARY_DELETE = '/web/sys/dictionary/delete/{dictionaryId}';//删除字典
  public static SYS_DICTIONARY_ADD = '/web/sys/dictionary/add';//新增字典
  public static SYS_DICTIONARY_MODIFY = '/web/sys/dictionary/modify';//修改字典
  public static SYS_DICTIONARY_DETAIL = '/web/sys/dictionary/detail/{dictionaryId}';//字典详情

  public static SYS_OPERATION_LOG_LIST = '/web/sys/operationLog/list';//操作日志列表

  public static SYS_SCHEDULE_LIST = '/web/sys/schedule/list';//日程列表
  public static SYS_SCHEDULE_ADD = '/web/sys/schedule/add';//新增日程

  public static SYS_INTERFACES_LIST = '/web/sys/interfaces/list';//接口列表
  public static SYS_INTERFACES_MODIFY = '/web/sys/interfaces/modify';//修改接口
  public static SYS_INTERFACES_DETAIL = '/web/sys/interfaces/detail/{interfacesId}';//接口详情
  public static SYS_INTERFACES_USER_ROLE_DATA_PERMISSION = '/web/sys/interfaces/userRoleDataPermission';//用户角色数据权限接口
  public static SYS_INTERFACES_DATA_PERMISSION_ASSIGNMENT = '/web/sys/interfaces/dataPermissionAssignment/{interfacesId}';//数据权限分配接口
  public static SYS_INTERFACES_TEST = '/web/sys/interfaces/test';//测试接口

  public static SYS_ONLINE_USER_LIST = '/web/sys/onlineUser/list';//在线用户列表
  public static SYS_ONLINE_USER_OFFLINE = '/web/sys/onlineUser/offline/{key}';//用户下线

  public static SYS_DB_TABLES_LIST = '/web/sys/dbTables/list';//数据库表列表
  public static SYS_DB_TABLES_REDUCTION = '/web/sys/dbTables/reduction';//数据库表还原
  public static SYS_DB_TABLES_OPERATE = '/web/sys/dbTables/operate';//数据库操作
  public static SYS_DB_TABLES_DETAIL = '/web/sys/dbTables/detail/{tableName}';//数据库表详情
  public static SYS_DB_TABLES_CODE_GENERATE = 'http://127.0.0.1:2001/web/sys/dbTables/codeGenerate';//数据库表代码生成接口（下载接口未改造）

  public static SYS_FILE_LIST = '/web/sys/file/list';//文件列表
  public static SYS_FILE_CONTENT_LIST = '/web/sys/file/contentList';//文件目录列表
  public static SYS_FILE_ROOT_PATH = '/web/sys/file/fileRootPath';//文件根路径接口
  public static SYS_FILE_UPLOAD_FILE = '/web/sys/file/uploadFile';//上传文件
  public static SYS_FILE_DOWNLOAD_FILE = '/web/sys/file/downloadFile/{fileId}';//下载文件
  public static SYS_FILE_DETAIL = '/web/sys/file/detail/{fileId}';//文件详情
  public static SYS_FILE_DELETE = '/web/sys/file/delete/{fileId}';//文件删除
  /** 拥有权限才能访问 end */

  public static URL_MAP =  new Map([
    [ApiConstant.GET_SERVE_TIME, new RequestUrl(ApiConstant.GET_SERVE_TIME,CommonConstant.GET)],
    [ApiConstant.WEB_LOGIN, new RequestUrl(ApiConstant.WEB_LOGIN,CommonConstant.POST)],

    [ApiConstant.LOGIN_OUT, new RequestUrl(ApiConstant.LOGIN_OUT,CommonConstant.GET)],
    [ApiConstant.GET_REDIS_TOKEN_DATA, new RequestUrl(ApiConstant.GET_REDIS_TOKEN_DATA,CommonConstant.GET)],
    [ApiConstant.GET_DICTIONARY, new RequestUrl(ApiConstant.GET_DICTIONARY,CommonConstant.POST)],

    [ApiConstant.SYS_USER_LIST,new RequestUrl(ApiConstant.SYS_USER_LIST,CommonConstant.POST,'sys:user:list')],
    [ApiConstant.SYS_USER_DELETE,new RequestUrl(ApiConstant.SYS_USER_DELETE,CommonConstant.DELETE,'sys:user:delete')],
    [ApiConstant.SYS_USER_ADD,new RequestUrl(ApiConstant.SYS_USER_ADD,CommonConstant.POST,'sys:user:add')],
    [ApiConstant.SYS_USER_MODIFY,new RequestUrl(ApiConstant.SYS_USER_MODIFY,CommonConstant.PUT,'sys:user:modify')],
    [ApiConstant.SYS_USER_DETAIL,new RequestUrl(ApiConstant.SYS_USER_DETAIL,CommonConstant.GET,'sys:user:detail')],
    [ApiConstant.SYS_USER_ROLE_INFO,new RequestUrl(ApiConstant.SYS_USER_ROLE_INFO,CommonConstant.GET,'sys:user:role:assignment')],//未在页面展示按钮权限
    [ApiConstant.SYS_USER_ROLE_ASSIGNMENT,new RequestUrl(ApiConstant.SYS_USER_ROLE_ASSIGNMENT,CommonConstant.POST,'sys:user:role:assignment')],
    [ApiConstant.SYS_USER_MODULE_INFO,new RequestUrl(ApiConstant.SYS_USER_MODULE_INFO,CommonConstant.GET,'sys:user:module:assignment')],//未在页面展示按钮权限
    [ApiConstant.SYS_USER_MODULE_ASSIGNMENT,new RequestUrl(ApiConstant.SYS_USER_MODULE_ASSIGNMENT,CommonConstant.POST,'sys:user:module:assignment')],
    [ApiConstant.SYS_USER_INIT_PASSWORD,new RequestUrl(ApiConstant.SYS_USER_INIT_PASSWORD,CommonConstant.GET,'sys:user:initPassword')],
    //[ApiConstant.SYS_USER_PORTRAIT_UPLOAD,new RequestUrl(ApiConstant.SYS_USER_PORTRAIT_UPLOAD,CommonConstant.POST)],//未在页面展示按钮权限
    //[ApiConstant.SYS_USER_PORTRAIT,new RequestUrl(ApiConstant.SYS_USER_PORTRAIT,CommonConstant.POST)],//未在页面展示按钮权限
    [ApiConstant.SYS_ROLE_LIST,new RequestUrl(ApiConstant.SYS_ROLE_LIST,CommonConstant.POST,'sys:role:list')],
    [ApiConstant.SYS_ROLE_DELETE,new RequestUrl(ApiConstant.SYS_ROLE_DELETE,CommonConstant.DELETE,'sys:role:delete')],
    [ApiConstant.SYS_ROLE_ADD,new RequestUrl(ApiConstant.SYS_ROLE_ADD,CommonConstant.POST,'sys:role:add')],
    [ApiConstant.SYS_ROLE_MODIFY,new RequestUrl(ApiConstant.SYS_ROLE_MODIFY,CommonConstant.PUT,'sys:role:modify')],
    [ApiConstant.SYS_ROLE_DETAIL,new RequestUrl(ApiConstant.SYS_ROLE_DETAIL,CommonConstant.GET,'sys:role:detail')],
    [ApiConstant.SYS_ROLE_MODULE_INFO,new RequestUrl(ApiConstant.SYS_ROLE_MODULE_INFO,CommonConstant.GET,'sys:role:module:assignment')],//未在页面展示按钮权限
    [ApiConstant.SYS_ROLE_MODULE_ASSIGNMENT,new RequestUrl(ApiConstant.SYS_ROLE_MODULE_ASSIGNMENT,CommonConstant.POST,'sys:role:module:assignment')],
    [ApiConstant.SYS_ROLE_RESTRICT_LIST,new RequestUrl(ApiConstant.SYS_ROLE_RESTRICT_LIST,CommonConstant.POST,'sys:roleRestrict:list')],
    [ApiConstant.SYS_ROLE_RESTRICT_DELETE,new RequestUrl(ApiConstant.SYS_ROLE_RESTRICT_DELETE,CommonConstant.DELETE,'sys:roleRestrict:delete')],
    [ApiConstant.SYS_ROLE_LIST_ALL,new RequestUrl(ApiConstant.SYS_ROLE_LIST_ALL,CommonConstant.GET,'sys:roleRestrict:role:listAll')],//未在页面展示按钮权限
    [ApiConstant.SYS_ROLE_RESTRICT_ADD,new RequestUrl(ApiConstant.SYS_ROLE_RESTRICT_ADD,CommonConstant.POST,'sys:roleRestrict:add')],
    [ApiConstant.SYS_ROLE_RESTRICT_MODIFY,new RequestUrl(ApiConstant.SYS_ROLE_RESTRICT_MODIFY,CommonConstant.PUT,'sys:roleRestrict:modify')],
    [ApiConstant.SYS_ROLE_RESTRICT_DETAIL,new RequestUrl(ApiConstant.SYS_ROLE_RESTRICT_DETAIL,CommonConstant.GET,'sys:roleRestrict:detail')],
    [ApiConstant.SYS_ROLE_RESTRICT_PROVINCE, new RequestUrl(ApiConstant.SYS_ROLE_RESTRICT_PROVINCE,CommonConstant.GET,'sys:roleRestrict:province')],
    [ApiConstant.SYS_ROLE_RESTRICT_CITY, new RequestUrl(ApiConstant.SYS_ROLE_RESTRICT_CITY,CommonConstant.GET,'sys:roleRestrict:city')],
    [ApiConstant.SYS_ROLE_RESTRICT_DISTRICT, new RequestUrl(ApiConstant.SYS_ROLE_RESTRICT_DISTRICT,CommonConstant.GET,'sys:roleRestrict:district')],
    [ApiConstant.SYS_MODULE_LIST,new RequestUrl(ApiConstant.SYS_MODULE_LIST,CommonConstant.POST,'sys:module:list')],
    [ApiConstant.SYS_MODULE_DELETE,new RequestUrl(ApiConstant.SYS_MODULE_DELETE,CommonConstant.DELETE,'sys:module:delete')],
    [ApiConstant.SYS_MODULE_ADD,new RequestUrl(ApiConstant.SYS_MODULE_ADD,CommonConstant.POST,'sys:module:add')],
    [ApiConstant.SYS_MODULE_MODIFY,new RequestUrl(ApiConstant.SYS_MODULE_MODIFY,CommonConstant.PUT,'sys:module:modify')],
    [ApiConstant.SYS_MODULE_MODULE_ID_AND_NAME_LIST,new RequestUrl(ApiConstant.SYS_MODULE_MODULE_ID_AND_NAME_LIST,CommonConstant.GET,'sys:module:modify')],//未在页面展示按钮权限
    [ApiConstant.SYS_MODULE_DETAIL,new RequestUrl(ApiConstant.SYS_MODULE_DETAIL,CommonConstant.GET,'sys:module:detail')],
    [ApiConstant.SYS_CONFIG_LIST,new RequestUrl(ApiConstant.SYS_CONFIG_LIST,CommonConstant.POST,'sys:config:list')],
    [ApiConstant.SYS_CONFIG_DELETE,new RequestUrl(ApiConstant.SYS_CONFIG_DELETE,CommonConstant.DELETE,'sys:config:delete')],
    [ApiConstant.SYS_CONFIG_ADD,new RequestUrl(ApiConstant.SYS_CONFIG_ADD,CommonConstant.POST,'sys:config:add')],
    [ApiConstant.SYS_CONFIG_MODIFY,new RequestUrl(ApiConstant.SYS_CONFIG_MODIFY,CommonConstant.PUT,'sys:config:modify')],
    [ApiConstant.SYS_CONFIG_DETAIL,new RequestUrl(ApiConstant.SYS_CONFIG_DETAIL,CommonConstant.GET,'sys:config:detail')],
    [ApiConstant.SYS_DICTIONARY_LIST,new RequestUrl(ApiConstant.SYS_DICTIONARY_LIST,CommonConstant.POST,'sys:dictionary:list')],
    [ApiConstant.SYS_DICTIONARY_DELETE,new RequestUrl(ApiConstant.SYS_DICTIONARY_DELETE,CommonConstant.DELETE,'sys:dictionary:delete')],
    [ApiConstant.SYS_DICTIONARY_ADD,new RequestUrl(ApiConstant.SYS_DICTIONARY_ADD,CommonConstant.POST,'sys:dictionary:add')],
    [ApiConstant.SYS_DICTIONARY_MODIFY,new RequestUrl(ApiConstant.SYS_DICTIONARY_MODIFY,CommonConstant.PUT,'sys:dictionary:modify')],
    [ApiConstant.SYS_DICTIONARY_DETAIL,new RequestUrl(ApiConstant.SYS_DICTIONARY_DETAIL,CommonConstant.GET,'sys:dictionary:detail')],
    [ApiConstant.SYS_OPERATION_LOG_LIST,new RequestUrl(ApiConstant.SYS_OPERATION_LOG_LIST,CommonConstant.POST,'sys:operationLog:list')],
    [ApiConstant.SYS_SCHEDULE_LIST,new RequestUrl(ApiConstant.SYS_SCHEDULE_LIST,CommonConstant.POST,'sys:schedule:list')],
    [ApiConstant.SYS_SCHEDULE_ADD,new RequestUrl(ApiConstant.SYS_SCHEDULE_ADD,CommonConstant.POST,'sys:schedule:add')],
    [ApiConstant.SYS_INTERFACES_LIST,new RequestUrl(ApiConstant.SYS_INTERFACES_LIST,CommonConstant.POST,'sys:interfaces:list')],
    [ApiConstant.SYS_INTERFACES_MODIFY,new RequestUrl(ApiConstant.SYS_INTERFACES_MODIFY,CommonConstant.PUT,'sys:interfaces:modify')],
    [ApiConstant.SYS_INTERFACES_DETAIL,new RequestUrl(ApiConstant.SYS_INTERFACES_DETAIL,CommonConstant.GET,'sys:interfaces:detail')],
    [ApiConstant.SYS_INTERFACES_USER_ROLE_DATA_PERMISSION,new RequestUrl(ApiConstant.SYS_INTERFACES_USER_ROLE_DATA_PERMISSION,CommonConstant.POST,'sys:interfaces:dataPermissionAssignment')],
    [ApiConstant.SYS_INTERFACES_DATA_PERMISSION_ASSIGNMENT,new RequestUrl(ApiConstant.SYS_INTERFACES_DATA_PERMISSION_ASSIGNMENT,CommonConstant.POST,'sys:interfaces:dataPermissionAssignment')],//未在页面展示按钮权限
    [ApiConstant.SYS_INTERFACES_TEST,new RequestUrl(ApiConstant.SYS_INTERFACES_TEST,CommonConstant.POST,'sys:interfaces:test')],
    [ApiConstant.SYS_ONLINE_USER_LIST,new RequestUrl(ApiConstant.SYS_ONLINE_USER_LIST,CommonConstant.POST,'sys:onlineUser:list')],
    [ApiConstant.SYS_ONLINE_USER_OFFLINE,new RequestUrl(ApiConstant.SYS_ONLINE_USER_OFFLINE,CommonConstant.GET,'sys:onlineUser:offline')],
    [ApiConstant.SYS_DB_TABLES_LIST,new RequestUrl(ApiConstant.SYS_DB_TABLES_LIST,CommonConstant.POST,'sys:dbTables:list')],
    [ApiConstant.SYS_DB_TABLES_REDUCTION,new RequestUrl(ApiConstant.SYS_DB_TABLES_REDUCTION,CommonConstant.GET,'sys:dbTables:reduction')],
    [ApiConstant.SYS_DB_TABLES_OPERATE,new RequestUrl(ApiConstant.SYS_DB_TABLES_OPERATE,CommonConstant.POST,'sys:dbTables:operate')],
    [ApiConstant.SYS_DB_TABLES_DETAIL,new RequestUrl(ApiConstant.SYS_DB_TABLES_DETAIL,CommonConstant.GET,'sys:dbTables:detail')],
    [ApiConstant.SYS_DB_TABLES_CODE_GENERATE,new RequestUrl(ApiConstant.SYS_DB_TABLES_CODE_GENERATE,CommonConstant.GET,'sys:dbTables:codeGenerate')],
    [ApiConstant.SYS_FILE_LIST,new RequestUrl(ApiConstant.SYS_FILE_LIST,CommonConstant.POST,'sys:file:list')],
    [ApiConstant.SYS_FILE_CONTENT_LIST,new RequestUrl(ApiConstant.SYS_FILE_CONTENT_LIST,CommonConstant.POST,'sys:file:contentList')],
    [ApiConstant.SYS_FILE_ROOT_PATH,new RequestUrl(ApiConstant.SYS_FILE_ROOT_PATH,CommonConstant.GET,'sys:file:contentList')],//未在页面展示按钮权限
    [ApiConstant.SYS_FILE_UPLOAD_FILE,new RequestUrl(ApiConstant.SYS_FILE_UPLOAD_FILE,CommonConstant.GET,'sys:file:uploadFile')],
    [ApiConstant.SYS_FILE_DOWNLOAD_FILE,new RequestUrl(ApiConstant.SYS_FILE_DOWNLOAD_FILE,CommonConstant.GET,'sys:file:downloadFile')],
    [ApiConstant.SYS_FILE_DETAIL,new RequestUrl(ApiConstant.SYS_FILE_DETAIL,CommonConstant.GET,'sys:file:detail')],
    [ApiConstant.SYS_FILE_DELETE,new RequestUrl(ApiConstant.SYS_FILE_DELETE,CommonConstant.DELETE,'sys:file:delete')]
  ]);//存储URL和权限点的映射

}
