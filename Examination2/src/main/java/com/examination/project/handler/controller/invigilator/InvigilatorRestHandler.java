package com.examination.project.handler.controller.invigilator;

import com.examination.project.entities.Invigilator;
import com.examination.project.usecases.invigilator.InvigilatorUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class InvigilatorRestHandler implements InvigilatorHandler {

    @Autowired
    private InvigilatorUseCase invigilatorUseCase;

    @Override
    public ResponseEntity<Void> createAnInvigilator(Invigilator invigilator) {
        log.info("An invigilator {} has been added: ", invigilator);
                return invigilatorUseCase.createInvigilator(invigilator).fold(
                a-> ResponseEntity.badRequest().build(),
                invigilator1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

}
