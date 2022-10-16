package com.cegefos.tp1.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.entity.Salle;
import com.cegefos.tp1.service.ExamenService;

@RestController
@RequestMapping("/examen")
public class ExamenController {

	@Autowired
	private ExamenService examenService;

	@PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createExamens(@RequestBody List<Examen> examens) {
		examenService.createExamens(examens);
	}

	@GetMapping(value = "/examens")
	public Collection<Examen> getAllExamens() {
		return examenService.getAllExamens();
	}

	@GetMapping(value="/examensByDate")
	public Collection<Examen> getExamensByDate(@RequestBody Date date) {
		return examenService.getExamensByDate(date);
	}

	@GetMapping(value="/examensBySalleDate")
	public Collection<Examen> getExamAtSalleAndAfterADate(@RequestBody Salle salle, Date date) {
		return examenService.getExamAtSalleAndAfterADate(salle, date);
	}

	@GetMapping(value="/examensBySalle")
	public Collection<Examen> getExamensAtRecentDataAtSpecificSalle(@RequestBody Salle salle) {
		return examenService.getExamensAtRecentDataAtSpecificSalle(salle);
	}

	@GetMapping
	public Page<Examen> getAllExamensInPages(@NotNull final Pageable pageable) {
		return examenService.getAllExamensInPages(pageable);
	}

	@GetMapping(value="examens/{salleId}")
	public Page<Examen> getAllExamensBySalle(@PathVariable("salleId")Integer salleId, @NotNull final  Pageable pageable) {
		return examenService.getAllExamensBySalle(salleId, pageable);
	}

}
