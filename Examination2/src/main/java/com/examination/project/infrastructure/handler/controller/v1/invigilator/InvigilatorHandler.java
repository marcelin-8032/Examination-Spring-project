package com.examination.project.infrastructure.handler.controller.v1.invigilator;


import com.examination.project.domain.entities.Invigilator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;




public interface InvigilatorHandler {

    ResponseEntity<Void> createAnInvigilator(@RequestBody Invigilator invigilator);
}
