package org.escalade.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.escalade.model.annotation.PasswordConstraint;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
	private String message;
	private String messageRegex;
	
	@Override
	public void initialize(PasswordConstraint constraint) {
		message = constraint.message();
		messageRegex = constraint.messageRegex();
	}

	/*
	 * Test if password is not empty and respect regex
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		if (value.isEmpty()) {
			context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
		} else if (!value.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,}$")) {
			context.buildConstraintViolationWithTemplate(messageRegex).addConstraintViolation();
            return false;
		} else {
			return true;
		}	
	}

}
