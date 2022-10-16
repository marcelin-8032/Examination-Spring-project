package com.cegefos.tp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cegefos.tp1.entity.Salle;
import com.cegefos.tp1.service.SalleService;

@RestController
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	private SalleService salleService;

	@PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createASalle(@RequestBody Salle salle) {
		salleService.createSalle(salle);
	}

	@PutMapping(value = "/update/{salleId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateSalleWithNumber(@PathVariable("salleId")Integer salleId, int numero) {
		try {
			salleService.updateSalle(salleId, numero);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PostMapping
	public void createListSalle(List<Salle> salles) {
		salleService.createTwoSalles(salles);
	}

	@DeleteMapping
	public void deleteAllSalles() {
		salleService.deleteAllSalles();
	}

}
