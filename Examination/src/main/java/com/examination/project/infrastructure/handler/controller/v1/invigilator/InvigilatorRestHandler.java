package com.examination.project.infrastructure.handler.controller.v1.invigilator;

import com.examination.project.domain.entities.Invigilator;
import com.examination.project.domain.usecases.v1.invigilator.InvigilatorUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/" + "invigilators")
public class InvigilatorRestHandler implements InvigilatorHandler {

    private final InvigilatorUseCase invigilatorUseCase;

    @Override
    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAnInvigilator(Invigilator invigilator) {

        return invigilatorUseCase.createInvigilator(invigilator).fold(
                a -> ResponseEntity.badRequest().build(),
                invigilator1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Invigilator>> getAllInvigilators() {
        return invigilatorUseCase.findAllInvigilator().fold(
                a -> ResponseEntity.badRequest().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvigilatorById(@PathVariable Integer id) {
        return invigilatorUseCase.deleteInvigilatorById(id).fold(
                e -> ResponseEntity.status(HttpStatus.CONFLICT).build(),
                a -> ResponseEntity.noContent().build()
        );
    }

    @Override
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllInvigilators() {
        return invigilatorUseCase.deleteAllInvigilators().fold(
                e -> ResponseEntity.status(HttpStatus.CONFLICT).build(),
                a -> ResponseEntity.noContent().build()
        );
    }
}
