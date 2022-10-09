package com.cegefos.tp1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.entity.Surveillant;
import com.cegefos.tp1.repository.SurveillantRepository;
import com.cegefos.tp1.service.SurveillantService;

@Service
public class SurveillantServiceImpl implements SurveillantService {

	@Autowired
	private SurveillantRepository surveillantRepository;

	@Override
	public void createEtudiant(Surveillant surveillant) {
		surveillantRepository.save(surveillant);

	}

}
