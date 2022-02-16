package com.javaweb.annotation.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.javaweb.annotation.validate.impl.CarNoCheck;
import com.javaweb.annotation.validate.impl.IdCardCheck;
import com.javaweb.annotation.validate.impl.PhoneNoCheck;
import com.javaweb.annotation.validate.impl.UsccCodeCheck;
import com.javaweb.enums.CommonCheckEnum;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CommonlyUsedClass.class)
public @interface CommonlyUsed {

	CommonCheckEnum type();
	
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
				String checkValue = value.toString().trim();
				CommonCheckEnum commonCheckEnum = commonlyUsed.type();
				switch(commonCheckEnum){
					case ID_CARD:
						return IdCardCheck.check(checkValue);
					case USCC:
						return UsccCodeCheck.check(checkValue);
					case CAR_NO:
						return CarNoCheck.check(checkValue);
					case PHONE_NO:
						return PhoneNoCheck.check(checkValue);
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
