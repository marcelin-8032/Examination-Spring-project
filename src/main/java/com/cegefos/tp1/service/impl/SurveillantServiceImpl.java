package com.cegefos.tp1.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.persistance.entities.InvigilatorEntity;
import com.cegefos.tp1.persistance.repository.InvigilatorRepository;
import com.cegefos.tp1.service.SurveillantService;

@Service
public class SurveillantServiceImpl implements SurveillantService {

	@Autowired
	private InvigilatorRepository invigilatorRepository;

	@Override
	public void createSurveillant(InvigilatorEntity invigilatorEntity) {
		invigilatorRepository.save(invigilatorEntity);

	}


}
