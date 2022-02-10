package com.javaweb.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaweb.base.BaseDao;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictAllResponse;
import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;
import com.javaweb.web.po.Province;
import com.javaweb.web.service.ProvinceService;

@Service("provinceServiceImpl")
public class ProvinceServiceImpl extends BaseDao implements ProvinceService {
	
	@Override
	public List<ProvinceCityDistrictResponse> getProvinceList(RoleRestrictResponse roleRestrictResponse) {
		List<ProvinceCityDistrictAllResponse> list = roleRestrictResponse.getList();
		List<Province> sourceList = new ArrayList<>();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				ProvinceCityDistrictAllResponse pcdar = list.get(i);
				if(SystemConstant.ALL.equals(pcdar.getProvince())){
					sourceList = provinceDao.selectList(new QueryWapper<>());
					break;
				}else{
					Province province = provinceDao.selectOne(new QueryWapper<Province>().eq(Province.codeColumn,pcdar.getProvince()));
					if(province!=null){
						sourceList.add(province);
					}
				}
			}
		}else{
			sourceList = provinceDao.selectList(new QueryWapper<>());
		}
		List<ProvinceCityDistrictResponse> targetList = ObjectOperateUtil.copyListProperties(sourceList,ProvinceCityDistrictResponse.class);
		return targetList;
	}

	@Override
	public boolean isExistBySelectProvinceCode(String provinceCode) {
		QueryWapper<Province> queryWapper = new QueryWapper<>();
		queryWapper.eq(Province.codeColumn,provinceCode);
		List<Province> list = provinceDao.selectList(queryWapper);
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
