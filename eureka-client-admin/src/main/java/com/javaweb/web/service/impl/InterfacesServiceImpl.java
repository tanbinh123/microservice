package com.javaweb.web.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import com.javaweb.annotation.url.ControllerMethod;
import com.javaweb.base.BaseDao;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.enums.AuthEnum;
import com.javaweb.util.core.DateUtil;
import com.javaweb.util.core.HttpUtil;
import com.javaweb.util.core.SecretUtil;
import com.javaweb.util.core.SystemUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.interfaces.ExcludeInfoResponse;
import com.javaweb.web.eo.interfaces.InterfacesListRequest;
import com.javaweb.web.eo.interfaces.InterfacesTestRequest;
import com.javaweb.web.eo.interfaces.RolePermissionResponse;
import com.javaweb.web.eo.interfaces.UserPermissionResponse;
import com.javaweb.web.eo.interfaces.UserRoleDataPermissionRequest;
import com.javaweb.web.eo.interfaces.UserRolePermissionRequest;
import com.javaweb.web.po.Interfaces;
import com.javaweb.web.po.InterfacesStatistics;
import com.javaweb.web.po.RoleData;
import com.javaweb.web.po.User;
import com.javaweb.web.po.UserData;
import com.javaweb.web.po.UserRole;
import com.javaweb.web.service.InterfacesService;

import net.sf.json.JSONObject;

@Service("interfacesServiceImpl")
public class InterfacesServiceImpl extends BaseDao implements InterfacesService {
	
	@Override
	public Page interfacesList(InterfacesListRequest interfacesListRequest) {
		List<Interfaces> list = interfacesDao.interfacesList(interfacesListRequest);
		if(list!=null){
			//只是为了显示方便（逗号分隔，回车展示）
			list.stream().forEach(e->e.setUrl(String.join(SystemUtil.isLinux()==true?CommonConstant.ENTER_LINUX:CommonConstant.ENTER_WINDOWS,e.getUrl().split(CommonConstant.COMMA))));
		}
		long count = interfacesDao.interfacesListCount(interfacesListRequest);
		Page page = new Page(interfacesListRequest,list,count);
		return page;
	}
	
	@Override
	public Interfaces interfacesDetail(String interfacesId) {
		return interfacesDao.selectByPk(interfacesId);
	}

	@Transactional
	@Override
	public void interfacesModify(Interfaces interfaces) {
		interfacesDao.update(interfaces);
	}

	@Transactional
	@Override
	public void synchronizedInterfaces() {
		List<Interfaces> projectList = getAllInterfaces();//获得本项目中的所有接口
		List<Interfaces> dbList = getAll();//获得数据库中的所有接口
		List<Interfaces> forUpdate = new ArrayList<>();
		List<Interfaces> forInsert = new ArrayList<>();
		for(int i=0;i<projectList.size();i++){
			Interfaces projectListEach = projectList.get(i);
			boolean continueFlag = true;
			for(int j=0;j<dbList.size();j++){
				Interfaces dbListEach = dbList.get(j);
				if(projectListEach.getUrl().trim().equals(dbListEach.getUrl().trim())){//存在则更新
					dbListEach.setName(projectListEach.getName());
					dbListEach.setUrl(projectListEach.getUrl());
					dbListEach.setClassMethod(projectListEach.getClassMethod());
					dbListEach.setAuth(projectListEach.getAuth());
					dbListEach.setMethod(projectListEach.getMethod());
					dbListEach.setDataPermission(projectListEach.getDataPermission());
					dbListEach.setLogRecord(projectListEach.getLogRecord());
					dbListEach.setEntity(projectListEach.getEntity());
					dbListEach.setHistoryTimes(projectListEach.getHistoryTimes());
					dbListEach.setUpdateDate(new Date());
					dbListEach.setUpdater(SystemConstant.ADMIN_USER_ID);
					forUpdate.add(dbListEach);
					dbList.remove(dbListEach);
					continueFlag = false;
					break;
				}
			}
			if(continueFlag){
				projectListEach.setId(idGenerator.idCreate());
				projectListEach.setDataPermission(CommonConstant.ZERO_NUMBER_VALUE);
				projectListEach.setLogRecord(CommonConstant.ZERO_NUMBER_VALUE);
				projectListEach.setHistoryTimes(new BigInteger(CommonConstant.ZERO_STRING_VALUE));
				projectListEach.setRequestDataSecret(CommonConstant.ZERO_NUMBER_VALUE);
				projectListEach.setResponseDataSecret(CommonConstant.ZERO_NUMBER_VALUE);
				projectListEach.setCreateDate(new Date());
				projectListEach.setCreator(SystemConstant.ADMIN_USER_ID);
				projectListEach.setDelFlag(CommonConstant.ZERO_NUMBER_VALUE);
				forInsert.add(projectListEach);
			}
		}
		if(dbList.size()>0){
			interfacesDao.interfacesBatchDelete(dbList.stream().map(e->e.getId()).collect(Collectors.toList()));
		}
		if(forUpdate.size()>0){
			for(int k=0;k<forUpdate.size();k++){
				interfacesDao.update(forUpdate.get(k));
			}
		}
		if(forInsert.size()>0){
			interfacesDao.interfacesBatchInsert(forInsert);
		}
	}
	
