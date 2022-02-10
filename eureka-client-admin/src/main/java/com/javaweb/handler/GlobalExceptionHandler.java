package com.javaweb.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.javaweb.base.BaseResponseResult;
import com.javaweb.base.BaseInject;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.exception.ServiceException;
import com.javaweb.exception.TokenExpiredException;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseInject {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public BaseResponseResult handleException(HttpServletRequest request,NoHandlerFoundException e) {
		return getBaseResponseResult(HttpCodeEnum.NOT_FOUND,"validated.permission.notFound");
	}
	
	@ExceptionHandler(TokenExpiredException.class)
	public BaseResponseResult handleException(HttpServletRequest request,TokenExpiredException e) {
		return getBaseResponseResult(HttpCodeEnum.INVALID_REQUEST,"validated.permission.invalidRequest");
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public BaseResponseResult handleHttpRequestMethodNotSupportedException(HttpServletRequest request,HttpRequestMethodNotSupportedException e) {
		return getBaseResponseResult(HttpCodeEnum.INVALID_REQUEST,"validated.permission.invalidRequest");
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public BaseResponseResult handleMissingServletRequestParameterException(HttpServletRequest request,MissingServletRequestParameterException e){
		return getBaseResponseResult(HttpCodeEnum.INVALID_REQUEST,"validated.permission.invalidRequest");
	}
	
	@ExceptionHandler(MultipartException.class)
	public BaseResponseResult uploadExcepttion(MultipartException e){
	    return new BaseResponseResult(HttpCodeEnum.INVALID_REQUEST,e.getMessage());
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public BaseResponseResult handleDataIntegrityViolationException(DataIntegrityViolationException e){
		return new BaseResponseResult(HttpCodeEnum.INVALID_REQUEST,e.getMessage());
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public BaseResponseResult handleNumberFormatExceptionException(NumberFormatException e){
		return new BaseResponseResult(HttpCodeEnum.INVALID_REQUEST,e.getMessage());
	}
	
	@ExceptionHandler(ServiceException.class)
	public BaseResponseResult handleServiceException(HttpServletRequest request,ServiceException e){
		return new BaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,e.getMessage());
	}
	
	/**
	 * <p>校验异常在这里有2种方式，这里采用了第2种方法
	 * <p>1、handleMethodArgumentNotValidException方法直接return new BaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	 * 然后controller的方法参数写为：@RequestBody @Validated({BaseValidatedGroup.add.class}) User user,BindingResult bindingResult
	 * 最后加上：if(bindingResult.hasErrors()){return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,bindingResult);}
	 * <p>2、handleMethodArgumentNotValidException方法添加if(e.getBindingResult().hasErrors()){return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,e.getBindingResult());}
	 * 然后controller的方法参数写为：@RequestBody @Validated({BaseValidatedGroup.add.class}) User user
	 * 即去除BindingResult bindingResult和if(bindingResult.hasErrors()){return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,bindingResult);}
	 * 最后加上：spring.mvc.logResolvedException=false
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public BaseResponseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		if(e.getBindingResult().hasErrors()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,e.getBindingResult());
		}
		return new BaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public BaseResponseResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
		return getBaseResponseResult(HttpCodeEnum.REQUEST_PARAMETER_ERROR,"validated.permission.requestParameterError");
	}
	
	@ExceptionHandler(Exception.class)
	public BaseResponseResult handleException(HttpServletRequest request,Exception e) {
		//e.printStackTrace();
		logger.error(e.getMessage());
		return getBaseResponseResult(HttpCodeEnum.INTERNAL_ERROR,"validated.permission.internalError");
	}
	
}
