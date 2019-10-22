package org.escalade.model.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ReportAsSingleViolation;

import org.escalade.model.validators.MyDateValidator;

@Target(ElementType.FIELD)
@Constraint(validatedBy = MyDateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface DateConstraint {
	String message() default "Veuillez renseigner une date valide.";
	String messageNull() default "Veuillez renseigner une date.";
	
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
