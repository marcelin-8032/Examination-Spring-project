package com.examination.project.infrastructure.usecaseImpl.v1.invigilator;


import com.examination.project.domain.entities.Invigilator;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.infrastructure.mapper.struct.InvigilatorMapper;
import com.examination.project.domain.usecases.v1.invigilator.InvigilatorUseCase;
import com.examination.project.infrastructure.persistance.invigilator.repository.InvigilatorRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class InvigilatorUseCaseImpl implements InvigilatorUseCase {

    private final InvigilatorRepository invigilatorRepository;

    private final InvigilatorMapper invigilatorMapper;

    @Override
    public Either<ExaminationException, Invigilator> createInvigilator(Invigilator invigilator) {
        return Try.of(() -> this.invigilatorMapper.toInvigilatorEntity(invigilator))
                .map(this.invigilatorRepository::save)
                .map(this.invigilatorMapper::toInvigilator)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Invigilator>> findAllInvigilator() {
        return Try.of(this.invigilatorRepository::findAll)
                .map(this.invigilatorMapper::toInvigilators)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

}
