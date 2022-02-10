package com.javaweb.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseDao;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.core.StringUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictAllResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictAddRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictListRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictListResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictModifyRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.RoleModule;
import com.javaweb.web.po.RoleRestrict;
import com.javaweb.web.po.User;
import com.javaweb.web.po.UserRole;
import com.javaweb.web.service.RoleRestrictService;

@Service("roleRestrictServiceImpl")
public class RoleRestrictServiceImpl extends BaseDao implements RoleRestrictService {

	//判断角色限定是否存在交集（true：存在交集；false：不存在交集）
	@Override
	public boolean roleRestrictIntersect(String province,String city,String district,String roleId,Integer restrictWay) {
		if(restrictWay==1){
			QueryWapper<RoleRestrict> queryWapper = new QueryWapper<>();
			queryWapper.eq(RoleRestrict.roleIdColumn,roleId);
			queryWapper.eq(RoleRestrict.restrictWayColumn,1);
            Long count = roleRestrictDao.selectListCount(queryWapper);
            if(count!=null&&count.longValue()>0){
                return true;
            }
            return false;
		}else{
			QueryWapper<RoleRestrict> queryWapper = new QueryWapper<>();
			queryWapper.eq(RoleRestrict.roleIdColumn,roleId);
			queryWapper.eq(RoleRestrict.restrictWayColumn,2);
            List<RoleRestrict> roleRestrictList = roleRestrictDao.selectList(queryWapper);
            if((roleRestrictList!=null)&&(roleRestrictList.size()>0)){
            	for(RoleRestrict each:roleRestrictList){
                    //三者相同，肯定是交集
                    if((each.getProvince().equals(province))&&
                       (each.getCity().equals(city))&&
                       (each.getDistrict().equals(district))){
                    	return true;
                    }
                    //原有角色限定省为全部，则现限定省再为全部就没有意义了
                    if(each.getProvince().equals(SystemConstant.ALL)||province.equals(SystemConstant.ALL)){
                        return true;
                    }
                    //在省相同的情况下，原有角色限定市为全部，则现限定市再为全部就没有意义了
                    if(each.getProvince().equals(province)&&(each.getCity().equals(SystemConstant.ALL)||city.equals(SystemConstant.ALL))){
                        return true;
                    }
                    //在省和市相同的情况下，原有角色限定区为全部，则现限定区再为全部就没有意义了
                    if((each.getProvince().equals(province)&&(each.getCity().equals(city))&&(each.getDistrict().equals(SystemConstant.ALL)||district.equals(SystemConstant.ALL)))){
                        return true;
                    }
                    //如果有self，先不做校验，因为没法从角色定位到具体省、市、区
                }
            }
            return false;
		}
	}

	@Transactional
	@Override
	public void roleRestrictAdd(RoleRestrictAddRequest roleRestrictAddRequest,User user) {
		RoleRestrict roleRestrict = new RoleRestrict();
		roleRestrict.setCreator(user.getUserId());
		roleRestrict.setCreateDate(new Date());
		ObjectOperateUtil.copyProperties(roleRestrictAddRequest,roleRestrict);
		roleRestrictDao.insert(roleRestrict);
	}

	@Override
	public RoleRestrict roleRestrictDetail(String roleRestrictId) {
		QueryWapper<RoleRestrict> queryWapper = new QueryWapper<>();
		queryWapper.eq(RoleRestrict.idColumn,roleRestrictId);
		queryWapper.eq(RoleRestrict.delFlagColumn,0);
		return roleRestrictDao.selectOne(queryWapper);
	}

	@Transactional
	@Override
	public void roleRestrictModify(RoleRestrictModifyRequest roleRestrictModifyRequest,User user) {
		RoleRestrict roleRestrict = new RoleRestrict();
		roleRestrict.setUpdater(user.getUserId());
		roleRestrict.setUpdateDate(new Date());
		ObjectOperateUtil.copyProperties(roleRestrictModifyRequest,roleRestrict);
		roleRestrictDao.update(roleRestrict);
	}
	
	@Transactional
	@Override
	public void roleRestrictDelete(String roleRestrictId) {
		String roleRestrictIds[] = roleRestrictId.split(CommonConstant.COMMA);
		for(String id:roleRestrictIds){
			roleRestrictDao.delete(id);
		}
	}

	@Override
	public Page roleRestrictList(RoleRestrictListRequest roleRestrictListRequest) {
		List<RoleRestrictListResponse> list = roleRestrictDao.roleRestrictList(roleRestrictListRequest);
		long count = roleRestrictDao.roleRestrictListCount(roleRestrictListRequest);
		Page page = new Page(roleRestrictListRequest,list,count);
		return page;
	}
	
