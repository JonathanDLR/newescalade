package org.escalade.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.escalade.model.annotation.PseudoConstraint;

public class PseudoValidator implements ConstraintValidator<PseudoConstraint, String>{
	private String message;
	private String messageNotGood;
	
	@Override
	public void initialize(PseudoConstraint pseudoConstraint) {
		this.message = pseudoConstraint.message();
		this.messageNotGood = pseudoConstraint.messageNotGood();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		if (value == "") {
			context.buildConstraintViolationWithTemplate(message);
			return false;
		} else if (!value.matches("^[A-zÀ-ÖØ-öø-ÿ0-9_\\-]+$")) {
			context.buildConstraintViolationWithTemplate(messageNotGood);
			return false;
		}
		return true;
	}
	
}
