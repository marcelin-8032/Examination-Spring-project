package com.examination.project;

import com.examination.project.persistance.entities.SubjectEntity;
import com.examination.project.persistance.entities.RoomEntity;
import com.examination.project.persistance.repository.SubjectRepository;
import com.examination.project.persistance.repository.RoomRepository;
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
	private SubjectRepository subjectRepository;

	@Autowired
	private RoomRepository roomRepository;

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
			SubjectEntity oldSubjectEntity = subjectRepository.findById(matiereId).orElseThrow(() -> new Exception("there is a problem in updating coefficient number"));;
			oldSubjectEntity.setCoefficient(coeff);
			subjectRepository.save(oldSubjectEntity);
	}

	@Test
	void updateSalleNumber() throws Exception {
		RoomEntity oldRoomEntity = roomRepository.findById(salleId).orElseThrow(() -> new Exception("there is a problem in updating salle number"));
		oldRoomEntity.setNumero(salleNumero);
		roomRepository.save(oldRoomEntity);
	}

}
