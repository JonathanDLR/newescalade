package org.escalade.model.validators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.escalade.model.annotation.DateConstraint;

public class MyDateValidator implements ConstraintValidator<DateConstraint, Date>{
	private String message;
	private String messageNull;
	private String dateFormat;
	
	public MyDateValidator() {
		this.dateFormat = "yyyy-MM-dd";
	}
	
	@Override
	public void initialize(DateConstraint constraint) {
		message = constraint.message();
		messageNull = constraint.messageNull();
	}
	
	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		if (value == null) {
			context.buildConstraintViolationWithTemplate(messageNull).addConstraintViolation();
			return false;
		} else {
			DateFormat sdf = new SimpleDateFormat(this.dateFormat);
	        sdf.setLenient(false);
	        try {
	            sdf.parse(sdf.format(value));
	        } catch (ParseException e) {
	        	context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
	            return false;
			} 
			
	        return true;
		}	
	}
}
