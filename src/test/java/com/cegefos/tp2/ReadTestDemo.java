package com.cegefos.tp2;

import com.cegefos.tp2.entity.Examen;
import com.cegefos.tp2.entity.Salle;
import com.cegefos.tp2.enums.Classe;
import com.cegefos.tp2.repository.EtudiantRepository;
import com.cegefos.tp2.repository.ExamenRepository;
import com.cegefos.tp2.repository.MatiereRepository;
import com.cegefos.tp2.repository.SalleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReadTestDemo {


    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String yourDateString1 = "2022-01-31 09:00:00";
    public static final String yourDateString2 = "2022-02-15 09:00:00";
    public static final String yourDateString3 = "2022-02-18 09:00:00";
    public static final String yourDateString4 = "2022-02-25 09:00:00";

    DateFormat formatter;
    Date examDate1;
    Date examDate2;
    Date examDate3;
    Date examDate4;


    @Autowired
    private ExamenRepository examenRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private MatiereRepository matiereRepository;

    @Autowired
    private SalleRepository salleRepository;

   /* Salle salle1254;
    Salle salle1255;
    Salle salle1256;*/

    @BeforeEach
    void setUp() throws ParseException {
        formatter = new SimpleDateFormat(DEFAULT_PATTERN);

        examDate1 = formatter.parse(yourDateString1);
        examDate2 = formatter.parse(yourDateString2);
        examDate3 = formatter.parse(yourDateString3);
        examDate4 = formatter.parse(yourDateString4);
    }


    @Test
    void ListAllExams() {
        Collection<Examen> examenList = (Collection<Examen>) examenRepository.findAll();
        examenList.stream().forEach(System.out::println);
    }


    @Test
    void findExamsAtSpecificDate() {
        examenRepository.findExamenByDateExam(examDate1).forEach(System.out::println);
    }

    @Test
    void findEtudiantAtSpecificClasse() {
        etudiantRepository.findEtudiantByClasse(Classe.classeA).forEach(System.out::println);
    }

    @Test
    void findMatieresThatCoefficientIsBiggerThanSpecificCoefficient() {
       matiereRepository.findByCoefficientGreaterThan(160).forEach(System.out::println);
//        matiereRepository.findByCoefficientGreaterThan(170).forEach(System.out::println);
//        matiereRepository.findByCoefficientGreaterThan(180).forEach(System.out::println);
     //   matiereRepository.findByCoefficientGreaterThan(199).forEach(System.out::println);
    }


    @Test
    void findExamensAtGivenSalleAndGreaterThanSpecificDate() {
        Salle salle1254 = salleRepository.findById(10).get();
        Salle salle1255 = salleRepository.findById(11).get();
        Salle salle1256 = salleRepository.findById(12).get();
//        List<Salle> salleList = (List<Salle>) salleRepository.findAll();
//
//        salleList.stream().filter(i->i.getSalleId()).collect(Collection)
//        for (Salle salle : salleList) {
//
//
//        }
        examenRepository.findBySalleAndDateExamGreaterThan(salle1254, examDate1).forEach(System.out::println);
        //  examenRepository.findBySalleAndDateExamGreaterThan(salle1255, examDate1).forEach(System.out::println);
        //  examenRepository.findBySalleAndDateExamGreaterThan(salle1256, examDate1).forEach(System.out::println);
    }

    @Test
    void findExamensAtRecentDataAtSpecificSalle() {
        Salle salle1254 = salleRepository.findById(10).get();
        Salle salle1255 = salleRepository.findById(11).get();
        Salle salle1256 = salleRepository.findById(12).get();

        examenRepository.findTopBySalleOrderByDateExamDesc(salle1254).forEach(System.out::println);
      //  examenRepository.findTopBySalleOrderByDateExamDesc(salle1256).forEach(System.out::println);


    }


    /************************************** Query method**********************************************/
    @Test
    void findExamsAtSpecificDateQueryWay() {
        examenRepository.findExamensAsDateExamQuery(examDate1).forEach(System.out::println);
    }

    @Test
    void findStudentByEachClassQueryWay() {
        etudiantRepository.findStudentsAsClasse(Classe.classeA).forEach(System.out::println);
    }


    @Test
    void findMatieresTheCoefficientQueryWay() {
         //  matiereRepository.findByCoefficient(160).forEach(System.out::println);
       //matiereRepository.findByCoefficient(170).forEach(System.out::println);
       //matiereRepository.findByCoefficient(180).forEach(System.out::println);
     matiereRepository.findByCoefficient(199).forEach(System.out::println);
    }


    @Test
    void findExamensAtSallAndDateQueryWay() {
        examenRepository.findSalleAndDateExamQuery(10, examDate1).forEach(System.out::println);
        examenRepository.findSalleAndDateExamQuery(11, examDate1).forEach(System.out::println);
        examenRepository.findSalleAndDateExamQuery(12, examDate1).forEach(System.out::println);
    }



    @Test
    void findExamensAtTopDataAtSalle() {
        examenRepository.findExamensAtRecentDateQuery(10).forEach(System.out::println);
       examenRepository.findExamensAtRecentDateQuery(11).forEach(System.out::println);

    }


}
