package com.javaweb.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaweb.web.dao.ds1.CityDao;
import com.javaweb.web.dao.ds1.CommonDao;
import com.javaweb.web.dao.ds1.ConfigDao;
import com.javaweb.web.dao.ds1.DataPermissionDao;
import com.javaweb.web.dao.ds1.DbTablesDao;
import com.javaweb.web.dao.ds1.DictionaryDao;
import com.javaweb.web.dao.ds1.DistrictDao;
import com.javaweb.web.dao.ds1.FileDao;
import com.javaweb.web.dao.ds1.InterfacesDao;
import com.javaweb.web.dao.ds1.InterfacesStatisticsDao;
import com.javaweb.web.dao.ds1.ModuleDao;
import com.javaweb.web.dao.ds1.OperationLogDao;
import com.javaweb.web.dao.ds1.ProvinceDao;
import com.javaweb.web.dao.ds1.RoleDao;
import com.javaweb.web.dao.ds1.RoleDataDao;
import com.javaweb.web.dao.ds1.RoleModuleDao;
import com.javaweb.web.dao.ds1.RoleRestrictDao;
import com.javaweb.web.dao.ds1.ScheduleDao;
import com.javaweb.web.dao.ds1.UserDao;
import com.javaweb.web.dao.ds1.UserDataDao;
import com.javaweb.web.dao.ds1.UserModuleDao;
import com.javaweb.web.dao.ds1.UserRoleDao;

public class BaseDao extends BaseInject{
	
	public CommonDao commonDao;
	
	public ConfigDao configDao;
	
	public DictionaryDao dictionaryDao;
	
	public UserDao userDao;
	
	public RoleDao roleDao;
	
	public ModuleDao moduleDao;
	
	public RoleModuleDao roleModuleDao;
	
	public UserModuleDao userModuleDao;
	
	public UserRoleDao userRoleDao;
	
	public OperationLogDao operationLogDao;
	
	public ScheduleDao scheduleDao;
	
	public InterfacesDao interfacesDao;
	
	public DataPermissionDao dataPermissionDao;
	
	public UserDataDao userDataDao;
	
	public RoleDataDao roleDataDao;
	
	public DbTablesDao dbTablesDao;
	
	public FileDao fileDao;

	public InterfacesStatisticsDao interfacesStatisticsDao;
	
	public RoleRestrictDao roleRestrictDao;

	public ProvinceDao provinceDao;
	
	public CityDao cityDao;
	
	public DistrictDao districtDao;

	@Autowired
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Autowired
	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}

	@Autowired
	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Autowired
	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	@Autowired
	public void setRoleModuleDao(RoleModuleDao roleModuleDao) {
		this.roleModuleDao = roleModuleDao;
	}

	@Autowired
	public void setUserModuleDao(UserModuleDao userModuleDao) {
		this.userModuleDao = userModuleDao;
	}

	@Autowired
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	@Autowired
	public void setOperationLogDao(OperationLogDao operationLogDao) {
		this.operationLogDao = operationLogDao;
	}

	@Autowired
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Autowired
	public void setInterfacesDao(InterfacesDao interfacesDao) {
		this.interfacesDao = interfacesDao;
	}

	@Autowired
	public void setDataPermissionDao(DataPermissionDao dataPermissionDao) {
		this.dataPermissionDao = dataPermissionDao;
	}

	@Autowired
	public void setUserDataDao(UserDataDao userDataDao) {
		this.userDataDao = userDataDao;
	}

	@Autowired
	public void setRoleDataDao(RoleDataDao roleDataDao) {
		this.roleDataDao = roleDataDao;
	}

	@Autowired
	public void setDbTablesDao(DbTablesDao dbTablesDao) {
		this.dbTablesDao = dbTablesDao;
	}

	@Autowired
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Autowired
	public void setInterfacesStatisticsDao(InterfacesStatisticsDao interfacesStatisticsDao) {
		this.interfacesStatisticsDao = interfacesStatisticsDao;
	}

	@Autowired
	public void setRoleRestrictDao(RoleRestrictDao roleRestrictDao) {
		this.roleRestrictDao = roleRestrictDao;
	}

	@Autowired
	public void setProvinceDao(ProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}

	@Autowired
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Autowired
	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}
	
}
