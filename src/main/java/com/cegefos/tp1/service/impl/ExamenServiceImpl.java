package com.cegefos.tp1.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import com.cegefos.tp1.persistance.entities.RoomEntity;
import com.cegefos.tp1.persistance.repository.ExamRepository;
import com.cegefos.tp1.persistance.repository.RoomRepository;
import com.cegefos.tp1.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public void createExamens(List<ExamEntity> examenEntities) {
		examRepository.saveAll(examenEntities);
	}

	@Override
	public Collection<ExamEntity> getAllExamens() {
		return examRepository.findAll();
	}

	@Override
	public Collection<ExamEntity> getExamensByDate(Date date) {
		return examRepository.findExamenByDateExam(date);
	}

	@Override
	public Collection<ExamEntity> getExamAtSalleAndAfterADate(RoomEntity roomEntity, Date date) {
		Integer id = 0;
		roomEntity = roomRepository.findById(id).get();
		return examRepository.findBySalleAndDateExamGreaterThan(roomEntity, date);
	}

	@Override
	public Collection<ExamEntity> getExamensAtRecentDataAtSpecificSalle(RoomEntity roomEntity) {
		return examRepository.findTopBySalleOrderByDateExamDesc(roomEntity);
	}

	@Override
	public Page<ExamEntity> getAllExamensInPages(Pageable pageable) {
		pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "examen_id");
		return examRepository.findAllExamens(pageable);
	}

	@Override
	public Page<ExamEntity> getAllExamensBySalle(Integer id, Pageable pageable) {
		pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "date_exam");
		return examRepository.findBysurveillant(id, pageable);
	}
	
	
	
	
	

}
