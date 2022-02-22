package com.javaweb.base;

import java.io.File;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.javaweb.config.datasource.common.IdGenerator;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.context.ApplicationContextHelper;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.core.AesDesUtil;
import com.javaweb.util.core.DateUtil;
import com.javaweb.util.core.FileUtil;
import com.javaweb.util.core.MathUtil;
import com.javaweb.util.core.SecretUtil;
import com.javaweb.util.core.SystemUtil;
import com.javaweb.web.eo.TokenData;
import com.netflix.discovery.EurekaClient;

//注入全部改为了set注入（1、属性@Autowired注入；2、set注入；3、构造方法注入）
public class BaseInject {
	
    public EurekaClient eurekaClient;
    
	@Autowired
	public void setEurekaClient(EurekaClient eurekaClient) {
		this.eurekaClient = eurekaClient;
	}
    
    public DiscoveryClient discoveryClient;
    
	@Autowired
	public void setDiscoveryClient(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}
	
	public RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@Autowired
	public void setRequestMappingHandlerMapping(RequestMappingHandlerMapping requestMappingHandlerMapping) {
		this.requestMappingHandlerMapping = requestMappingHandlerMapping;
	}
	
	public IdGenerator idGenerator;
	
	@Autowired
	public void setIdGenerator(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}
	
	public Environment environment;
	
	@Autowired
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	public MessageSource messageSource;
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public JdbcTemplate mysqlD1JdbcTemplate;
	
	@Autowired
	@Qualifier("mysql_d1_JdbcTemplate")
	public void setMysqlD1JdbcTemplate(JdbcTemplate mysqlD1JdbcTemplate) {
		this.mysqlD1JdbcTemplate = mysqlD1JdbcTemplate;
	}
	
	public JdbcTemplate mysqlD2JdbcTemplate;
	
	@Autowired
	@Qualifier("mysql_d2_JdbcTemplate")
	public void setMysqlD2JdbcTemplate(JdbcTemplate mysqlD2JdbcTemplate) {
		this.mysqlD2JdbcTemplate = mysqlD2JdbcTemplate;
	}
	
