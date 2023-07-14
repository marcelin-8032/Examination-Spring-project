package com.cegefos.tp1.domains;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;
import java.util.Set;

@Builder
@With
public record Invigilator(Integer surveillantId,
                          String nom,
                          Set<ExamEntity> examenEntities) implements Serializable {

    public Invigilator(String nom) {
        this(null, nom, null);
    }



}
