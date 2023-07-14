package com.cegefos.tp1.domains;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;
import java.util.Set;

@Builder
@With
public record Room(Integer salleId,
                   int numero,
                   Set<ExamEntity> examenEntities) implements Serializable {

    public Room(int numero) {
        this(null, numero, null);
    }
}
