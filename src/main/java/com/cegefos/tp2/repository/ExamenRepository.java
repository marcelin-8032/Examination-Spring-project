package com.cegefos.tp2.repository;

import com.cegefos.tp2.entity.Salle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp2.entity.Examen;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface ExamenRepository extends CrudRepository<Examen, Integer> {

    List<Examen> findAll();

    Collection<Examen> findExamenByDateExam(Date dateExam);

    Collection<Examen> findBySalleAndDateExamGreaterThan(Salle salle, Date dateExam);

    Collection<Examen> findTopBySalleOrderByDateExamDesc(Salle salle);


}
