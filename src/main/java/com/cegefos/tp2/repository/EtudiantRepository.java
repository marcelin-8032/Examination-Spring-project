package com.cegefos.tp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp2.entity.Etudiant;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
