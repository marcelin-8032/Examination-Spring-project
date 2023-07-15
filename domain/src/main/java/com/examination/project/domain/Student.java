package com.examination.project.domain;

import com.examination.project.enums.Classe;
import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;


@Builder
@With
public record Student(Integer studentId,
                      String name,
                      Classe classe,
                      Set<Exam> exams) implements Serializable {

}
