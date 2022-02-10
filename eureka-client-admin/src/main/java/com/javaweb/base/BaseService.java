package com.javaweb.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaweb.web.service.CityService;
import com.javaweb.web.service.ConfigService;
import com.javaweb.web.service.DbTablesService;
import com.javaweb.web.service.DictionaryService;
import com.javaweb.web.service.DistrictService;
import com.javaweb.web.service.FileService;
import com.javaweb.web.service.InterfacesService;
import com.javaweb.web.service.ModuleService;
import com.javaweb.web.service.OperationLogService;
import com.javaweb.web.service.ProvinceService;
import com.javaweb.web.service.RoleRestrictService;
import com.javaweb.web.service.RoleService;
import com.javaweb.web.service.ScheduleService;
import com.javaweb.web.service.UserService;
import com.javaweb.web.service.ValidateService;

public class BaseService extends BaseDao {
	
    public ConfigService configService;
	
    public DictionaryService dictionaryService;
    
	public UserService userService;
	
	public RoleService roleService;
	
	public ModuleService moduleService;
	
	public OperationLogService operationLogService;
	
	public ScheduleService scheduleService;
	
	public InterfacesService interfacesService;
	
	public DbTablesService dbTablesService;
	
	public FileService fileService;
	
	public ValidateService validateService;
	
	public RoleRestrictService roleRestrictService;
	
	public ProvinceService provinceService;
	
	public CityService cityService;
	
	public DistrictService districtService;

	@Autowired
	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	@Autowired
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Autowired
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	@Autowired
	public void setOperationLogService(OperationLogService operationLogService) {
		this.operationLogService = operationLogService;
	}

	@Autowired
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@Autowired
	public void setInterfacesService(InterfacesService interfacesService) {
		this.interfacesService = interfacesService;
	}

	@Autowired
	public void setDbTablesService(DbTablesService dbTablesService) {
		this.dbTablesService = dbTablesService;
	}

	@Autowired
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	@Autowired
	public void setValidateService(ValidateService validateService) {
		this.validateService = validateService;
	}

	@Autowired
	public void setRoleRestrictService(RoleRestrictService roleRestrictService) {
		this.roleRestrictService = roleRestrictService;
	}

	@Autowired
	public void setProvinceService(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}

	@Autowired
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	@Autowired
	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}
	
}
