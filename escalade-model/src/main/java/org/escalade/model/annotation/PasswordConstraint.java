package org.escalade.model.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ReportAsSingleViolation;

import org.escalade.model.validators.PasswordValidator;

@Target(ElementType.FIELD)
@Constraint(validatedBy = PasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface PasswordConstraint {
	String message() default "Veuillez renseignez votre mot de passe.";
	
	String messageRegex() default "Votre mot de passe doit contenir au minimum une lettre minuscule, une lettre majuscule, un chiffre et 6 caractères.";
	
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
