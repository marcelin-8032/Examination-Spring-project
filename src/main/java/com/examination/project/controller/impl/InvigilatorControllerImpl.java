package com.examination.project.controller.impl;

import com.examination.project.controller.InvigilatorController;
import com.examination.project.persistance.entities.InvigilatorEntity;
import com.examination.project.service.SurveillantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvigilatorControllerImpl implements InvigilatorController {

    @Autowired
    private SurveillantService surveillantService;

    @Override
    public void createASurveillant(@RequestBody InvigilatorEntity invigilatorEntity) {
        surveillantService.createSurveillant(invigilatorEntity);
    }


}
