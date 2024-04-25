package com.examination.project.infrastructure.handler.controller.v2;


import com.examination.project.domain.entities.Exam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/v2/exams")
public class ExaminationController {

    @PostMapping("/add")
    public ResponseEntity<Void> createExams(@RequestBody List<Exam> exams) {

        return null;
    }

    @GetMapping
    public ResponseEntity<Collection<Exam>> getAllExams() {
        return null;
    }

}
