package com.cegefos.tp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cegefos.tp1.entity.Surveillant;
import com.cegefos.tp1.service.SurveillantService;

@RestController
@RequestMapping("/surveillant")
public class SurveillantController {

	@Autowired
	private SurveillantService surveillantService;

	@PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createASurveillant(@RequestBody Surveillant surveillant) {
		surveillantService.createSurveillant(surveillant);
	}

}
