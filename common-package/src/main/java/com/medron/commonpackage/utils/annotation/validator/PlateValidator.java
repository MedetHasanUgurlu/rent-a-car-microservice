package com.medron.commonpackage.utils.annotation.validator;

import com.medron.commonpackage.utils.annotation.Plate;
import com.medron.commonpackage.utils.constant.Regex;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlateValidator implements ConstraintValidator<Plate,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return s.matches(Regex.plate);
    }
}
