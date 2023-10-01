package com.examination.project;


import com.examination.project.domain.entities.Classe;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import com.examination.project.infrastructure.persistance.exam.repository.ExamRepository;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import com.examination.project.infrastructure.persistance.student.repository.StudentRepository;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import com.examination.project.infrastructure.persistance.subject.repository.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReadTestDemo {

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String yourDateString1 = "2022-01-31 09:00:00";
    public static final String yourDateString2 = "2022-02-15 09:00:00";
    public static final String yourDateString3 = "2022-02-18 09:00:00";
    public static final String yourDateString4 = "2022-02-25 09:00:00";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private RoomRepository roomRepository;
    LocalDateTime examDate1;
    LocalDateTime examDate2;
    LocalDateTime examDate3;
    LocalDateTime examDate4;

    @BeforeEach
    void setUp() throws ParseException {
        LocalDateTime examDate1 = LocalDateTime.parse(yourDateString1);
        formatter.format(examDate1);
        LocalDateTime examDate2 = LocalDateTime.parse(yourDateString2);
        formatter.format(examDate2);
        LocalDateTime examDate3 = LocalDateTime.parse(yourDateString3);
        formatter.format(examDate3);
        LocalDateTime examDate4 = LocalDateTime.parse(yourDateString4);
        formatter.format(examDate4);
    }


    @Test
    void ListAllExams() {
        Collection<ExamEntity> examEntityList = (Collection<ExamEntity>) examRepository.findAll();
        examEntityList.stream().forEach(System.out::println);
    }


    @Test
    void findExamsAtSpecificDate() {
        examRepository.findExamenByDateExam(examDate1).forEach(System.out::println);
    }

    @Test
    void findEtudiantAtSpecificClasse() {
        studentRepository.findStudentsByClasse(Classe.classeA).forEach(System.out::println);
    }

    @Test
    void findMatieresThatCoefficientIsBiggerThanSpecificCoefficient() {
        subjectRepository.findByCoefficientGreaterThan(160).forEach(System.out::println);
//        matiereRepository.findByCoefficientGreaterThan(170).forEach(System.out::println);
//        matiereRepository.findByCoefficientGreaterThan(180).forEach(System.out::println);
        //   matiereRepository.findByCoefficientGreaterThan(199).forEach(System.out::println);
    }


    @Test
    void findExamensAtGivenSalleAndGreaterThanSpecificDate() {
        RoomEntity roomEntity1254 = roomRepository.findById(10).get();
        RoomEntity roomEntity1255 = roomRepository.findById(11).get();
        RoomEntity roomEntity1256 = roomRepository.findById(12).get();

        examRepository.findByRoomAndDateExamGreaterThan(roomEntity1254, examDate1).forEach(System.out::println);
        //  examenRepository.findByRoomAndDateExamGreaterThan(salle1255, examDate1).forEach(System.out::println);
        //  examenRepository.findByRoomAndDateExamGreaterThan(salle1256, examDate1).forEach(System.out::println);
    }

    @Test
    void findExamensAtRecentDataAtSpecificSalle() {
        RoomEntity roomEntity1254 = roomRepository.findById(10).get();
        RoomEntity roomEntity1255 = roomRepository.findById(11).get();
        RoomEntity roomEntity1256 = roomRepository.findById(12).get();

        examRepository.findTopByRoomOrderByDateExamDesc(roomEntity1254).forEach(System.out::println);
        //  examenRepository.findTopByRoomOrderByDateExamDesc(salle1256).forEach(System.out::println);

    }


    /************************************** Query method**********************************************/
    @Test
    void findExamsAtSpecificDateQueryWay() {
        examRepository.findRoomsAsDateExamQuery(examDate1).forEach(System.out::println);
    }

    @Test
    void findStudentByEachClassQueryWay() {
        studentRepository.findStudentsAsClasse(Classe.classeA).forEach(System.out::println);
    }

    @Test
    void findMatieresTheCoefficientQueryWay() {
        //  matiereRepository.findByCoefficient(160).forEach(System.out::println);
        //matiereRepository.findByCoefficient(170).forEach(System.out::println);
        //matiereRepository.findByCoefficient(180).forEach(System.out::println);
        subjectRepository.findByCoefficient(199).forEach(System.out::println);
    }


    @Test
    void findExamensAtSallAndDateQueryWay() {
        examRepository.findRoomAndDateExamQuery(10, examDate1).forEach(System.out::println);
        examRepository.findRoomAndDateExamQuery(11, examDate1).forEach(System.out::println);
        examRepository.findRoomAndDateExamQuery(12, examDate1).forEach(System.out::println);
    }


    @Test
    void findExamensAtTopDataAtSalle() {
        examRepository.findExamsAtRecentDateQuery(10).forEach(System.out::println);
        examRepository.findExamsAtRecentDateQuery(11).forEach(System.out::println);
    }

    /********************************  -------------------------Pagination and sorting methods------------------***************/
    @Test
    void findAllExamsInPageAndSorted() {
        Pageable page = PageRequest.of(0, 2, Sort.Direction.ASC, "examen_id");
        Page<ExamEntity> examens = examRepository.findAllExams(page);
        examens.forEach(System.out::println);
    }


    @Test
    void findExamensBySurveillant() {
        Pageable page = PageRequest.of(0, 3, Sort.Direction.DESC, "date_exam");
        Page<ExamEntity> examens = examRepository.findByInvigilator(8, page);
        examens.forEach(System.out::println);

        /**************************Le nombre total des pages.*****************************/
        System.out.println(examens.getTotalPages());

    }

    /********************************  -------------------------Query By Example------------------***************/

    @Test
    void findMatiereByExample() {
        var matiere = new SubjectEntity("Physique", 164, null);

        subjectRepository.findOne(Example.of(matiere));
    }

    /********************************  -------------------------Optional- QBE-----------------***************/
    @Test
    void findMatiereOptionalQBEMethod_E3_2a() {
        var matiere = new SubjectEntity();
        matiere.setCoefficient(175);

        var matcher = ExampleMatcher.matching().withMatcher("coefficient", exact());
        var matiereExampleCoeff = Example.of(matiere, matcher);

        Optional<SubjectEntity> matiereOptional1 = subjectRepository.findOne(matiereExampleCoeff);
        matiereOptional1.ifPresent(System.out::println);
    }

    @Test
    void findMatiereOptionalQBEMethod_E3_2b() {
        var matiere = new SubjectEntity();
        matiere.setCoefficient(200);
        matiere.setTitle("DATA");

        var matcher = ExampleMatcher.matchingAll().withIgnoreCase();

        var matiereExampleIntitule = Example.of(matiere, matcher);

        Optional<SubjectEntity> matiereOptional2 = subjectRepository.findOne(matiereExampleIntitule);

        matiereOptional2.ifPresent(System.out::println);
    }


}