	public StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	@Qualifier("redisTemplate")
	public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}
	
	public ValueOperations<Object,Object> valueOperations;
	
	@Resource(name="redisTemplate")
	public void setValueOperations(ValueOperations<Object,Object> valueOperations) {
		this.valueOperations = valueOperations;
	}
	
	public RestTemplate restTemplate;
	
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */
	
	private static RedisTemplate<String,Object> staticRedisTemplate = null;
	
	private static Environment staticEnvironment = null;
	
	public long getAllRedisKeys(){
		return stringRedisTemplate.getConnectionFactory().getConnection().dbSize();
	}
	
	//key传形如：*a*
	public Set<String> redisKeySearch(String key,long totalCount){
		return stringRedisTemplate.execute((RedisCallback<Set<String>>) connection -> {
			Set<String> binaryKeys = new HashSet<>();
            Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().match(key).count(totalCount).build());
            while(cursor.hasNext()) {
                binaryKeys.add(new String(cursor.next()));
            }
            return binaryKeys;
		});
	}
	
	public void setDataToRedis(String key,Object value,Duration duration){
		if(duration==null){
			valueOperations.set(key,value);
		}else{
			valueOperations.set(key,value,duration);
		}
	}
	
	public void setDefaultDataToRedis(String key,Object value){
		valueOperations.set(key,value,Duration.ofMinutes(Long.parseLong(environment.getProperty("redis.session.timeout"))));
	}
	
	public Object getDateFromRedisByKey(String key){
		return valueOperations.get(key);
	}
	
	public boolean deleteFromRedisByKey(String key) {
		return stringRedisTemplate.delete(key);
	}

	public String getMessage(String messageKey){
		try{
			return messageSource.getMessage(messageKey,null,LocaleContextHolder.getLocale());
		}catch(Exception e){
			return messageKey;
		}
	}
	
	public String getValidateMessage(BindingResult bindingResult){
		String message = CommonConstant.EMPTY_VALUE;
		List<ObjectError> list = bindingResult.getAllErrors();
		if(list!=null&&list.size()>0){
			message = getMessage(list.get(0).getDefaultMessage());
		}
		return message;
	}
	
	public BaseResponseResult getBaseResponseResult(HttpCodeEnum httpCodeEnum,String messageKey) {
		return new BaseResponseResult(httpCodeEnum.getCode(),getMessage(messageKey),CommonConstant.EMPTY_VALUE);
	}
	
	public BaseResponseResult getBaseResponseResult(HttpCodeEnum httpCodeEnum,String messageKey,Object data) {
		return new BaseResponseResult(httpCodeEnum.getCode(),getMessage(messageKey),data);
	}
	
	public BaseResponseResult getBaseResponseResult(HttpCodeEnum httpCodeEnum,BindingResult bindingResult) {
		return new BaseResponseResult(httpCodeEnum.getCode(),getValidateMessage(bindingResult),CommonConstant.EMPTY_VALUE);
	}
	
	public BaseResponseResult getBaseResponseResult(HttpCodeEnum httpCodeEnum,BindingResult bindingResult,Object data) {
		return new BaseResponseResult(httpCodeEnum.getCode(),getValidateMessage(bindingResult),data);
	}
	
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */
	
	//优先获取header里的token
	public static String getToken(HttpServletRequest httpServletRequest){
		String token = httpServletRequest.getHeader(SystemConstant.HEAD_TOKEN);//1、支持header传参方式
		if(token==null){
			token = httpServletRequest.getParameter(SystemConstant.HEAD_TOKEN);//2、支持问号传参方式
		}
		return token;
	}
	
	//优先获取header里的token
	public static String getToken(NativeWebRequest nativeWebRequest){
		String token = nativeWebRequest.getHeader(SystemConstant.HEAD_TOKEN);//1、支持header传参方式
		if(token==null){
			token = nativeWebRequest.getParameter(SystemConstant.HEAD_TOKEN);//2、支持问号传参方式
		}
		return token;
	}
	
	//优先获取header里的token
	public static String getToken(ServerHttpRequest serverHttpRequest){
		String token = serverHttpRequest.getHeaders().getFirst(SystemConstant.HEAD_TOKEN);//1、支持header传参方式
		if(token==null){
			try{
				token = serverHttpRequest.getURI().getPath();//2、支持问号传参方式
				token = token.split(SystemConstant.HEAD_TOKEN+CommonConstant.EQUAL)[1].split(CommonConstant.AND)[0];
			}catch(Exception e){
				//do nothing
			}
		}
		return token;
	}
	
	public static TokenData getTokenData(String token){
		TokenData tokenData = null;
		try{
			if(token!=null){
				token = SecretUtil.base64DecoderString(token,"UTF-8");
				token = AesDesUtil.decryptAes(token,SystemConstant.TOKEN_AES_KEY);
		    	String tokens[] = token.split(CommonConstant.COMMA);
		    	token = tokens[1]+CommonConstant.COMMA+tokens[2]+CommonConstant.COMMA+tokens[3];//userId,clientType,loginWay
		    	tokenData = (TokenData)(getRedisTemplate().opsForValue().get(token));
			}
		}catch(Exception e){
			//do nothing
		}
		return tokenData;
	}
	
	public static String getRedisTokenKey(TokenData tokenData){
		return tokenData.getUser().getUserId()+CommonConstant.COMMA+tokenData.getClientType()+CommonConstant.COMMA+tokenData.getLoginWay();//userId,clientType,loginWay
	}
	
	@SuppressWarnings("unchecked")
	public static RedisTemplate<String,Object> getRedisTemplate(){
		if(staticRedisTemplate==null){
			//BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
			//RedisTemplate redisTemplate = (RedisTemplate)factory.getBean(SystemConstant.REDIS_TEMPLATE); 
			staticRedisTemplate = (RedisTemplate<String,Object>)ApplicationContextHelper.getBean(SystemConstant.REDIS_TEMPLATE);
		}
		return staticRedisTemplate;
	}
	
	public static Object getDateFromRedisTemplateByKey(String key){
		return getRedisTemplate().opsForValue().get(key);
	}
	
	public static Environment getEnvironment(){
		if(staticEnvironment==null){
			//BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
			//RedisTemplate redisTemplate = (RedisTemplate)factory.getBean(SystemConstant.REDIS_TEMPLATE); 
			staticEnvironment = (Environment)ApplicationContextHelper.getBean(SystemConstant.ENVIRONMENT);
		}
		return staticEnvironment;
	}
	
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */
	
	//快速校验
	public static final Validator FAST_VALIDATOR = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
	
	//全部校验
	public static final Validator ALL_VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

	public static <T> List<String> fastFailValidate(T t) {
		List<String> errorMessages = new LinkedList<String>();
		Set<ConstraintViolation<T>> constraintViolations = FAST_VALIDATOR.validate(t);
        if(constraintViolations!=null&&constraintViolations.size()>0){
        	//constraintViolations.iterator().next().getPropertyPath().toString()
        	errorMessages.add(constraintViolations.iterator().next().getMessage());
        }
        return errorMessages;
    }
	
	public static <T> List<String> allCheckValidate(T t) {
		List<String> errorMessages = new LinkedList<String>();
        Set<ConstraintViolation<T>> constraintViolations = ALL_VALIDATOR.validate(t);
        if(constraintViolations!=null&&constraintViolations.size()>0) {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            while(iterator.hasNext()){
                ConstraintViolation<T> violation = iterator.next();
                //violation.getPropertyPath().toString()
                errorMessages.add(violation.getMessage());
            }
        }
        return errorMessages;
	}
	
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */
	
	//获取文件根路径
	public static String getFileRootPath(){
		String rootPath = CommonConstant.EMPTY_VALUE;
		if(SystemUtil.isLinux()) {//linux路径
            rootPath = BaseSystemMemory.getConfigValueByKey("file.root.linux.path","/tmp/file/");
        } else {//windows路径
        	rootPath = BaseSystemMemory.getConfigValueByKey("file.root.windows.path","E:\\file\\");
        }
		FileUtil.makeFolder(new File(rootPath));
		return rootPath;
	}
	
	//获取文件根路径
	public static String getFileUploadPath(){
		String rootPath = getFileRootPath();
		String yearMonthDay = DateUtil.getDefaultDate(DateUtil.DATE_PATTERN_TYPE1);//年月日
		int random = MathUtil.getRandomNumForLCRO(10);//(int)(Math.random()*10);//0-9
		if(SystemUtil.isLinux()) {//linux路径
            rootPath += (random+"/"+yearMonthDay+"/");
        } else {//windows路径
        	rootPath += (random+"\\\\"+yearMonthDay+"\\\\");
        }
		FileUtil.makeFolder(new File(rootPath));
		return rootPath;
	}
	
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */
	
	/** 暂未规划好
	public <T> T getRequestInfoAndEasyCheck(TokenData tokenData,String jsonBody,Class<T> valueType) throws Exception {
		T t = null;
		Interfaces interfaces = BaseSystemMemory.interfacesUrlMap.get(tokenData.getBestMatchingPattern());
		//System.out.println(interfaces.getResponseDataSecret());
		if(interfaces.getRequestDataSecret().intValue()==1){//加密
			t = new ObjectMapper().readValue(jsonBody,valueType);
		}else{//非1都认为不加密
			SecretRequest secretRequest = new ObjectMapper().readValue(jsonBody,SecretRequest.class);
			t = new ObjectMapper().readValue(secretRequest.getCode(),valueType);
		}
		return t;
	}
	*/
	
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */

}
