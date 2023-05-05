package com.medron.commonpackage.utils.annotation;

import com.medron.commonpackage.utils.annotation.validator.YearValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = YearValidator.class)
public @interface ValidYear {
    String message() default "Year value cannot be in the future";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
