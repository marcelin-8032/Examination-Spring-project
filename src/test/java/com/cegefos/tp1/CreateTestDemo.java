package com.cegefos.tp1;

import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.enums.Module;
import com.cegefos.tp1.persistance.entities.*;
import com.cegefos.tp1.persistance.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private InvigilatorRepository invigilatorRepository;

    private RoomEntity roomEntity1254;
    private RoomEntity roomEntity1255;
    private RoomEntity roomEntity1256;

    private InvigilatorEntity invigilatorEntityAdrian;
    private InvigilatorEntity invigilatorEntityArthur;
    private InvigilatorEntity invigilatorEntityMaria;

    private SubjectEntity physique;
    private SubjectEntity chimie;
    private SubjectEntity informatique;
    private SubjectEntity literature;
    private SubjectEntity philosophie;
    private SubjectEntity musique;
    private SubjectEntity DATA;

    private Set<ExamEntity> listExamens1;
    private Set<ExamEntity> listExamens2;
    private Set<ExamEntity> listExamens3;

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private Date date1;
    private Date date2;
    private Date date3;
    private Date date4;

    private StudentEntity studentEntity1;
    private StudentEntity studentEntity2;
    private StudentEntity studentEntity3;
    private StudentEntity studentEntity4;
    private StudentEntity studentEntity5;
    private StudentEntity studentEntity6;
    private StudentEntity studentEntity7;
    private StudentEntity studentEntity8;

    private ExamEntity examEntity1;
    private ExamEntity examEntity2;
    private ExamEntity examEntity3;
    private ExamEntity examEntity4;
    private ExamEntity examEntity5;
    private ExamEntity examEntity6;

    @BeforeEach
    void setUp() throws ParseException {
        date1 = simpleDateFormat.parse("2022-01-31 09:00:00");
        date2 = simpleDateFormat.parse("2022-02-15 09:00:00");
        date3 = simpleDateFormat.parse("2022-02-18 09:00:00");
        date4 = simpleDateFormat.parse("2022-02-25 09:00:00");

        physique = new SubjectEntity("Physique", 164, Module.module2);
        chimie = new SubjectEntity("Chimie", 164, Module.module2);
        informatique = new SubjectEntity("Informatique", 200, Module.module1);
        literature = new SubjectEntity("Literature", 175, Module.module3);
        philosophie = new SubjectEntity("Philosophie", 190, Module.module3);
        musique = new SubjectEntity("Musique", 155, Module.module3);
        DATA = new SubjectEntity("data", 200, Module.module1);

        invigilatorEntityAdrian = new InvigilatorEntity("Adrian");
        invigilatorEntityArthur = new InvigilatorEntity("Arthur");
        invigilatorEntityMaria = new InvigilatorEntity("Maria");

        roomEntity1254 = new RoomEntity(1254);
        roomEntity1255 = new RoomEntity(1255);
        roomEntity1256 = new RoomEntity(1256);

        examEntity1 = new ExamEntity(date1, physique, roomEntity1254, invigilatorEntityArthur);
        examEntity2 = new ExamEntity(date2, literature, roomEntity1254, invigilatorEntityMaria);
        examEntity3 = new ExamEntity(date3, philosophie, roomEntity1254, invigilatorEntityArthur);
        examEntity4 = new ExamEntity(date1, chimie, roomEntity1255, invigilatorEntityAdrian);
        examEntity5 = new ExamEntity(date3, informatique, roomEntity1255, invigilatorEntityMaria);
        examEntity6 = new ExamEntity(date4, musique, roomEntity1256, invigilatorEntityAdrian);

        listExamens1 = new HashSet<>();
        listExamens1.add(examEntity1);
        listExamens1.add(examEntity2);
        listExamens1.add(examEntity3);

        listExamens2 = new HashSet<>();
        listExamens2.add(examEntity4);
        listExamens2.add(examEntity5);

        listExamens3 = new HashSet<>();
        listExamens3.add(examEntity6);

        studentEntity1 = new StudentEntity("Alex", Classe.classeA, listExamens1);
        studentEntity2 = new StudentEntity("Albert", Classe.classeB, listExamens1);
        studentEntity3 = new StudentEntity("Robert", Classe.classeC, listExamens1);
        studentEntity4 = new StudentEntity("Mickael", Classe.classeB, listExamens2);
        studentEntity5 = new StudentEntity("Mohsen", Classe.classeA, listExamens2);
        studentEntity6 = new StudentEntity("Betty", Classe.classeC, listExamens2);
        studentEntity7 = new StudentEntity("Maria", Classe.classeA, listExamens3);
        studentEntity8 = new StudentEntity("Nathalia", Classe.classeC, listExamens3);
    }

    @Test
    void saveObjectsByRepository() {

        System.out.println("\n*******************Matiere*********************************");
        subjectRepository.save(physique);
        subjectRepository.save(chimie);
        subjectRepository.save(informatique);
        subjectRepository.save(literature);
        subjectRepository.save(philosophie);
        subjectRepository.save(musique);
        subjectRepository.save(DATA);
        subjectRepository.findAll().forEach(System.out::println);

        System.out.println("\n*******************Surveillant*********************************");
        invigilatorRepository.save(invigilatorEntityAdrian);
        invigilatorRepository.save(invigilatorEntityArthur);
        invigilatorRepository.save(invigilatorEntityMaria);
        invigilatorRepository.findAll().forEach(System.out::println);

        System.out.println("\n*******************Salle*********************************");
        roomRepository.save(roomEntity1254);
        roomRepository.save(roomEntity1255);
        roomRepository.save(roomEntity1256);
        roomRepository.findAll().forEach(System.out::println);

        System.out.println("\n*******************Examen*********************************");
        examRepository.saveAll(listExamens1);
        examRepository.saveAll(listExamens2);
        examRepository.saveAll(listExamens3);
        examRepository.findAll().forEach(System.out::println);

        System.out.println("\n*******************Etudiant*********************************");
        studentRepository.save(studentEntity1);
        studentRepository.save(studentEntity2);
        studentRepository.save(studentEntity3);
        studentRepository.save(studentEntity4);
        studentRepository.save(studentEntity5);
        studentRepository.save(studentEntity6);
        studentRepository.save(studentEntity7);
        studentRepository.save(studentEntity8);
        studentRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Disabled
    void createTwoSallesThatInsertImediatelyIntoDB() {

        RoomEntity roomEntityX1 = new RoomEntity(1354);
        RoomEntity roomEntityX2 = new RoomEntity(1355);

        List<RoomEntity> salleEntities = new ArrayList<>();
        salleEntities.add(roomEntityX1);
        salleEntities.add(roomEntityX2);

        roomRepository.saveAll(salleEntities);
        roomRepository.findAll().forEach(System.out::println);

    }

}
