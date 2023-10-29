package com.examination.project.infrastructure.handler.controller.v1.invigilator;

import com.examination.project.domain.entities.Invigilator;
import com.examination.project.domain.usecases.v1.invigilator.InvigilatorUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/invigilator")
public class InvigilatorRestHandler implements InvigilatorHandler {

    private final InvigilatorUseCase invigilatorUseCase;

    @Override
    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAnInvigilator(Invigilator invigilator) {
       // log.info("An invigilator {} has been added: ", invigilator);
        return invigilatorUseCase.createInvigilator(invigilator).fold(
                a -> ResponseEntity.badRequest().build(),
                invigilator1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

}
