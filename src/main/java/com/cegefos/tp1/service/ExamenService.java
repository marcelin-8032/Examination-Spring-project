package com.cegefos.tp1.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.cegefos.tp1.entity.Examen;

public interface ExamenService {

	void createExamens(List<Examen> examens);
	
	Collection<Examen> getAllExamens();
	
	Collection<Examen> getExamensByDate(Date date);
}
