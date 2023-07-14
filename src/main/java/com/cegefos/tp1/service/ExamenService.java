package com.cegefos.tp1.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import com.cegefos.tp1.persistance.entities.RoomEntity;

public interface ExamenService {

	void createExamens(List<ExamEntity> examenEntities);
	
	Collection<ExamEntity> getAllExamens();
	
	Collection<ExamEntity> getExamensByDate(Date date);
	
//	Collection<Examen> getExamAtSalleAndGivenDate(Optional<Salle> salle, Date date);

	Collection<ExamEntity> getExamAtSalleAndAfterADate(RoomEntity roomEntity, Date date);
	
	Collection<ExamEntity> getExamensAtRecentDataAtSpecificSalle(RoomEntity roomEntity);
	
	Page<ExamEntity> getAllExamensInPages(Pageable pageable);
	
	Page<ExamEntity> getAllExamensBySalle(Integer id, Pageable pageable);
	
	
	
}
