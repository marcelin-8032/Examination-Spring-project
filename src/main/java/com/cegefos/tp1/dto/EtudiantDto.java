package com.cegefos.tp1.dto;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.enums.Classe;

import java.io.Serializable;
import java.util.Set;

public record EtudiantDto(Integer etudiantId, String nom, Classe classe, Set<Examen> examens) implements Serializable {

    public EtudiantDto(Integer etudiantId, String nom, Classe classe, Set<Examen> examens) {
        this.etudiantId = etudiantId;
        this.nom = nom;
        this.classe = classe;
        this.examens = examens;
    }
}
