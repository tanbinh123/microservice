package com.javaweb.exception;

import com.javaweb.base.BaseException;

public class ServiceException extends BaseException {

	private static final long serialVersionUID = 3963482452340751481L;
	
	public ServiceException(){
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

}
