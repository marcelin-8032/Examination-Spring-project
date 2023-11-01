package com.examination.project.infrastructure.handler.controller.v1.invigilator;


import com.examination.project.domain.entities.Invigilator;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;



@Tag(name = " Invigilators API", description = "Invigilator management")
public interface InvigilatorHandler {

    ResponseEntity<Void> createAnInvigilator(@RequestBody Invigilator invigilator);
}
