package org.escalade.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;
import org.escalade.model.annotation.LoginConstraint;

public class LoginValidator implements ConstraintValidator<LoginConstraint, String>{
	private String message;
	private String messageRegex;
	
	@Override
	public void initialize(LoginConstraint constraint) {
		message = constraint.message();
		messageRegex = constraint.messageRegex();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		if (value.isEmpty()) {
			context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
		} else if (!EmailValidator.getInstance().isValid(value)) {
			context.buildConstraintViolationWithTemplate(messageRegex).addConstraintViolation();
            return false;
		} else {
			return true;
		}	
	}

}
