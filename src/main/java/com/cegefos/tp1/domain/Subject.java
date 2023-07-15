package com.cegefos.tp1.domain;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;
import java.util.Set;

@Builder
@With
public record Subject(
        Integer matiereId,
        String intitule,
        int coefficient,
        Module module,
        Set<ExamEntity> examenEntities
) implements Serializable {
}
