package com.examination.project.domain;

import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;


@Builder
@With
public record Room(Integer salleId,
                   int number,
                   Set<Exam> exams) implements Serializable {

}
