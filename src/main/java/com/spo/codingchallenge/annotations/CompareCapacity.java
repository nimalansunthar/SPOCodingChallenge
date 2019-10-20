package com.spo.codingchallenge.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spo.codingchallenge.validators.CompareCapacityValidator;

/**
 * Annotation to validate the Senior junior constraint can be generalised but in this case we use only once. So created for only capacity fields.
 * @author ex1
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { CompareCapacityValidator.class })
public @interface CompareCapacity {

	String message() default "{comparecapacity}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
