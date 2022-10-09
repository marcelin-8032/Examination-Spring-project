package com.cegefos.tp1.service;

import com.cegefos.tp1.entity.Matiere;

public interface MatiereService {

	void createMatiere(Matiere matiere);
	
	void updateMatiere(Integer id, int coefficient) throws Exception;
}
