package com.examination.project.handler.controller.invigilator;

import com.examination.project.entities.Invigilator;
import com.examination.project.usecases.invigilator.InvigilatorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvigilatorRestHandler implements InvigilatorHandler {

    @Autowired
    private InvigilatorUseCase invigilatorUseCase;

    @Override
    public void createASurveillant(@RequestBody Invigilator invigilator) {
        invigilatorUseCase.createInvigilator(invigilator);
    }


}