	private List<Interfaces> getAllInterfaces(){
		List<Interfaces> list = new ArrayList<>();
		Map<RequestMappingInfo,HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
		Set<RequestMappingInfo> set = map.keySet();
		Iterator<RequestMappingInfo> iterator = set.iterator();
		Map<String,String> urlMap = new HashMap<>();
		while(iterator.hasNext()){
			Interfaces interfaces = new Interfaces();
			RequestMappingInfo requestMappingInfo = iterator.next();
			HandlerMethod handlerMethod = map.get(requestMappingInfo);
			String methodName = requestMappingInfo.getMethodsCondition().getMethods().toString().replace("[","").replace("]","");
			String url = requestMappingInfo.getPathPatternsCondition().toString().replace("[","").replace("]", "").replace(" || ",",");
			String classMethod = handlerMethod.getBeanType().getName() + CommonConstant.POUND + handlerMethod.getMethod().getName();
			BaseSystemMemory.requestMappingUrlMap.put(url,requestMappingInfo);
			ControllerMethod controllerMethod = null;
			if(urlMap.get(url)==null){
				interfaces.setDataPermission(0);
				try{
					controllerMethod = map.get(requestMappingInfo).getMethodAnnotation(ControllerMethod.class);
					if(controllerMethod!=null){
						interfaces.setName(controllerMethod.interfaceName());
						interfaces.setAuth(controllerMethod.auth().name());
						Class<?> c = controllerMethod.dataPermissionEntity();
						if(!(ControllerMethod.class.getName().equals(c.getName()))){//不是DataPermission的实例，定义了明确的实体类
							interfaces.setDataPermission(1);
							interfaces.setEntity(Stream.of(c.getDeclaredFields()).map(e->e.getName()).filter(e->!"serialVersionUID".equals(e)).collect(Collectors.toList()).toString());
						}
					}else{
						interfaces.setName("缺失@ControllerMethod_"+SecretUtil.defaultGenUniqueStr(SystemConstant.SYSTEM_NO));
						interfaces.setAuth(AuthEnum.NO_LOGIN.name());
					}
				}catch(Exception e){
					//do nothing
				}
				/**
				 * 建议url应该写成：/a/{x}，而不要写成/a/{x}/b/{y}，尤其是/{x}/a
				 * 当url出现/{a}/b和/c/b时，会优先匹配固定路径，这里是/c/b
				 */
				interfaces.setUrl(url);//interfaces.setUrl(url.split(CommonConstant.COMMA)[0].replaceAll("/\\{.*\\}",CommonConstant.EMPTY_VALUE));
				interfaces.setClassMethod(classMethod);
				interfaces.setMethod(methodName);
				list.add(interfaces);
				urlMap.put(url,url);
			}
		}
		return list;
	}

