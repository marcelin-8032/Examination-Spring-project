package com.cegefos.tp1.repository;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.enums.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cegefos.tp1.entity.Etudiant;

import java.util.Collection;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    Collection<Etudiant> findEtudiantByClasse(Classe classe);

    /*****************************-------------------------Query methods------------------***************/

    @Query(value = "SELECT * FROM etudiants e WHERE e.classe=:classe", nativeQuery = true)
    Collection<Examen> findStudentsAsClasse(@Param("classe") Classe classe);


}