	//合并省市区列表
	@Override
	public List<ProvinceCityDistrictAllResponse> mergeSSQResponseList(List<ProvinceCityDistrictAllResponse> list){
		List<ProvinceCityDistrictAllResponse> outList = new ArrayList<>();
		Optional<ProvinceCityDistrictAllResponse> jgOptional = list.stream().filter(e->SystemConstant.ALL.equals(e.getProvince())).findFirst();
		if(jgOptional.isPresent()){
			outList.add(new ProvinceCityDistrictAllResponse(SystemConstant.ALL,SystemConstant.ALL,SystemConstant.ALL));
		}else{
			List<ProvinceCityDistrictAllResponse> newList = new ArrayList<>();
			Map<String,List<ProvinceCityDistrictAllResponse>> map = list.stream().collect(Collectors.groupingBy(ProvinceCityDistrictAllResponse::getProvince));
			Set<String> jgSet = map.keySet();
			for(String each:jgSet){
				List<ProvinceCityDistrictAllResponse> bmList = map.get(each);
				Optional<ProvinceCityDistrictAllResponse> bmOptional = bmList.stream().filter(e->SystemConstant.ALL.equals(e.getCity())).findFirst();
				if(bmOptional.isPresent()){
					newList.add(bmOptional.get());
				}else{
					newList.addAll(bmList);
				}
			}
			List<ProvinceCityDistrictAllResponse> newList2 = new ArrayList<>();
			Map<String,List<ProvinceCityDistrictAllResponse>> map2 = newList.stream().collect(Collectors.groupingBy(e->e.getCity()+e.getDistrict()));
			Set<String> bmSet = map2.keySet();
			for(String each:bmSet){
				List<ProvinceCityDistrictAllResponse> ksList = map2.get(each);
				Optional<ProvinceCityDistrictAllResponse> ksOptional = ksList.stream().filter(e->SystemConstant.ALL.equals(e.getDistrict())).findFirst();
				if(ksOptional.isPresent()){
					newList2.add(ksOptional.get());
				}else{
					newList2.addAll(ksList);
				}
			}
			outList = newList2;
		}
		return outList;
	}
	
