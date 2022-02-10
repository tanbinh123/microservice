package com.javaweb.web.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.annotation.url.ControllerMethod;
import com.javaweb.base.BaseInject;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.base.BaseService;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.constant.ApiConstant;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.core.AesDesUtil;
import com.javaweb.util.core.DateUtil;
import com.javaweb.util.core.MathUtil;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.core.PatternUtil;
import com.javaweb.util.core.RsaUtil;
import com.javaweb.util.core.SecretUtil;
import com.javaweb.util.entity.RsaKey;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.interfaces.ExcludeInfoResponse;
import com.javaweb.web.eo.module.SidebarInfoResponse;
import com.javaweb.web.eo.user.UserLoginRequest;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.User;

//无需登录即可访问模块
@RestController
public class AllOpenController extends BaseService {
	
	@PostMapping(ApiConstant.WEB_LOGIN)
	@ControllerMethod(interfaceName="用户登录接口")
	public BaseResponseResult webLogin(@RequestBody @Validated UserLoginRequest userLoginRequest,HttpServletRequest request){
		//Part1：参数常规校验 @see GlobalExceptionHandler#handleMethodArgumentNotValidException
		//Part2：密码特殊处理
		userLoginRequest.setPassword(passwordCheck(userLoginRequest));
		if(CommonConstant.EMPTY_VALUE.equals(userLoginRequest.getPassword())){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.user.password.error");
		}
		//Part3：参数业务逻辑校验（此处暂无，可参考其它Controller写法）
		//Part4：获取用户信息
		User user = getUser(userLoginRequest);
		if(user==null){
            return getBaseResponseResult(HttpCodeEnum.LOGIN_FAIL,"login.user.userNameOrPassword");
        }
        if(user.getStatus()==1&&(!(SystemConstant.ADMIN_USER_ID.equals(user.getUserId())))){
        	return getBaseResponseResult(HttpCodeEnum.LOGIN_FAIL,"login.user.userLocked");
        }
        user.setPassword(CommonConstant.NULL_VALUE);//用户密码不留痕
        userLoginRequest.setPassword(user.getPassword());//用户密码不留痕
        //Part5：tokenData设置
        TokenData tokenData = getToken(user,userLoginRequest);
        String key = BaseInject.getRedisTokenKey(tokenData);
        String repeatLoginHandle = BaseSystemMemory.getConfigValueByKey("repeat.login.handle","1");
        if(!("1".equals(repeatLoginHandle))){//不允许重复登录
        	if(getDateFromRedisByKey(key)!=null){
        		return getBaseResponseResult(HttpCodeEnum.LOGIN_FAIL,"login.user.userAlreadyLogin");
        	}
        }
		setDefaultDataToRedis(key,tokenData);//key值组成：userId,clientType,loginWay
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"login.user.loginSuccess",tokenData.getToken());//这里我个人认为redis中包含权限信息，但是前端不需要获得太多权限信息，权限信息可以通过其它接口获得
	}
	
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */

	@GetMapping(ApiConstant.GET_SERVE_TIME)
	@ControllerMethod(interfaceName="获取服务器时间接口")
	public BaseResponseResult getServeTime(){
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"serve.getServeTime.success",DateUtil.getStringDate(DateUtil.DEFAULT_DATETIME_PATTERN));
	}
	
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */
	
	@RequestMapping(value=ApiConstant.REQUEST_LIMIT,method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@ControllerMethod(interfaceName="请求接口受限接口")
	public BaseResponseResult requestLimit() {
		return getBaseResponseResult(HttpCodeEnum.REQUEST_LIMIT,"validated.permission.requestLimit");
	}
	
	@RequestMapping(value=ApiConstant.REQUEST_PARAMETER_LOST,method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@ControllerMethod(interfaceName="请求参数缺失接口")
	public BaseResponseResult requestParameterLost() {
		return getBaseResponseResult(HttpCodeEnum.REQUEST_PARAMETER_LOST,"validated.permission.requestParameterLost");
	}
	
	@RequestMapping(value=ApiConstant.INVALID_REQUEST,method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@ControllerMethod(interfaceName="请求失效接口")
	public BaseResponseResult invalidRequest(){
		return getBaseResponseResult(HttpCodeEnum.INVALID_REQUEST,"validated.permission.invalidRequest");
	}
	
	@RequestMapping(value=ApiConstant.REQUEST_PARAMETER_ERROR,method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@ControllerMethod(interfaceName="请求参数错误接口")
	public BaseResponseResult requestParameterError(){
		return getBaseResponseResult(HttpCodeEnum.REQUEST_PARAMETER_ERROR,"validated.permission.requestParameterError");
	}
	
	@RequestMapping(value=ApiConstant.NO_AUTHORY,method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@ControllerMethod(interfaceName="没有权限接口")
	public BaseResponseResult noAuthory(){
		return getBaseResponseResult(HttpCodeEnum.NO_AUTHORY,"validated.permission.noAuthory");
	}
	
	@RequestMapping(value=ApiConstant.NOT_FOUND,method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@ControllerMethod(interfaceName="请求接口不存在接口")
	public BaseResponseResult notFound(){
		return getBaseResponseResult(HttpCodeEnum.NOT_FOUND,"validated.permission.notFound");
	}
	
	@RequestMapping(value=ApiConstant.INTERNAL_ERROR,method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@ControllerMethod(interfaceName="系统异常接口")
	public BaseResponseResult internalError(){
		return getBaseResponseResult(HttpCodeEnum.INTERNAL_ERROR,"validated.permission.internalError");
	}
	
	/* -------------------------------------------------- 分界线 -------------------------------------------------- */
	
	//密码校验
	private String passwordCheck(UserLoginRequest userLoginRequest){
		String password = decodePassword(userLoginRequest.getPassword(),userLoginRequest.getTime());
		if(!PatternUtil.isPattern(password,UserLoginRequest.PASSWORD_REGEXP_PATTERN)){
			return CommonConstant.EMPTY_VALUE;
		}
		return password;
	}

	//解码密码
	private String decodePassword(String password,String time){
		String out = CommonConstant.EMPTY_VALUE;
    	try{
			char[] charArray = password.toCharArray();
			int one,another;char tmp;
			for(int i=time.length()-1;i>=0;){
				one = Integer.parseInt(String.valueOf(time.charAt(i--)));
				another = Integer.parseInt(String.valueOf(time.charAt(i--)));
				tmp = charArray[one];
				charArray[one] = charArray[another];
				charArray[another] = tmp;
			}
			out = SecretUtil.base64DecoderString(String.valueOf(charArray),"UTF-8");
			int position = (int)(Long.parseLong(time)%2);
			if(position==0){//偶数
				out = out.substring(0,out.length()-time.length());
			}else{//奇数
				out = out.substring(time.length(),out.length());
			}
		}catch(Exception e){
			//do nothing
		}
		return out;
	}
	
	//获取用户信息
	private User getUser(UserLoginRequest userLoginRequest){
		User user = null;
		try{
			user = userService.userDetail(SystemConstant.ADMIN_USER_ID);//获取admin用户
			if(user==null){
				user = SystemConstant.ADMIN_USER;
				userService.userAdd(user);
			}
			String dbForAdminUsername = user.getUserName();
			String dbForAdminPassword = user.getPassword();
			String username = userLoginRequest.getUsername();
			String password = SecretUtil.getSecret(userLoginRequest.getPassword(),"SHA-256");
			if((username.equals(dbForAdminUsername))&&(password.equals(dbForAdminPassword))&&(1==userLoginRequest.getClientType())&&(1==userLoginRequest.getLoginWay())){
				//do nothing
			}else{
				userLoginRequest.setPassword(password);
				user = userService.userLogin(userLoginRequest);
			}
		}catch(Exception e){
			//do nothing
		}
		return user;
	}
	
	//token数据封装
	private TokenData getToken(User user,UserLoginRequest userLoginRequest){
		TokenData tokenData = new TokenData();
		List<Module> moduleList = moduleService.getModule(user.getUserId());
		String date = DateUtil.getStringDate(DateUtil.DATETIME_PATTERN_TYPE1);
		String token = getTokenForEasyWay(user,userLoginRequest,date);
		tokenData.setToken(token);
		tokenData.setUser(user);
		tokenData.setClientType(userLoginRequest.getClientType());
		tokenData.setLoginWay(userLoginRequest.getLoginWay());
		tokenData.setDate(date);
		tokenData.setPageUrlList(getPageUrlList(moduleList));//获得pageUrl列表
		tokenData.setAliasList(getAliasList(moduleList));//获得alias列表
		tokenData.setApiUrlList(getApiUrlList(moduleList));//获得ApiUrl列表
		setRsaKey(tokenData);
		List<Module> modules = moduleList.stream().filter(i->1==i.getModuleType()||2==i.getModuleType()).sorted(Comparator.comparing(Module::getOrders)).collect(Collectors.toList());//获得目录、菜单列表并封装成树型结构
		List<SidebarInfoResponse> menuListForTree = new ArrayList<>();
		menuListForTree = ObjectOperateUtil.copyListProperties(modules,SidebarInfoResponse.class);//主要用到：moduleName、pageUrl、icon
		menuListForTree = setTreeList(menuListForTree,null);//setTreeList(menuListForTree);
		tokenData.setMenuListForTree(menuListForTree);
		if(!(SystemConstant.ADMIN_USER_ID.equals(user.getUserId()))){//非管理员时的数据权限处理
			List<ExcludeInfoResponse> excludeInfoResponseList = interfacesService.getExcludeInfoResponseList(user.getUserId());
			tokenData.setExcludeInfoResponseList(excludeInfoResponseList);
		}
		return tokenData;
	}
	
	//简单获得token
	private String getTokenForEasyWay(User user,UserLoginRequest userLoginRequest,String date) {
		String randomNumber = String.valueOf(MathUtil.getRandomNumForLCRC(Integer.MAX_VALUE-1));
		//740600474:1138f985-6b8a-4a2b-983a-abbe87056899:20211109142454
		String out = randomNumber + CommonConstant.COLON + SecretUtil.getRandomUUID(false) + CommonConstant.COLON + date;
		//740600474:1138f985-6b8a-4a2b-983a-abbe87056899:20211109142454,-1,1,1
		out = out + CommonConstant.COMMA + user.getUserId() + CommonConstant.COMMA + userLoginRequest.getClientType() + CommonConstant.COMMA + userLoginRequest.getLoginWay();
		//ymWCwezIKsJ5ScfmfU8XGTI/inVjNRO7fQhw95OqTd/3JWKEkGXHnsLdrxl+iI7Z3uONRFANPVqjVAFAip6aClNITYV/iTib2mp9en9ho3o=
		out = AesDesUtil.encryptAes(out,SystemConstant.TOKEN_AES_KEY);
		try {
			//eW1XQ3dleklLc0o1U2NmbWZVOFhHVEkvaW5Wak5STzdmUWh3OTVPcVRkLzNKV0tFa0dYSG5zTGRyeGwraUk3WjN1T05SRkFOUFZxalZBRkFpcDZhQ2xOSVRZVi9pVGliMm1wOWVuOWhvM289
			out = SecretUtil.base64EncoderString(out,"UTF-8");
		} catch (Exception e) {
			//do nothing
		}
		return out;
	}
	
	//获得pageUrl列表
	private List<String> getPageUrlList(List<Module> moduleList){
		List<String> pageUrlList = new ArrayList<>();
		for(int i=0;i<moduleList.size();i++){
			String pageUrl = moduleList.get(i).getPageUrl();
			if((pageUrl!=null)&&(!CommonConstant.EMPTY_VALUE.equals(pageUrl))){
				pageUrlList.add(pageUrl);
			}
		}
		pageUrlList = pageUrlList.stream().distinct().collect(Collectors.toList());
		return pageUrlList;
	}
	
	//获得alias列表
	private List<String> getAliasList(List<Module> moduleList){
		List<String> aliasList = new ArrayList<>();
		for(int i=0;i<moduleList.size();i++){
			Module module = moduleList.get(i);
			String alias = module.getAlias();
			if((alias!=null)&&(!CommonConstant.EMPTY_VALUE.equals(alias))&&(3==module.getModuleType())){
				aliasList.add(alias);
			}
		}
		aliasList = aliasList.stream().distinct().collect(Collectors.toList());
		return aliasList;
	}
	
	//获得apiUrl列表
	private List<String> getApiUrlList(List<Module> moduleList){
		List<String> apiUrlList = new ArrayList<>();
		for(int i=0;i<moduleList.size();i++){
			String apiUrl = moduleList.get(i).getApiUrl();
			if((apiUrl!=null)&&(!CommonConstant.EMPTY_VALUE.equals(apiUrl))){
				String apiUrls[] = apiUrl.split(CommonConstant.COMMA);//某一操作可能会调用多个附属操作（即API接口），多个附属操作约定用逗号分开
				for(String each:apiUrls){
					apiUrlList.add(each);
				}
			}
		}
		apiUrlList = apiUrlList.stream().distinct().collect(Collectors.toList());
		return apiUrlList;
	}
	
	//RSA秘钥设置
	private void setRsaKey(TokenData tokenData){
		RsaKey rsaKey = RsaUtil.getRsaKey();
		tokenData.setRsaPublicKey1(rsaKey.getRsaStringPublicKey());
		tokenData.setRsaPrivateKey1(rsaKey.getRsaStringPrivateKey());
		rsaKey = RsaUtil.getRsaKey();
		tokenData.setRsaPublicKey2(rsaKey.getRsaStringPublicKey());
		tokenData.setRsaPrivateKey2(rsaKey.getRsaStringPrivateKey());
	}
	
	//封装成树形结构集合（递归版）
	private List<SidebarInfoResponse> setTreeList(List<SidebarInfoResponse> originList,SidebarInfoResponse module){
		List<SidebarInfoResponse> moduleList = new ArrayList<>();
		for (int i = 0; i < originList.size(); i++) {
			SidebarInfoResponse currentModule = originList.get(i);
			//这里树形结构处理时需要parentId只能为null，不能为空或其它值（这个在模块新增和修改时已经控制了）
			//Long类型，封装类型一定要用equals或longValue()比较！！！，形如：module.getModuleId().longValue()==currentModule.getParentId().longValue()
			if((module!=null&&module.getModuleId().equals(currentModule.getParentId()))||(module==null&&currentModule.getParentId()==null)){
				currentModule.setList(setTreeList(originList, currentModule));
				moduleList.add(currentModule);
			}
		}
		return moduleList;
	}
	
	/**
	//封装成树形结构集合（非递归版）[代码没问题，但是写的不够好，复杂了]
    private List<SidebarInfoResponse> setTreeList(List<SidebarInfoResponse> list){
        List<List<SidebarInfoResponse>> deepList = getEachDeep(list);
        for(int i=deepList.size()-1;i>0;i--){
            List<SidebarInfoResponse> childs = deepList.get(i);
            List<SidebarInfoResponse> parrents = deepList.get(i-1);
            //将子类归属于父类
            for(int j=0;j<parrents.size();j++){
            	SidebarInfoResponse parentModule = parrents.get(j);
                for(int k=0;k<childs.size();){
                	SidebarInfoResponse childModule = childs.get(k);
                    if(parentModule.getModuleId().equals(childModule.getParentId())){
                        List<SidebarInfoResponse> parentsList = parentModule.getList();
                        parentsList = (parentsList==null?new ArrayList<>():parentsList);
                        parentsList.add(childModule);
                        parentModule.setList(parentsList);
                        childs.remove(k);
                        k=0;
                    }else{
                    	k++;
                    }
                }
                parrents.set(j,parentModule);
            }
            deepList.set(i-1, parrents);
        }
        return deepList.get(0);
    }
	
    //归类每一层
    private List<List<SidebarInfoResponse>> getEachDeep(List<SidebarInfoResponse> list){
        List<List<SidebarInfoResponse>> arrayList = new ArrayList<>();//定义一个深度集合
        int deep = 0;//深度
        classifyFirstLevel(list,arrayList,deep);
        for(int i=0;i<list.size();){
        	deep++;
        	classifyNoFirstLevel(list,arrayList,deep);
        }
        return arrayList;
    }
    
    //归类第一层（deep==0）
    private void classifyFirstLevel(List<SidebarInfoResponse> list,List<List<SidebarInfoResponse>> arrayList,int deep){
        List<SidebarInfoResponse> first = new ArrayList<>();
        for(int i=0;i<list.size();){
        	SidebarInfoResponse each = list.get(i);
        	if(each.getParentId()==null){
        		first.add(each);
        		list.remove(each);
        		i=0;
        	}else{
        		i++;
        	}
        }
        arrayList.add(deep,first);
    }
    
    //归类非第一层（deep!=0）
    private void classifyNoFirstLevel(List<SidebarInfoResponse> list,List<List<SidebarInfoResponse>> arrayList,int deep){
    	List<SidebarInfoResponse> parentLevel = arrayList.get(deep-1);//上一层
    	List<SidebarInfoResponse> noFirst = new ArrayList<>();
    	for(int i=0;i<parentLevel.size();i++){
    		SidebarInfoResponse eachParentElement = parentLevel.get(i);
    		for(int j=0;j<list.size();){
            	SidebarInfoResponse each = list.get(j);
            	if(each.getParentId().equals(eachParentElement.getModuleId())){
            		noFirst.add(each);
            		list.remove(each);
            		i=0;
            	}else{
            		i++;
            	}
            }
    	}
    	arrayList.add(deep,noFirst);
    }
    */
	
}
