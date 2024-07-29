package com.examination.project.domain.validation;

import com.examination.project.domain.entities.Exam;
import lombok.val;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExamValidator implements ConstraintValidator<ExamValidation, Exam> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public boolean isValid(Exam exam, ConstraintValidatorContext context) {

        val formattedDate = exam.examDate().format(FORMATTER);
        val parsedDate = LocalDateTime.parse(formattedDate, FORMATTER);
        return parsedDate.equals(exam.examDate());
    }
}

