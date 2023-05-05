package com.medron.commonpackage.utils.annotation.validator;

import com.medron.commonpackage.utils.annotation.ValidYear;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;


public class YearValidator implements ConstraintValidator<ValidYear,Integer> {
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return Year.now().getValue()>integer;
    }
}
