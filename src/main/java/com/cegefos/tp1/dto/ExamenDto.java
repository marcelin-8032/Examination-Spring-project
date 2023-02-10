package com.cegefos.tp1.dto;

import com.cegefos.tp1.entity.Etudiant;
import com.cegefos.tp1.entity.Matiere;
import com.cegefos.tp1.entity.Salle;
import com.cegefos.tp1.entity.Surveillant;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public record ExamenDto(Integer examenId,
                        Date dateExam,
                        Set<Etudiant> etudiants,
                        Matiere matiere,
                        Salle salle,
                        Surveillant surveillant) implements Serializable {

    public ExamenDto(Date dateExam, Matiere matiere, Salle salle, Surveillant surveillant) {
        this(null, dateExam, null, matiere, salle, surveillant);
    }
}
