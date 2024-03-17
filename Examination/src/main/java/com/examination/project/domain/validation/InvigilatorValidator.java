package com.examination.project.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InvigilatorValidator implements ConstraintValidator<InvigilatorValidation, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        if (name.length() > 1000) {
            return false;
        }
        return true;
    }
}
