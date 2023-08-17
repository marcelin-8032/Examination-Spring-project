package com.examination.project.usecases.invigilator;


import com.examination.project.entities.Invigilator;
import com.examination.project.exception.ExaminationException;
import com.examination.project.exception.ExaminationExceptionSanitize;
import com.examination.project.handler.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.mapper.InvigilatorMapper;
import com.examination.project.handler.persistance.invigilator.repository.InvigilatorRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InvigilatorUseCaseImpl implements InvigilatorUseCase {

    private InvigilatorRepository invigilatorRepository;

    @Autowired
    private InvigilatorMapper invigilatorMapper;

    @Override
    public Either<ExaminationException, Invigilator> createInvigilator(Invigilator invigilator) {
        return Try.of(() -> this.invigilatorMapper.toInvigilatorEntity(invigilator))
                .map(this.invigilatorRepository::save)
                .map(this.invigilatorMapper::toInvigilator)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

}