	@Override
	public Page userRoleDataPermission(UserRoleDataPermissionRequest userRoleDataPermissionRequest) {
		if(userRoleDataPermissionRequest.getType()==1){//用户
			List<UserPermissionResponse> userPermissionResponseList = interfacesDao.userPermissionList(userRoleDataPermissionRequest);
			long count = interfacesDao.userPermissionListCount(userRoleDataPermissionRequest);
			Page page = new Page(userRoleDataPermissionRequest,userPermissionResponseList,count);
			return page;
		}else{//角色
			List<RolePermissionResponse> rolePermissionResponseList = interfacesDao.rolePermissionList(userRoleDataPermissionRequest);
			long count = interfacesDao.rolePermissionListCount(userRoleDataPermissionRequest);
			Page page = new Page(userRoleDataPermissionRequest,rolePermissionResponseList,count);
			return page;
		}
	}

	@Transactional
	@Override
	public void dataPermissionAssignment(UserRolePermissionRequest userRolePermissionResponse,String interfacesId,User user) {
		List<UserPermissionResponse> userPermissionResponseList = userRolePermissionResponse.getUserPermissionResponseList();
		List<RolePermissionResponse> rolePermissionResponseList = userRolePermissionResponse.getRolePermissionResponseList();
		//根据user_id删除user_data和data_permission相关的数据
		List<String> userIds = userPermissionResponseList.stream().map(e->e.getUserId()).collect(Collectors.toList());
		if(userIds!=null&&userIds.size()>0){
			interfacesDao.deleteUserDataPermission(userIds);
		}
		//根据user_id删除user_data和data_permission相关的数据
		List<String> roleIds = rolePermissionResponseList.stream().map(e->e.getRoleId()).collect(Collectors.toList());
		if(roleIds!=null&&roleIds.size()>0){
			interfacesDao.deleteRoleDataPermission(roleIds);
		}
		userPermissionResponseList = userPermissionResponseList.stream().filter(e->{return (e.getExcludeField()!=CommonConstant.NULL_VALUE)&&(!e.getExcludeField().equals(CommonConstant.EMPTY_VALUE));}).collect(Collectors.toList());
		rolePermissionResponseList = rolePermissionResponseList.stream().filter(e->{return (e.getExcludeField()!=CommonConstant.NULL_VALUE)&&(!e.getExcludeField().equals(CommonConstant.EMPTY_VALUE));}).collect(Collectors.toList());
		for(int i=0;i<userPermissionResponseList.size();i++){//用户数据权限
			com.javaweb.web.po.DataPermission dataPermission = new com.javaweb.web.po.DataPermission();
			String dataPermissionId = idGenerator.idCreate();
			dataPermission.setId(dataPermissionId);
			dataPermission.setExcludeField(userPermissionResponseList.get(i).getExcludeField());
			dataPermission.setInterfacesId(interfacesId);
			dataPermission.setCreateDate(new Date());
			dataPermission.setCreator(user.getUserId());
			UserData userData = new UserData();
			userData.setId(idGenerator.idCreate());
			userData.setUserId(userPermissionResponseList.get(i).getUserId());
			userData.setDataPermissionId(dataPermissionId);
			dataPermissionDao.insert(dataPermission);
			userDataDao.insert(userData);
		}
		for(int i=0;i<rolePermissionResponseList.size();i++){//角色数据权限
			com.javaweb.web.po.DataPermission dataPermission = new com.javaweb.web.po.DataPermission();
			String dataPermissionId = idGenerator.idCreate();
			dataPermission.setId(dataPermissionId);
			dataPermission.setExcludeField(rolePermissionResponseList.get(i).getExcludeField());
			dataPermission.setInterfacesId(interfacesId);
			dataPermission.setCreateDate(new Date());
			dataPermission.setCreator(user.getUserId());
			RoleData roleData = new RoleData();
			roleData.setId(idGenerator.idCreate());
			roleData.setRoleId(rolePermissionResponseList.get(i).getRoleId());
			roleData.setDataPermissionId(dataPermissionId);
			dataPermissionDao.insert(dataPermission);
			roleDataDao.insert(roleData);
		}
	}
	
