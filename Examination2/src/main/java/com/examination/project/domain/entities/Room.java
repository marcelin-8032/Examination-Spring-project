package com.examination.project.domain.entities;

import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;


@Builder
@With
public record Room(Integer roomId,
                   int number,
                   Set<Exam> exams) implements Serializable {

}
