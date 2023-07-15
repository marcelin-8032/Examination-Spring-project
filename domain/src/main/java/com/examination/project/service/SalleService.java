package com.examination.project.service;

import java.util.List;

import com.examination.project.persistance.entities.RoomEntity;

public interface SalleService {

	void createSalle(RoomEntity roomEntity);
	
	void deleteAllSalles();
	
	void updateSalle(Integer id, int numero) throws Exception;
	
	void createTwoSalles(List<RoomEntity> salleEntities);
}
