package com.cegefos.tp1.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.entity.Salle;

public interface ExamenService {

	void createExamens(List<Examen> examens);
	
	Collection<Examen> getAllExamens();
	
	Collection<Examen> getExamensByDate(Date date);
	
//	Collection<Examen> getExamAtSalleAndGivenDate(Optional<Salle> salle, Date date);

	Collection<Examen> getExamAtSalleAndAfterADate(Salle salle, Date date);
	
	Collection<Examen> getExamensAtRecentDataAtSpecificSalle(Salle salle);
	
	Page<Examen> getAllExamensInPages(Pageable pageable);
	
	Page<Examen> getAllExamensBySalle(Integer id, Pageable pageable);
	
	
	
}
