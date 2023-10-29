package com.examination.project.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;


@Builder
@With
public record Student(

        Integer studentId,

        String name,

        Classe classe,

        Set<Exam> exams) {

}
