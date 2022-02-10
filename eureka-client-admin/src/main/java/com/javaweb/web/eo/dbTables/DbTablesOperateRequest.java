package com.javaweb.web.eo.dbTables;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DbTablesOperateRequest implements Serializable {

	private static final long serialVersionUID = -8543508343564718057L;

	private Integer operateType;//1：查询；2：插入；3：修改；4：删除
	
	private String sql;//操作语句
	
}
