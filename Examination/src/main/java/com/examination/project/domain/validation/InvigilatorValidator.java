package com.examination.project.domain.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class InvigilatorValidator implements ConstraintValidator<InvigilatorValidation, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        if (name.length() > 1000) {
            return false;
        }
        return true;
    }
}
