package com.cegefos.tp1.service;

import java.util.List;

import com.cegefos.tp1.persistance.entities.RoomEntity;

public interface SalleService {

	void createSalle(RoomEntity roomEntity);
	
	void deleteAllSalles();
	
	void updateSalle(Integer id, int numero) throws Exception;
	
	void createTwoSalles(List<RoomEntity> salleEntities);
}
