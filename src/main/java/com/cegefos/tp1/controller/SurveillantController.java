package com.cegefos.tp1.controller;


import com.cegefos.tp1.entity.Surveillant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/surveillant")
public interface SurveillantController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createASurveillant(@RequestBody Surveillant surveillant);
}
