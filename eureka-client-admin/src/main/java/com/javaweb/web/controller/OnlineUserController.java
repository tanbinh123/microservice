package com.javaweb.web.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.annotation.token.TokenDataAnnotation;
import com.javaweb.annotation.url.ControllerMethod;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.base.BaseService;
import com.javaweb.constant.ApiConstant;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.AuthEnum;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.core.DateUtil;
import com.javaweb.util.core.PageUtil;
import com.javaweb.util.core.StringUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.onlineUser.OnlineUserListRequest;
import com.javaweb.web.eo.onlineUser.OnlineUserListResponse;
import com.javaweb.web.po.User;

//登录且需要权限才可访问的在线用户管理模块
@RestController
@RequestMapping(ApiConstant.WEB_ONLINE_USER_PREFIX)
public class OnlineUserController extends BaseService {
	
	@PostMapping(ApiConstant.ONLINE_USER_LIST)
	@ControllerMethod(interfaceName="在线用户列表接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult list(@RequestBody OnlineUserListRequest onlineUserListRequest,@TokenDataAnnotation TokenData tokenData){
		Set<String> set = stringRedisTemplate.keys(SystemConstant.TOKEN_KEY_PREFIX+"*,1,1");//只取页面端用账号密码登录的在线用户
		set = (set==null?Collections.emptySet():set);
		List<String> sortedList = new ArrayList<>();
		for(String str:set){
			sortedList.add(str.split(SystemConstant.TOKEN_KEY_PREFIX)[1].split(CommonConstant.COMMA)[0]);
		}
		//去除管理员和当前登录用户
		sortedList = sortedList.stream().filter(e->(!e.equals(SystemConstant.ADMIN_USER_ID))).filter(e->(!e.equals(tokenData.getUser().getUserId()))).collect(Collectors.toList());
		List<User> userList = userService.getAllUsers();
		String userName = onlineUserListRequest.getUserName();
		if(StringUtil.handleNullString(userName).trim().equals(CommonConstant.EMPTY_VALUE)){
			sortedList = sortedList.stream().sorted().collect(Collectors.toList());
		}else{
			sortedList = sortedList.stream().filter(e->{
				for(User user:userList){
					if(e.equals(user.getUserId())&&user.getUserName().contains(userName)){
						return true;
					}
				}
				return false;
			}).sorted().collect(Collectors.toList());
		}
		sortedList = PageUtil.getSubList(sortedList,onlineUserListRequest.getPageSize(),onlineUserListRequest.getCurrentPage());
		if(sortedList==null){
			sortedList = new ArrayList<>();
		}
		List<OnlineUserListResponse> list = new ArrayList<>();
		if(sortedList.size()!=0){
			final List<String> usedSortedList = sortedList;
			//List<User> needUserList = userService.getUsersByUserId(usedSortedList.stream().map(e->e.split(CommonConstant.COMMA)[0]).collect(Collectors.toList()));
			List<User> needUserList = userList.stream().filter(e->usedSortedList.contains(e.getUserId())).collect(Collectors.toList());
			for(int i=0;i<needUserList.size();i++){
				User eachUser = needUserList.get(i);
				OnlineUserListResponse onlineUserListResponse = new OnlineUserListResponse();
				onlineUserListResponse.setUserId(eachUser.getUserId());
				onlineUserListResponse.setUserName(eachUser.getUserName());
				try{
					String date = ((TokenData)valueOperations.get(eachUser.getUserId()+",1,1")).getDate();
					onlineUserListResponse.setLoginTime(DateUtil.getStringDateTime(date,DateUtil.DATETIME_PATTERN_TYPE1,DateUtil.DEFAULT_DATETIME_PATTERN));
					long getSecond = DateUtil.getDuration(DateUtil.getDateTime(onlineUserListResponse.getLoginTime(),DateUtil.DEFAULT_DATETIME_PATTERN),LocalDateTime.now()).getSeconds();
					long day = getSecond/(60*60*24);
					long hour = (getSecond-(60*60*24*day))/3600;
					long minute = (getSecond-60*60*24*day-3600*hour)/60;
					long second = getSecond-60*60*24*day-3600*hour-60*minute;
					onlineUserListResponse.setOnlineTime(day+"天"+hour+"时"+minute+"分"+second+"秒");
				}catch(Exception e){
					//do nothing
				}
				list.add(onlineUserListResponse);
			}
		}
		Page page = new Page(onlineUserListRequest,list,(set.size()+0L));
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"onlineUser.list.success",page);
	}
	
	@GetMapping(ApiConstant.ONLINE_USER_OFFLINE)
	@ControllerMethod(interfaceName="用户下线接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult offline(@PathVariable(name="key",required=true) String key){
		stringRedisTemplate.delete(key);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"onlineUser.offline.success",null);
	}

}
