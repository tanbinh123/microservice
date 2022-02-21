package com.javaweb.annotation.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=StringValueClass.class)
public @interface StringValueRange {

	String[] vauleArray() default {};//特定数值列表
	
	boolean allowEmpty() default false;//是否允许空（允许空时为空值将不做校验，只有不为空时才做校验）
	
	/* ↓↓↓↓↓↓↓↓↓↓严格模式下必须有↓↓↓↓↓↓↓↓↓↓ */
	String message() default "validated.check.fail";//全局通用参数校验失败信息
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	/* ↑↑↑↑↑↑↑↑↑↑严格模式下必须有↑↑↑↑↑↑↑↑↑↑ */
	
}

class StringValueClass implements ConstraintValidator<StringValueRange,Object> {
    
	protected StringValueRange valueRange;
	
	@Override
	public void initialize(StringValueRange valueRange) {
		this.valueRange = valueRange;
	}

	@Override
	public boolean isValid(Object value,ConstraintValidatorContext context) {
		try{
			boolean allowEmpty = valueRange.allowEmpty();
			if(allowEmpty){
				if(value==null){
					return true;
				}
			}
			if(value!=null) {
				String checkValue = String.valueOf(value);
				String[] valueArray = this.valueRange.vauleArray();
				if(valueArray.length==0){
					return true;
				}
				for(int i=0;i<valueArray.length;i++){
					if(checkValue==valueArray[i]){
						return true;
					}
				}
			}
		}catch(Exception e){
			//do nothing
		}
		return false;
	}
	
}
