package com.cegefos.tp2;

import com.cegefos.tp2.entity.*;
import com.cegefos.tp2.enums.Classe;
import com.cegefos.tp2.enums.Module;
import com.cegefos.tp2.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CreateTestDemo {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private ExamenRepository examenRepository;

	@Autowired
	private MatiereRepository matiereRepository;

	@Autowired
	private SalleRepository salleRepository;

	@Autowired
	private SurveillantRepository surveillantRepository;

	private Salle salle1254;
	private Salle salle1255;
	private Salle salle1256;

	private Surveillant surveillantAdrian;
	private Surveillant surveillantArthur;
	private Surveillant surveillantMaria;

	private Matiere physique;
	private Matiere chimie;
	private Matiere informatique;
	private Matiere literature;
	private Matiere philosophie;
	private Matiere musique;

	private Set<Examen> listExamens1;
	private Set<Examen> listExamens2;
	private Set<Examen> listExamens3;

	private static final String pattern = "yyyy-MM-dd HH:mm:ss";
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	private Date date1;
	private Date date2;
	private Date date3;
	private Date date4;

	private Etudiant etudiant1;
	private Etudiant etudiant2;
	private Etudiant etudiant3;
	private Etudiant etudiant4;
	private Etudiant etudiant5;
	private Etudiant etudiant6;
	private Etudiant etudiant7;
	private Etudiant etudiant8;

	private Examen examen1;
	private Examen examen2;
	private Examen examen3;
	private Examen examen4;
	private Examen examen5;
	private Examen examen6;

	@BeforeEach
	void setUp() throws ParseException {
		date1 = simpleDateFormat.parse("2022-01-31 09:00:00");
		date2 = simpleDateFormat.parse("2022-02-15 09:00:00");
		date3 = simpleDateFormat.parse("2022-02-18 09:00:00");
		date4 = simpleDateFormat.parse("2022-02-25 09:00:00");

		physique = new Matiere("Physique", 164, Module.module2);
		chimie = new Matiere("Chimie", 164, Module.module2);
		informatique = new Matiere("Informatique", 200, Module.module1);
		literature = new Matiere("Literature", 175, Module.module3);
		philosophie = new Matiere("Philosophie", 190, Module.module3);
		musique = new Matiere("Musique", 155, Module.module3);

		surveillantAdrian = new Surveillant("Adrian");
		surveillantArthur = new Surveillant("Arthur");
		surveillantMaria = new Surveillant("Maria");

		salle1254 = new Salle(1254);
		salle1255 = new Salle(1255);
		salle1256 = new Salle(1256);

		examen1 = new Examen(date1, physique, salle1254, surveillantArthur);
		examen2 = new Examen(date2, literature, salle1254, surveillantMaria);
		examen3 = new Examen(date3, philosophie, salle1254, surveillantArthur);
		examen4 = new Examen(date1, chimie, salle1255, surveillantAdrian);
		examen5 = new Examen(date3, informatique, salle1255, surveillantMaria);
		examen6 = new Examen(date4, musique, salle1256, surveillantAdrian);

		listExamens1 = new HashSet<>();
		listExamens1.add(examen1);
		listExamens1.add(examen2);
		listExamens1.add(examen3);

		listExamens2 = new HashSet<>();
		listExamens2.add(examen4);
		listExamens2.add(examen5);

		listExamens3 = new HashSet<>();
		listExamens3.add(examen6);

		etudiant1 = new Etudiant("Alex", Classe.classeA, listExamens1);
		etudiant2 = new Etudiant("Albert", Classe.classeB, listExamens1);
		etudiant3 = new Etudiant("Robert", Classe.classeC, listExamens1);
		etudiant4 = new Etudiant("Mickael", Classe.classeB, listExamens2);
		etudiant5 = new Etudiant("Mohsen", Classe.classeA, listExamens2);
		etudiant6 = new Etudiant("Betty", Classe.classeC, listExamens2);
		etudiant7 = new Etudiant("Maria", Classe.classeA, listExamens3);
		etudiant8 = new Etudiant("Nathalia", Classe.classeC, listExamens3);
	}

	@Test
	void saveObjectsByRepository() {

		System.out.println("\n*******************Matiere*********************************");
		matiereRepository.save(physique);
		matiereRepository.save(chimie);
		matiereRepository.save(informatique);
		matiereRepository.save(literature);
		matiereRepository.save(philosophie);
		matiereRepository.save(musique);
		matiereRepository.findAll().forEach(System.out::println);

		System.out.println("\n*******************Surveillant*********************************");
		surveillantRepository.save(surveillantAdrian);
		surveillantRepository.save(surveillantArthur);
		surveillantRepository.save(surveillantMaria);
		surveillantRepository.findAll().forEach(System.out::println);

		System.out.println("\n*******************Salle*********************************");
		salleRepository.save(salle1254);
		salleRepository.save(salle1255);
		salleRepository.save(salle1256);
		salleRepository.findAll().forEach(System.out::println);

		System.out.println("\n*******************Examen*********************************");
		examenRepository.saveAll(listExamens1);
		examenRepository.saveAll(listExamens2);
		examenRepository.saveAll(listExamens3);
		examenRepository.findAll().forEach(System.out::println);

		System.out.println("\n*******************Etudiant*********************************");
		etudiantRepository.save(etudiant1);
		etudiantRepository.save(etudiant2);
		etudiantRepository.save(etudiant3);
		etudiantRepository.save(etudiant4);
		etudiantRepository.save(etudiant5);
		etudiantRepository.save(etudiant6);
		etudiantRepository.save(etudiant7);
		etudiantRepository.save(etudiant8);
		etudiantRepository.findAll().forEach(System.out::println);
	}

	@Test
	void createTwoSallesThatInsertImediatelyIntoDB() {

		Salle salleX1 = new Salle(1354);
		Salle salleX2 = new Salle(1355);

		List<Salle> salles = new ArrayList<>();
		salles.add(salleX1);
		salles.add(salleX2);

		salleRepository.saveAll(salles);
		salleRepository.findAll().forEach(System.out::println);

	}

}
