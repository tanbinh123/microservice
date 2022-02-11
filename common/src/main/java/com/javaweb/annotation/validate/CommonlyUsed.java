package com.javaweb.annotation.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.javaweb.enums.CommonCheckEnum;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CommonlyUsedClass.class)
public @interface CommonlyUsed {

	CommonCheckEnum commonCheckEnum();
	
	boolean allowEmpty() default false;//是否允许空（允许空时将不做校验，不允许空时将做校验）
	
	/* ↓↓↓↓↓↓↓↓↓↓严格模式下必须有↓↓↓↓↓↓↓↓↓↓ */
	String message() default "validated.check.fail";//全局通用参数校验失败信息
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	/* ↑↑↑↑↑↑↑↑↑↑严格模式下必须有↑↑↑↑↑↑↑↑↑↑ */
	
}

class CommonlyUsedClass implements ConstraintValidator<CommonlyUsed,Object> {
    
	protected CommonlyUsed commonlyUsed;
	
	public void initialize(CommonlyUsed commonlyUsed) {
		this.commonlyUsed = commonlyUsed;
	}

	public boolean isValid(Object value,ConstraintValidatorContext context) {
		try{
			boolean allowEmpty = commonlyUsed.allowEmpty();
			if(allowEmpty){
				return true;
			}
			if(value!=null) {
				String checkValue = value.toString();
				System.out.println(checkValue);//TODO
				CommonCheckEnum commonCheckEnum = commonlyUsed.commonCheckEnum();
				switch(commonCheckEnum){
					case ID_CARD:
						//TODO
						return true;
					case E_MAIL:
						//TODO
						return true;
					case CAR_NO:
						//TODO
						return true;
					case PHONE_NO:
						//TODO
						return true;
					default:
						return false;
					
				}
			}
		}catch(Exception e){
			//do nothing
		}
		return false;
	}
	
}
