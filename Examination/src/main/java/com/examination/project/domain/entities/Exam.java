package com.examination.project.domain.entities;

import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
@With
public record Exam(
        Integer examId,

        String name,

        LocalDateTime dateExam,

        Set<Student> students,

        Subject subject,

        Room room,

        Invigilator invigilator
) {

}
