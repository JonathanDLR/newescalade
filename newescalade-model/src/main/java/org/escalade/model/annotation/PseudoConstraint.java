package org.escalade.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.escalade.model.validators.PseudoValidator;

@Documented
@Constraint(validatedBy = PseudoValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PseudoConstraint {
	String message() default "Veuillez renseigner votre pseudo";
	String messageNotGood() default "Votre pseudo ne peut contenir que des caractères alphanumériques, des _ et des -";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
