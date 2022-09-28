package com.cegefos.tp2.repository;

import com.cegefos.tp2.enums.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp2.entity.Etudiant;

import java.util.Collection;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    Collection<Etudiant> findEtudiantByClasse(Classe classe);
}
