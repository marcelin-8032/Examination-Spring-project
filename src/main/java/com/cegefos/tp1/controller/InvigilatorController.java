package com.cegefos.tp1.controller;


import com.cegefos.tp1.persistance.entities.InvigilatorEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/surveillant")
public interface InvigilatorController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createASurveillant(@RequestBody InvigilatorEntity invigilatorEntity);
}
