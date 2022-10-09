package com.cegefos.tp1.service;

import java.util.List;

import com.cegefos.tp1.entity.Salle;

public interface SalleService {

	void createSalle(Salle salle);
	
	void deleteAllSalles();
	
	void updateSalle(Integer id, int numero) throws Exception;
	
	void createTwoSalles(List<Salle> salles);
}
