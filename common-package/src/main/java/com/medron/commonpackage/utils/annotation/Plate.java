package com.medron.commonpackage.utils.annotation;

import com.medron.commonpackage.utils.annotation.validator.PlateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PlateValidator.class)
public @interface Plate {
    String message() default "Invalid plate";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
