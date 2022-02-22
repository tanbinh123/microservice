package com.javaweb.constant;

import java.util.Date;

import com.javaweb.web.po.User;

public final class SystemConstant {
	
	public static final String SYSTEM_NO = "1";
	
	public static final String PROJECT_GITHUB_URL = "https://github.com/tank2140896/microservice";

	public static final String BASE_PACKAGE = "com.javaweb";
	
	public static final String DEFAULT_DATA_SOURCE_POINT_CUT = "execution(* com.javaweb.web.dao..*.*(..))";
	
	public static final String DEFAULT_LOG_POINT_CUT = "execution(* com.javaweb.web.controller..*.*(..))";
	
	public static final String DEFAULT_GLOBAL_RESPONSEBODY_PACKAGE = "com.javaweb.web.controller";

	public static final String DEFAULT_DISTRIBUTED_TIMED_TASK_POINT_CUT = "@annotation(com.javaweb.annotation.task.DistributedTimedTask)";
	
	public static final String DATA_SOURCE_PACKAGE_NAME_1 = "ds1";
	
	public static final String DATA_SOURCE_PACKAGE_NAME_2 = "ds2";
	
	public static final String DATA_SOURCE_KEY_1 = "mysql_d1";
	
	public static final String DATA_SOURCE_KEY_2 = "mysql_d2";
	
	public static final String URL_ALL_PATTERN = "/*";

	public static final String TOKEN_AES_KEY = "+6'V^QgAEiV!GmvL&MkL6~fh";//SecretUtil.defaultGenRandomPass(24);//这里固定写死，如果动态的话相当于服务器每次重启都不一样，但是分布式部署时需要考虑值的统一

	public static final String TOKEN_KEY_PREFIX = "tokenKey" + CommonConstant.COLON;

    public static final String CONFIG_TOPIC = "CONFIG";
    
    public static final String DICTIONARY_TOPIC = "DICTIONARY";
    
    public static final String INTERFACES_TOPIC = "INTERFACES";
	
	public static final String BEST_MATCHING_PATTERN = "org.springframework.web.servlet.HandlerMapping.bestMatchingPattern";
	
	public static final String HEAD_USERID = "userId";
	
	public static final String HEAD_TOKEN = "token";
	
	public static final String HEAD_ALIAS = "alias";
	
	public static final String REDIS_TEMPLATE = "redisTemplate";
	
	public static final String ENVIRONMENT = "environment";
	
	public static final String REDIS_INTERFACE_COUNT_KEY = "redis_interface_count_key";
	
	public static final String REQUEST_URL_CHAIN_ATTRIBUTE_NAME = "interfaces";

	public static final String DISTRIBUTED_TIMED_TASK_KEY = "LOCK";
	
	public static final String SELF = "self";
	
	public static final String ALL = "all";
	
	public static final String ADMIN_USER_ID = "-1";
	
	public static final String ADMIN_USER_NAME = "admin";
	
	public static final String ADMIN_PASSWORD = "admin";
	
	public static final User ADMIN_USER = new User();
	static{
		Date date = new Date();
		ADMIN_USER.setUserId(ADMIN_USER_ID);/**改造代码时不建议修改此值*/
		ADMIN_USER.setUserName(ADMIN_USER_NAME);//改造代码时一般不建议修改
		ADMIN_USER.setPassword(ADMIN_PASSWORD);/*改造代码时强烈建议修改*/
		ADMIN_USER.setPersonName("管理员");//改造代码时可以修改
		ADMIN_USER.setLevel(CommonConstant.ZERO_NUMBER_VALUE);/**改造代码时不建议修改此值*/
		ADMIN_USER.setRemark("管理员，该账号无法被删除，即使删除也会被恢复");//改造代码时可以修改
		ADMIN_USER.setStatus(CommonConstant.ZERO_NUMBER_VALUE);/**改造代码时不建议修改此值*/
		ADMIN_USER.setRealNameStatus(CommonConstant.ZERO_NUMBER_VALUE);//改造代码时一般不建议修改
		ADMIN_USER.setCreator(ADMIN_USER_ID);/**改造代码时不建议修改此值*/
		ADMIN_USER.setCreateDate(date);//改造代码时可以修改
		ADMIN_USER.setUpdater(ADMIN_USER_ID);/**改造代码时不建议修改此值*/
		ADMIN_USER.setUpdateDate(date);//改造代码时可以修改
		ADMIN_USER.setDelFlag(CommonConstant.ZERO_NUMBER_VALUE);/**改造代码时不建议修改此值*/
	}
	
	/** 数组、集合定义为final依然是可以被修改的，所以采用下面的写法（数组：数组.clone()） */
	//private static final List<Module> E_M_L = new ArrayList<>();
	//public static final List<Module> EMPTY_MODULE_LSIT = Collections.unmodifiableList(E_M_L);
	//或
	//public static final List<Module> EMPTY_MODULE_LSIT = Collections.emptyList();
	
}
