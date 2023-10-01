package com.examination.project.handler.controller.invigilator;



import com.examination.project.entities.Invigilator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/invigilator")
public interface InvigilatorHandler {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createAnInvigilator(@RequestBody Invigilator invigilator);
}
