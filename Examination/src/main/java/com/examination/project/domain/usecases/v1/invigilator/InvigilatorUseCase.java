package com.examination.project.domain.usecases.v1.invigilator;


import com.examination.project.domain.entities.Invigilator;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.collection.Foldable;
import io.vavr.control.Either;

import java.util.Collection;

public interface InvigilatorUseCase {

    Either<ExaminationException, Invigilator> createInvigilator(Invigilator invigilator);

    Either<ExaminationException, Collection<Invigilator>> findAllInvigilator();
}
