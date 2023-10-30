package com.examination.project.domain.usecases.v1.invigilator;


import com.examination.project.domain.entities.Invigilator;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;

public interface InvigilatorUseCase {

	Either<ExaminationException,Invigilator> createInvigilator(Invigilator invigilator);
}
