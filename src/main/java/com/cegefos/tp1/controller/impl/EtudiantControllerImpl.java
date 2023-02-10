package com.cegefos.tp1.controller.impl;

import com.cegefos.tp1.controller.EtudiantController;
import com.cegefos.tp1.dto.EtudiantDto;
import com.cegefos.tp1.entity.Etudiant;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.mapper.EtudiantMapper;
import com.cegefos.tp1.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EtudiantControllerImpl implements EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private EtudiantMapper etudiantMapper;


    @Override
    public void createEtudiant(@RequestBody EtudiantDto etudiantDto) {
        Etudiant etudiant = etudiantMapper.toEtudiant(etudiantDto);
        etudiantService.createEtudiant(etudiant);
    }

    @Override
    public Collection<Etudiant> getEtudiantByClass(@PathVariable("classe") Classe classe) {
        return etudiantService.findEtudiantByClasse(classe);
    }


    @Override
    public Collection<Etudiant> getAllEtudiants() {
        return etudiantService.findEtudiants();

    }


}
