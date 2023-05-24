package com.medron.commonpackage.utils.annotation.validator;

import com.medron.commonpackage.utils.annotation.ExpressionYear;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class ExpressionYearValidator implements ConstraintValidator<ExpressionYear,Integer> {

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {
        return Year.now().getValue()<i;
    }
}
