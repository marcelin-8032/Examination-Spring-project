package com.cegefos.tp1.domains;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import com.cegefos.tp1.enums.Classe;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;
import java.util.Set;

@Builder
@With
public record Student(Integer etudiantId, String nom, Classe classe, Set<ExamEntity> examenEntities) implements Serializable {

    public Student(String nom, Classe classe) {
        this(null, nom, classe, null);
    }
}
