package com.examination.project.domain.usecases.v2.exam;

import com.examination.project.domain.usecases.v2.UseCase;
import com.examination.project.domain.usecases.v2.UseCaseAction;

public interface ExamUseCase<P extends UseCase.Port, R extends UseCase.Result> extends UseCase<P, R> {

    enum ExamUseCaseAction implements UseCaseAction<ExamUseCaseAction> {

        CREATE_EXAMS,

        GET_ALL_EXAMS,

        GET_EXAMS_BY_DATE,

        GET_EXAMS_AT_GIVEN_ROOM_DATE,

        GET_EXAMS_AT_ROOM_AFTER_DATE,

        GET_EXAMS_AT_RECENT_DATE_AND_SPECIFIC_ROOM,

        GET_ALL_PAGES_EXAMS,

        GET_ALL_EXAMS_BY_ROOM
    }

}
