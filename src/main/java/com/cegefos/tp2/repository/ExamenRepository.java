package com.cegefos.tp2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp2.entity.Examen;

import java.util.List;

@Repository
public interface ExamenRepository extends CrudRepository<Examen, Integer> {


    List<Examen> findAll();
}
