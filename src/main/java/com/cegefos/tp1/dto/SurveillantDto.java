package com.cegefos.tp1.dto;

import com.cegefos.tp1.entity.Examen;

import java.io.Serializable;
import java.util.Set;

public record SurveillantDto(Integer surveillantId,
                             String nom,
                             Set<Examen> examens) implements Serializable {

    public SurveillantDto(String nom) {
        this(null, nom, null);
    }



}
