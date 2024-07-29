package com.examination.project.domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.RECORD_COMPONENT})
@Constraint(validatedBy = ExamValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExamValidation {

    String message() default "Invalid Exam Date Format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