	@Override
	public List<ExcludeInfoResponse> getExcludeInfoResponseList(String userId){
		//1、根据当前用户ID获得用户角色和策略
		List<UserRole> userRoleList = userRoleDao.selectList(new QueryWapper<UserRole>().eq(UserRole.userIdColumn,userId));
		//2、根据当前用户的用户ID获得data_permission_id
		List<UserData> userDataList = userDataDao.selectAllByUserId(userId);
		//3、根据当前用户的角色ID获得data_permission_id
		List<String> roleIdList = userRoleList.stream().map(e->e.getRoleId()).collect(Collectors.toList());
		List<RoleData> roleDataList = roleDataDao.selectAllByRoleIds(roleIdList);
		//4、获得数据权限集合
		List<String> allList = new ArrayList<>(); 
		for(int i=0;i<userRoleList.size();i++){
			List<String> list = null;
			UserRole userRole = userRoleList.get(i);
			int strategy = userRole.getDataStrategy();//权限获取策略（0：自定义；1：并集；2：交集；3：以用户权限为准；4：以角色权限为准；其它：默认为未定义，作为并集处理）
			List<String> list1 = userDataList.stream().map(e->e.getDataPermissionId()).collect(Collectors.toList());
			List<String> list2 = roleDataList.stream().map(e->e.getDataPermissionId()).collect(Collectors.toList());
			switch(strategy){
				case 0:
					list = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());//其它情况暂做并集处理
					break;
				case 1:
					list = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());
					break;
				case 2:
					list = list1.stream().filter(item->list2.contains(item)).distinct().collect(Collectors.toList());
					break;
				case 3:
					list = list1;
					break;
				case 4:
					list = list2;
					break;
				default:
					list = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());//其它情况暂做并集处理
					break;
			}
			allList.addAll(list);
		}
		allList = allList.stream().distinct().collect(Collectors.toList());
		//5、获得data_permission集合
		if(allList.size()<=0){
			return SystemConstant.EMPTY_EXCLUDE_INFO_RESPONSE_LSIT;
		}else{
			return dataPermissionDao.selectExcludeInfo(allList);
		}
	}

	@Override
	public void synchronizedRedisInterfaceHistoryTimes() {
		List<Interfaces> interfacesList = interfacesDao.selectAll();
		final String yearMonthDay = DateUtil.getStringDate(DateUtil.DEFAULT_DATE_PATTERN);
		QueryWapper<InterfacesStatistics> queryWapper = new QueryWapper<>();
		queryWapper.eq(InterfacesStatistics.yearMonthDayColumn,yearMonthDay);
		List<InterfacesStatistics> interfacesStatisticsList = interfacesStatisticsDao.selectList(queryWapper);
		if(interfacesStatisticsList==null){
			interfacesStatisticsList = new ArrayList<>();
		}
		Set<Object> set = stringRedisTemplate.opsForHash().keys(SystemConstant.REDIS_INTERFACE_COUNT_KEY);
		if(interfacesList!=null&&interfacesList.size()>0){
			for(int m=0;m<interfacesList.size();m++){
				boolean findFlag = false;
				for(int n=0;n<interfacesStatisticsList.size();n++){
					if(interfacesList.get(m).getUrl().equals(interfacesStatisticsList.get(n).getUrl())){
						findFlag = true;
						break;
					}
				}
				if(!findFlag){
					InterfacesStatistics interfacesStatistics = new InterfacesStatistics();
					interfacesStatistics.setUrl(interfacesList.get(m).getUrl());
					interfacesStatistics.setYearMonthDay(yearMonthDay);
					interfacesStatistics.setYear(yearMonthDay.split(CommonConstant.BAR)[0]);
					interfacesStatistics.setMonth(yearMonthDay.split(CommonConstant.BAR)[1]);
					interfacesStatistics.setDay(yearMonthDay.split(CommonConstant.BAR)[2]);
					interfacesStatistics.setInsertTime(new Date());
					interfacesStatistics.setTimes(new BigInteger(CommonConstant.ZERO_STRING_VALUE));
					interfacesStatisticsDao.insert(interfacesStatistics);
					interfacesStatisticsList.add(interfacesStatistics);
				}
			}
			if(set!=null&&set.size()>0){
				for(Object obj:set){
					String url = obj.toString();
					BigInteger historyTimes = new BigInteger(stringRedisTemplate.opsForHash().get(SystemConstant.REDIS_INTERFACE_COUNT_KEY,obj).toString());
					for(int i=0;i<interfacesList.size();i++){
						Interfaces each = interfacesList.get(i);
						if(each.getUrl().equals(url)){
							each.setHistoryTimes(historyTimes.add(each.getHistoryTimes()));//数字累加
							stringRedisTemplate.opsForHash().put(SystemConstant.REDIS_INTERFACE_COUNT_KEY,obj,CommonConstant.ZERO_STRING_VALUE);//重置redis中的统计数据为0
							break;
						}
					}
					for(int i=0;i<interfacesStatisticsList.size();i++){
						InterfacesStatistics each = interfacesStatisticsList.get(i);
						if(each.getUrl().equals(url)){
							each.setTimes(historyTimes.add(each.getTimes()));//数字累加
							break;
						}
					}
				}
			}
			final List<Interfaces> finalInterfacesList = interfacesList;
			final List<InterfacesStatistics> finalInterfacesStatisticsList = interfacesStatisticsList;
			new Thread(()->{
				for(int i=0;i<finalInterfacesList.size();i++){
					interfacesDao.update(finalInterfacesList.get(i));//更新库中的统计数据信息
				}
			}).start();
			new Thread(()->{
				for(int i=0;i<finalInterfacesStatisticsList.size();i++){
					interfacesStatisticsDao.update(finalInterfacesStatisticsList.get(i));//更新库中的统计数据信息
				}
			}).start();
		}
	}

	@Override
	public List<Interfaces> getAll() {
		List<Interfaces> interfacesList = interfacesDao.selectAll();//获得数据库中的所有接口
		if(interfacesList!=null&&interfacesList.size()>0){
			for(int i=0;i<interfacesList.size();i++){
				BaseSystemMemory.interfacesUrlMap.put(interfacesList.get(i).getUrl(),interfacesList.get(i));
			}
		}
		return interfacesList;	
	}

	@Override
	public String interfacesTest(InterfacesTestRequest interfacesTestRequest) {
		String out = null;
		try{
			String url = interfacesTestRequest.getRequestUrl();
			List<Header> list = null;
			if(interfacesTestRequest.getRequestHeader()!=null&&!"".equals(interfacesTestRequest.getRequestHeader().trim())){
				list = new ArrayList<>();
				try{
					String keyvalue[] = interfacesTestRequest.getRequestHeader().split(CommonConstant.SEMICOLON);
					for(String str:keyvalue){
						String strs[] = str.split(CommonConstant.COLON); 
						Header header = new BasicHeader(strs[0],strs[1]);
						list.add(header);
					}
				}catch(Exception e){
					//header解析错误暂不做任何处理
				}
			}
			String body = interfacesTestRequest.getRequestBody();
			if(body!=null&&!"".equals(body)){
				body = JSONObject.fromObject(body.replaceAll("\n","")).toString();
			}
			if("GET".equals(interfacesTestRequest.getRequestType().toUpperCase())){
				out = HttpUtil.defaultGetRequest(url,list);
			}else if("PUT".equals(interfacesTestRequest.getRequestType().toUpperCase())){
				out = HttpUtil.defaultPutRequest(url,body,list);
			}else if("POST".equals(interfacesTestRequest.getRequestType().toUpperCase())){
				out = HttpUtil.defaultPostRequest(url,body,list);
			}else if("DELETE".equals(interfacesTestRequest.getRequestType().toUpperCase())){
				out = HttpUtil.defaultDeleteRequest(url,body,list);
			}
		}catch(Exception e){
			out = e.getMessage();
		}
		return out;
	}

}
