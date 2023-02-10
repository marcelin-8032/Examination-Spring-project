package com.cegefos.tp1.dto;

import com.cegefos.tp1.entity.Examen;

import java.io.Serializable;
import java.util.Set;

public record MatiereDto(
        Integer matiereId,
        String intitule,
        int coefficient,
        Module module,
        Set<Examen> examens
) implements Serializable {
}
