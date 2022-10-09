package com.cegefos.tp1;

import com.cegefos.tp1.entity.Matiere;
import com.cegefos.tp1.entity.Salle;
import com.cegefos.tp1.repository.MatiereRepository;
import com.cegefos.tp1.repository.SalleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UpdateTestDemo {

	@Autowired
	private MatiereRepository matiereRepository;

	@Autowired
	private SalleRepository salleRepository;

	Integer matiereId;
	int coeff;
	
	Integer salleId;
	int salleNumero;
	
	@BeforeEach
	void setUp() {

		matiereId = 5;
		coeff = 2001;
		
		salleId=14;
		salleNumero=3452;
	}

	@Test
	void updateCoeffiecientMatiere() throws Exception {
			Matiere OldMatiere = matiereRepository.findById(matiereId).orElseThrow(() -> new Exception("there is a problem in updating coefficient number"));;
			OldMatiere.setCoefficient(coeff);
			matiereRepository.save(OldMatiere);
	}

	@Test
	void updateSalleNumber() throws Exception {
		Salle oldSalle=salleRepository.findById(salleId).orElseThrow(() -> new Exception("there is a problem in updating salle number"));
		oldSalle.setNumero(salleNumero);
		salleRepository.save(oldSalle);
	}

}
