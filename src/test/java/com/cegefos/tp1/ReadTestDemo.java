package com.cegefos.tp1;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.entity.Matiere;
import com.cegefos.tp1.entity.Salle;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.repository.EtudiantRepository;
import com.cegefos.tp1.repository.ExamenRepository;
import com.cegefos.tp1.repository.MatiereRepository;
import com.cegefos.tp1.repository.SalleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

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

    /********************************  -------------------------Pagination and sorting methods------------------***************/
    @Test
    void findAllExamsInPageAndSorted() {
        Pageable page = PageRequest.of(0, 2, Sort.Direction.ASC, "examen_id");
        Page<Examen> examens = examenRepository.findAllExamens(page);
        examens.forEach(System.out::println);
    }


    @Test
    void findExamensBySurveillant() {
        Pageable page = PageRequest.of(0, 3, Sort.Direction.DESC, "date_exam");
        Page<Examen> examens = examenRepository.findBysurveillant(8, page);
        examens.forEach(System.out::println);

        /**************************Le nombre total des pages.*****************************/
        System.out.println(examens.getTotalPages());

    }

    /********************************  -------------------------Query By Example------------------***************/

    @Test
    void findMatiereByExample() {
        var matiere = new Matiere("Physique", 164, null);

        matiereRepository.findOne(Example.of(matiere));
    }

    /********************************  -------------------------Optional- QBE-----------------***************/
    @Test
    void findMatiereOptionalQBEMethod_E3_2a() {
        var matiere = new Matiere();
        matiere.setCoefficient(175);

        var matcher = ExampleMatcher.matching().withMatcher("coefficient", exact());
        var matiereExampleCoeff = Example.of(matiere, matcher);

        Optional<Matiere> matiereOptional1 = matiereRepository.findOne(matiereExampleCoeff);
        matiereOptional1.ifPresent(System.out::println);
    }

    @Test
    void findMatiereOptionalQBEMethod_E3_2b() {
        var matiere = new Matiere();
        matiere.setCoefficient(200);
        matiere.setIntitule("DATA");

        var matcher = ExampleMatcher.matchingAll().withIgnoreCase();

        var matiereExampleIntitule = Example.of(matiere, matcher);

        Optional<Matiere> matiereOptional2 = matiereRepository.findOne(matiereExampleIntitule);

        matiereOptional2.ifPresent(System.out::println);
    }


}
