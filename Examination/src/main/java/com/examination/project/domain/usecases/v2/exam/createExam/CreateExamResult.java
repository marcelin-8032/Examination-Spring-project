package com.examination.project.domain.usecases.v2.exam.createExam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.usecases.v2.UseCase;

public record  CreateExamResult(Exam exam) implements UseCase.Result {

    @Override
    public Object data() {
        return null;
    }
}
