package com.examination.project.usecases.invigilator;


import com.examination.project.entities.Invigilator;
import com.examination.project.exception.ExaminationException;
import io.vavr.control.Either;

public interface InvigilatorUseCase {
	
	Either<ExaminationException,Invigilator> createInvigilator(Invigilator invigilator);
}
