package com.javaweb.web.service;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.operationLog.OperationLogListRequest;
import com.javaweb.web.po.OperationLog;

public interface OperationLogService {
	
	void saveOperationLog(OperationLog operationLog);
	
	Page operationLogList(OperationLogListRequest operationLogListRequest);

}
