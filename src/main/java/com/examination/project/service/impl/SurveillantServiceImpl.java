package com.examination.project.service.impl;


import com.examination.project.persistance.entities.InvigilatorEntity;
import com.examination.project.persistance.repository.InvigilatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examination.project.service.SurveillantService;

@Service
public class SurveillantServiceImpl implements SurveillantService {

	@Autowired
	private InvigilatorRepository invigilatorRepository;

	@Override
	public void createSurveillant(InvigilatorEntity invigilatorEntity) {
		invigilatorRepository.save(invigilatorEntity);

	}


}
