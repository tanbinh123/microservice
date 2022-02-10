package com.javaweb.web.eo.user;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModuleAssignmentRequest implements Serializable {

	private static final long serialVersionUID = -4251237499359962084L;

	private List<String> list;
	
	private String userId;
	
}
