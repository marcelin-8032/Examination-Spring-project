package com.examination.project.usecases.exam;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ExamUseCase {

	void createExams(List<Exam> examenEntities);
	
	Collection<Exam> getAllExams();
	
	Collection<Exam> getExamsByDate(Date date);
	
//	Collection<Examen> getExamAtSalleAndGivenDate(Optional<Salle> salle, Date date);

	Collection<Exam> getExamAtRoomAndAfterADate(Room roomEntity, Date date);
	
	Collection<Exam> getExamensAtRecentDataAtSpecificSalle(Room roomEntity);
	
	Page<Exam> getAllExamensInPages(Pageable pageable);
	
	Page<Exam> getAllExamensBySalle(Integer id, Pageable pageable);
	
	
	
}
