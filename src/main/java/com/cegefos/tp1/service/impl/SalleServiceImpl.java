package com.cegefos.tp1.service.impl;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.entity.Salle;
import com.cegefos.tp1.repository.ExamenRepository;
import com.cegefos.tp1.repository.SalleRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.service.SalleService;

@Service
public class SalleServiceImpl implements SalleService {

	@Autowired
	private SalleRepository salleRepository;

	@Autowired
	private ExamenRepository examenRepository;

	@Override
	public void createSalle(Salle salle) {
		salleRepository.save(salle);
	}

	@Override
	public void deleteAllSalles() {

		List<Examen> examenList = examenRepository.findAll();

		for (Examen examen : examenList) {
			examen.setSalle(null);
			examenRepository.save(examen);
		}

		salleRepository.deleteAll();

	}

	@Override
	public void updateSalle(Integer id, int numero) throws Exception {
		Salle oldSalle=salleRepository.findById(id).orElseThrow(() -> new Exception("there is a problem in updating salle number"));
		oldSalle.setNumero(numero);
		salleRepository.save(oldSalle);
		
	}

	@Override
	public void createTwoSalles(List<Salle> salles) {
		salleRepository.saveAll(salles);
		
	}

}
