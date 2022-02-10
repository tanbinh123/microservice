package com.javaweb.web.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseDao;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.constant.CommonConstant;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.operationLog.OperationLogListRequest;
import com.javaweb.web.eo.operationLog.OperationLogListResponse;
import com.javaweb.web.po.Interfaces;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.OperationLog;
import com.javaweb.web.service.OperationLogService;

@Service("operationLogServiceImpl")
public class OperationLogServiceImpl extends BaseDao implements OperationLogService {

	@Transactional
	@Override
	public void saveOperationLog(OperationLog operationLog) {
		operationLogDao.insert(operationLog);
	}

	@Override
	public Page operationLogList(OperationLogListRequest operationLogListRequest) {
		List<Module> moduleList = moduleDao.selectAll();
		List<Interfaces> interfacesList = BaseSystemMemory.interfacesList;
		List<OperationLogListResponse> list = operationLogDao.operationLogList(operationLogListRequest);
		Long count = operationLogDao.operationLogListCount(operationLogListRequest);
		if(count!=null&&count>0){
			for(int i=0;i<list.size();i++){//第一层for循环不能break，必须完全执行每一步
				List<String> moduleNameList = new ArrayList<>();
				OperationLogListResponse eachOperationLogListResponse = list.get(i);
				loop:for(int j=0;j<moduleList.size();j++){
					if(moduleList.get(j).getApiUrl()!=null){
						String apiUrlSplit[] = moduleList.get(j).getApiUrl().split(CommonConstant.COMMA);
						for(String eachApiUrl:apiUrlSplit){
							if(eachOperationLogListResponse.getUrl().contains(eachApiUrl)){
								getModuleNameList(moduleList.get(j).getModuleId(),moduleList,moduleNameList);
								break loop;
							}
						}
					}
				}
				Collections.reverse(moduleNameList);
				if(moduleNameList.size()==0){//模块表没查到，表示请求的接口不受权限控制，所以要查sys_interfaces表
					for(int m=0;m<interfacesList.size();m++){
						if(eachOperationLogListResponse.getBaseUrl().equals(interfacesList.get(m).getUrl())){
							eachOperationLogListResponse.setOperateName(interfacesList.get(m).getName());
							break;
						}
					}
				}else{
					eachOperationLogListResponse.setOperateName(String.join(CommonConstant.BAR,moduleNameList));
				}
			}
		}
		Page page = new Page(operationLogListRequest,list,count);
		return page;
	}
	
	//向上递归获取模块名称
	private void getModuleNameList(String originModulePid,List<Module> moduleList,List<String> moduleNameList){
		for(int i=0;i<moduleList.size();i++){
			Module eachModule = moduleList.get(i);
			if((originModulePid!=null)&&(!CommonConstant.EMPTY_VALUE.equals(originModulePid))&&(eachModule.getModuleId().equals(originModulePid))){
				moduleNameList.add(eachModule.getModuleName());
				getModuleNameList(eachModule.getParentId(),moduleList,moduleNameList);
				break;
			}
		}
	}

}
