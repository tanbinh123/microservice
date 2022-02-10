package com.javaweb.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaweb.base.BaseDao;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.core.StringUtil;
import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictAllResponse;
import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;
import com.javaweb.web.po.City;
import com.javaweb.web.service.CityService;

@Service("cityServiceImpl")
public class CityServiceImpl extends BaseDao implements CityService {
	
	@Override
	public List<ProvinceCityDistrictResponse> getCityList(String provinceCode,RoleRestrictResponse roleRestrictResponse) {
		List<ProvinceCityDistrictAllResponse> list = roleRestrictResponse.getList();
		List<City> sourceList = new ArrayList<>();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				QueryWapper<City> queryWapper = new QueryWapper<>();
				if(!CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(provinceCode))){
					queryWapper.eq(City.provinceCodeColumn,provinceCode);
				}
				ProvinceCityDistrictAllResponse pcdar = list.get(i);
				if(SystemConstant.ALL.equals(pcdar.getCity())){
					sourceList = cityDao.selectList(queryWapper);
					break;
				}else{
					City city = cityDao.selectOne(queryWapper.eq(City.codeColumn,pcdar.getCity()));
					if(city!=null){
						sourceList.add(city);
					}
				}
			}
		}else{
			QueryWapper<City> queryWapper = new QueryWapper<>();
			if(!CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(provinceCode))){
				queryWapper.eq(City.provinceCodeColumn,provinceCode);
			}
			sourceList = cityDao.selectList(queryWapper);
		}
		List<ProvinceCityDistrictResponse> targetList = ObjectOperateUtil.copyListProperties(sourceList,ProvinceCityDistrictResponse.class);
		return targetList;
	}

	@Override
	public boolean isExistBySelectProvinceAndCityCode(String provinceCode, String cityCode) {
		QueryWapper<City> queryWapper = new QueryWapper<>();
		queryWapper.eq(City.provinceCodeColumn,provinceCode);
		queryWapper.eq(City.codeColumn,cityCode);
		List<City> list = cityDao.selectList(queryWapper);
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