	//获取权限代码
	@Override
	public String getPrivilegeCode(/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern) {
		String privilegeCode = null;
		if(/*httpServletRequest*/bestMatchingPattern!=null){
			QueryWapper<Module> queryWapper = new QueryWapper<>();
			queryWapper.like(Module.apiUrlColumn,bestMatchingPattern);
			queryWapper.eq(Module.delFlagColumn,0);
			List<Module> moduleList = moduleDao.selectList(queryWapper);
			if(moduleList!=null&&moduleList.size()>0){
				loop:for(int i=0;i<moduleList.size();i++){
					Module each = moduleList.get(i);
					String apiUrl = each.getApiUrl();
					if(!CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(apiUrl))){
						String apiUrls[] = apiUrl.split(CommonConstant.COMMA);
						for(int j=0;j<apiUrls.length;j++){
							if(/*httpServletRequest.getServletPath()*/bestMatchingPattern.equals(apiUrls[j])){
								/**
								code    api_url
								a       /x
								b       /xa/y
								c       /xo/z,/x
								原则上code可以精确定位api_url，但是如果通过api_url去定位code，如上面的情况（一般下拉列表常见），那么只取首先匹配到的
								*/
								privilegeCode = each.getAlias();
								break loop;
							}
						}
					}
				}
			}
		}
		return privilegeCode;
	}
	
	//个人与组织是否重叠
	@Override
	public boolean personalInOrganize(boolean containsPersonal,User user,List<ProvinceCityDistrictAllResponse> list) {
		boolean personalInOrganize = true;
		if(list.size()<1){
			personalInOrganize = false;
		}else{
			if(containsPersonal){//包含个人限定
				String province = user.getProvince();
				String city = user.getCity();
				String district = user.getDistrict();
				long count = list.stream().filter(e->(SystemConstant.ALL.equals(e.getProvince()))||(e.getProvince()+CommonConstant.COMMA+e.getCity()+CommonConstant.COMMA+e.getDistrict()).equals(province+CommonConstant.COMMA+city+CommonConstant.COMMA+district)).count();
				if(count<1){//个人和组织无重叠
					personalInOrganize = false;
				}
			}
		}
		return personalInOrganize;
	}
	
	//个人和组织重叠省市区获取（不重叠时并集处理方式）
	@Override
	public List<ProvinceCityDistrictAllResponse> getOverlayList(User user,List<ProvinceCityDistrictAllResponse> list) {
		if(list==null||list.size()<1){
			return null;
		}
		String province = user.getProvince();
		String city = user.getCity();
		String district = user.getDistrict();
		long count = list.stream().filter(e->(SystemConstant.ALL.equals(e.getProvince()))||(e.getProvince()+CommonConstant.COMMA+e.getCity()+CommonConstant.COMMA+e.getDistrict()).equals(province+CommonConstant.COMMA+city+CommonConstant.COMMA+district)).count();
		if(count<1){
			list.add(new ProvinceCityDistrictAllResponse(province,city,district));
			return list;
		}else{
			return list;
		}
	}
	
	//角色限定信息获取
	@Override
	public RoleRestrictResponse roleRestrict(User user,/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern) {
		return this.roleRestrict(user,null,/*httpServletRequest*/bestMatchingPattern);
	}
	
	//角色限定信息获取
	@Override
	public RoleRestrictResponse roleRestrict(User user,String privilegeCode,/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern) {
		if(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(privilegeCode))){
			privilegeCode = this.getPrivilegeCode(/*httpServletRequest*/bestMatchingPattern);//自动获取
		}
		boolean personalInOrganize = true;//个人是否包含在组织内
		boolean containsPersonal = false;//是否包含个人限定
		List<ProvinceCityDistrictAllResponse> list = new ArrayList<>();//省市区列表
		if(SystemConstant.ADMIN_USER_ID.equals(user.getUserId())){//管理员所有省市区
		    list.add(new ProvinceCityDistrictAllResponse(SystemConstant.ALL,SystemConstant.ALL,SystemConstant.ALL));
		}else{
		    List<UserRole> userRoleList = userRoleDao.selectList(new QueryWapper<UserRole>().eq(UserRole.userIdColumn,user.getUserId()));//获得该用户下的所有角色
		    if(userRoleList==null||userRoleList.size()==0) {//这里认为没有分配角色的用户无任何省市区权限
				list.clear();//空集合
		    }else{
				List<UserRole> newUserRole = new ArrayList<>();
				for(int i=0;i<userRoleList.size();i++){
					/**
					Role role = roleDao.selectOne(new QueryWapper<Role>().eq(Role.roleIdColumn,userRoleList.get(i).getRoleId()));
					if(role!=null&&(role.getType()==0)){//TODO 根据登录的客户端类型动态处理 @see com.javaweb.web.po.Role#roleType
						continue;
					}
					*/
					List<RoleModule> roleModuleList = roleModuleDao.selectList(new QueryWapper<RoleModule>().eq(RoleModule.roleIdColumn,userRoleList.get(i).getRoleId()));
					if(roleModuleList!=null&&roleModuleList.size()>0){
						List<Module> modules = moduleDao.getModuleByModuleId(roleModuleList.stream().map(e->e.getModuleId()).collect(Collectors.toList()));
						if(modules!=null&&modules.size()>0){
							final String newPrivilegeCode = privilegeCode;
							if(newPrivilegeCode!=null){
								Optional<Module> optional = modules.stream().filter(e->newPrivilegeCode.equals(e.getAlias())).findFirst();
								if(optional.isPresent()){
									//if(0==optional.get().getType()){//TODO 只取指定端的角色 @see com.javaweb.web.po.Module#type
										newUserRole.add(userRoleList.get(i));
									//}
								}
							}
						}
					}
				}
				if(newUserRole.size()>0){
					userRoleList = newUserRole;//过滤掉非指定端的角色
				}
				if(userRoleList==null||userRoleList.size()<1){
					list.clear();//空集合
				}else{
				    for(int i=0;i<userRoleList.size();i++){
						List<RoleRestrict> roleRestrictList = roleRestrictDao.selectList(new QueryWapper<RoleRestrict>().eq(RoleRestrict.roleIdColumn,userRoleList.get(i).getRoleId()).eq(RoleRestrict.delFlagColumn,0));
						if(roleRestrictList==null||roleRestrictList.size()==0){//没有角色限定就是不限定
							list.add(new ProvinceCityDistrictAllResponse(SystemConstant.ALL,SystemConstant.ALL,SystemConstant.ALL));
						}else{
						    for(RoleRestrict roleRestrict:roleRestrictList){
								if(roleRestrict.getRestrictWay().intValue()==1){//1：本人；2：非本人
								    containsPersonal = true;
								    break;
								}
						    }
						    for(RoleRestrict roleRestrict:roleRestrictList){
						    	list.add(new ProvinceCityDistrictAllResponse(roleRestrict.getProvince().replace(SystemConstant.SELF,user.getProvince()),roleRestrict.getCity().replace(SystemConstant.SELF,user.getCity()),roleRestrict.getDistrict().replace(SystemConstant.SELF,user.getDistrict())));
						    }
						}
				    }
				    if(list!=null&&list.size()>1){//多条数据合并处理（只有大于等于2才需要合并，1条合并没有意义）
				    	list = this.mergeSSQResponseList(list);
				    }
				}
		    }
		    personalInOrganize = personalInOrganize(containsPersonal,user,list);
		}
		//list是否为空？为空则限定个人；不为空则看个人是否包含在list内？如果个人包含在list内则取list；如果个人不包含在list内则看具体业务，一般认为取并集
		return new RoleRestrictResponse(containsPersonal,personalInOrganize,list);
	}

}
