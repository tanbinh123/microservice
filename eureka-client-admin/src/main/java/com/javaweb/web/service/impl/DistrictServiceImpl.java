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
import com.javaweb.web.po.District;
import com.javaweb.web.service.DistrictService;

@Service("districtServiceImpl")
public class DistrictServiceImpl extends BaseDao implements DistrictService {
	
	@Override
	public List<ProvinceCityDistrictResponse> getDistrictList(String cityCode,RoleRestrictResponse roleRestrictResponse) {
		List<ProvinceCityDistrictAllResponse> list = roleRestrictResponse.getList();
		List<District> sourceList = new ArrayList<>();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				QueryWapper<District> queryWapper = new QueryWapper<>();
				if(!CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(cityCode))){
					queryWapper.eq(District.cityCodeColumn,cityCode);
				}
				ProvinceCityDistrictAllResponse pcdar = list.get(i);
				if(SystemConstant.ALL.equals(pcdar.getCity())){
					sourceList = districtDao.selectList(queryWapper);
					break;
				}else{
					District district = districtDao.selectOne(queryWapper.eq(District.codeColumn,pcdar.getCity()));
					if(district!=null){
						sourceList.add(district);
					}
				}
			}
		}else{
			QueryWapper<District> queryWapper = new QueryWapper<>();
			if(!CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(cityCode))){
				queryWapper.eq(District.cityCodeColumn,cityCode);
			}
			sourceList = districtDao.selectList(queryWapper);
		}
		List<ProvinceCityDistrictResponse> targetList = ObjectOperateUtil.copyListProperties(sourceList,ProvinceCityDistrictResponse.class);
		return targetList;
	}

	@Override
	public boolean isExistBySelectCityAndDistrictCode(String cityCode, String districtCode) {
		QueryWapper<District> queryWapper = new QueryWapper<>();
		queryWapper.eq(District.cityCodeColumn,cityCode);
		queryWapper.eq(District.codeColumn,districtCode);
		List<District> list = districtDao.selectList(queryWapper);
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
