package com.cegefos.tp1.service.impl;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import com.cegefos.tp1.persistance.entities.RoomEntity;
import com.cegefos.tp1.persistance.repository.ExamRepository;
import com.cegefos.tp1.persistance.repository.RoomRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.service.SalleService;

@Service
public class SalleServiceImpl implements SalleService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ExamRepository examRepository;

	@Override
	public void createSalle(RoomEntity roomEntity) {
		roomRepository.save(roomEntity);
	}

	@Override
	public void deleteAllSalles() {

		List<ExamEntity> examEntityList = examRepository.findAll();

		for (ExamEntity examEntity : examEntityList) {
			examEntity.setRoomEntity(null);
			examRepository.save(examEntity);
		}

		roomRepository.deleteAll();

	}

	@Override
	public void updateSalle(Integer id, int numero) throws Exception {
		RoomEntity oldRoomEntity = roomRepository.findById(id).orElseThrow(() -> new Exception("there is a problem in updating salle number"));
		oldRoomEntity.setNumero(numero);
		roomRepository.save(oldRoomEntity);
		
	}

	@Override
	public void createTwoSalles(List<RoomEntity> salleEntities) {
		roomRepository.saveAll(salleEntities);
		
	}

}
