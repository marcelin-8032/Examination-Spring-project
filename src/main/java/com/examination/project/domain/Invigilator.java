package com.examination.project.domain;

import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;


@Builder
@With
public record Invigilator(Integer invigilatorId,
                          String name,
                          Set<Exam> exams) implements Serializable {

}
