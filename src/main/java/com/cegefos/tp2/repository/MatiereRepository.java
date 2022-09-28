package com.cegefos.tp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp2.entity.Matiere;

import java.util.Collection;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

    Collection<Matiere> findByCoefficientGreaterThan(int coefficient);

}
