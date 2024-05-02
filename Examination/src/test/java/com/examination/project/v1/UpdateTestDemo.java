/*
package com.examination.project.v1;

import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import com.examination.project.infrastructure.persistance.subject.repository.SubjectRepository;
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
		oldRoomEntity.setNumber(salleNumero);
		roomRepository.save(oldRoomEntity);
	}

}
*/
