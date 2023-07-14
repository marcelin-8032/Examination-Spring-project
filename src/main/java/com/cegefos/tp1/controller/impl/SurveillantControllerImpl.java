package com.cegefos.tp1.controller.impl;

import com.cegefos.tp1.controller.SurveillantController;
import com.cegefos.tp1.persistance.entities.InvigilatorEntity;
import com.cegefos.tp1.service.SurveillantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveillantControllerImpl implements SurveillantController {

    @Autowired
    private SurveillantService surveillantService;

    @Override
    public void createASurveillant(@RequestBody InvigilatorEntity invigilatorEntity) {
        surveillantService.createSurveillant(invigilatorEntity);
    }


}
