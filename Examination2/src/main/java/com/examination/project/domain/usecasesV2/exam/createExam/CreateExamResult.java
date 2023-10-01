package com.examination.project.domain.usecasesV2.exam.createExam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.usecasesV2.UseCase.*;

public record  CreateExamResult(Exam exam) implements Result {

    @Override
    public Object data() {
        return null;
    }
}
