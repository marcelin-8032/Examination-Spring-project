package com.examination.project.infrastructure.handler.controller.v2;


import com.examination.project.domain.entities.Exam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v2/" + "exam")
public class ExaminationController {


    @PostMapping("/add")
    public ResponseEntity<Void> createExams(@RequestBody List<Exam> exams) {

        return null;
    }

}
