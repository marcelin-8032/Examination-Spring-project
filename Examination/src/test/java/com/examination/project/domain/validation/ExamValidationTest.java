package com.examination.project.domain.validation;

import com.examination.project.domain.entities.Exam;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExamValidationTest {


    @Test
    void should_return_error_for_non_valid_exam_date() {

        val exam = Exam.builder().examDate(LocalDateTime.parse("2024-07-29T14:49:41.289003400")).build();

        val examValidation = new ExamValidator();

        assertFalse(examValidation.isValid(exam, null));
    }

    @Test
    void should_return_true_for_valid_exam_date() {

        val exam = Exam.builder().examDate(LocalDateTime.parse("2024-07-29T14:49:41")).build();

        val examValidation = new ExamValidator();

        assertTrue(examValidation.isValid(exam, null));
    }
}
