package com.medron.commonpackage.utils.annotation.validator;

import com.medron.commonpackage.utils.annotation.Card;
import com.medron.commonpackage.utils.constant.Regex;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CardValidator implements ConstraintValidator<Card,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches(Regex.card);
    }
}
