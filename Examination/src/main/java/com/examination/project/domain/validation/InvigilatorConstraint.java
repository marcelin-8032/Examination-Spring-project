package com.examination.project.domain.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InvigilatorValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface InvigilatorConstraint {

    String message() default "Invigilator is valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

