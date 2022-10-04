package com.cegefos.tp2.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cegefos.tp2.entity.Matiere;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

    Collection<Matiere> findByCoefficientGreaterThan(int coefficient);

    /********************************  -------------------------Query methods------------------***************/

    @Query(value = "SELECT * FROM matiere m WHERE m.coefficient > :coefficient", nativeQuery = true)
    Collection<Matiere> findByCoefficient(@Param("coefficient") int coefficient);


}
