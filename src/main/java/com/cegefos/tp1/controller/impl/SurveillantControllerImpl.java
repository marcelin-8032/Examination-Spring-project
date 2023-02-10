package com.cegefos.tp1.controller.impl;

import com.cegefos.tp1.controller.SurveillantController;
import com.cegefos.tp1.entity.Surveillant;
import com.cegefos.tp1.service.SurveillantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveillantControllerImpl implements SurveillantController {

    @Autowired
    private SurveillantService surveillantService;

    @Override
    public void createASurveillant(@RequestBody Surveillant surveillant) {
        surveillantService.createSurveillant(surveillant);
    }


}
