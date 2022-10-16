package com.cegefos.tp1.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cegefos.tp1.entity.Matiere;
import com.cegefos.tp1.service.MatiereService;

@RestController
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private MatiereService matiereService;

	@PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createMatiere(@RequestBody Matiere matiere) {
		matiereService.createMatiere(matiere);
	}

	@PutMapping(value = "/update/{matiereId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateMatiereWithNumero(@PathVariable("matiereId") Integer matiereId, int numero) {
		try {
			matiereService.updateMatiere(matiereId, numero);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GetMapping(value = "/matieresbycoeff")
	public Collection<Matiere> getMatiereByCoeffBiggerThan(int coeff) {
		return matiereService.getMatieresGreaterThanACoefficient(coeff);
	}

	@GetMapping(value = "/matieresbyexp")
	public Optional<Matiere> getMatiereByExample(Example<?> example) {
		return matiereService.getMatiereByExample(example);
	}

	@GetMapping(value = "/matieresbyexpcoeff")
	public Optional<Matiere> getMatiereByCoefficent(Example<?> example) {
		return matiereService.getMatiereByCoefficent(example);
	}

	@GetMapping(value = "/matieresbyexpignorcase")
	public Optional<Matiere> getMatiereByTitleWithIgnoreCase(Example<?> example) {
		return matiereService.getMatiereByTitleWithIgnoreCase(example);
	}

}
