package com.examination.project.domain.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InvigilatorValidator.class)
@Target( {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InvigilatorValidation {

    String message() default "Invigilator is valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

