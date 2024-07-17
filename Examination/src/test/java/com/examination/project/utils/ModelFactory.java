package com.examination.project.utils;

import com.examination.project.domain.entities.*;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;


@NoArgsConstructor(access = PRIVATE)
public class ModelFactory {

    public static Subject defaultSubject() {
        return Subject.builder()
                .subjectId(1)
                .title("Physics")
                .subjectModule(SubjectModule.MODULE_2)
                .coefficient(164)
                .build();
    }

    public static List<Subject> defaultSubjects() {
        return List.of(defaultSubject().withSubjectId(2).withCoefficient(200),
                defaultSubject().withSubjectId(4).withCoefficient(180),
                defaultSubject().withSubjectId(8).withCoefficient(166)
        );
    }

    public static List<Subject> defaultSubjects2() {
        return List.of(defaultSubject(),
                defaultSubject().withSubjectId(2),
                defaultSubject().withSubjectId(3)
        );
    }


    public static Student defaultStudent() {
        return Student
                .builder()
                .studentId(1)
                .firstName("Alex")
                .lastName("Fergosen")
                .studyYear(2023)
                .identificationId(15698)
                .birthDay(Instant.parse("2024-07-15T17:34:43.257072800Z"))
                .classe(Classe.classeA)
                .build();
    }

    public static Set<Student> defaultStudents() {
        return List.of(defaultStudent(),
                        defaultStudent().withFirstName("Albert").withClasse(Classe.classeB),
                        defaultStudent().withFirstName("Robert").withClasse(Classe.classeC),
                        defaultStudent().withFirstName("Mickael").withClasse(Classe.classeB),
                        defaultStudent().withFirstName("Albert").withClasse(Classe.classeB),
                        defaultStudent().withFirstName("Albert").withClasse(Classe.classeB),
                        defaultStudent().withFirstName("Maria").withClasse(Classe.classeA),
                        defaultStudent().withFirstName("Natalia").withClasse(Classe.classeC))
                .toLinkedSet();

    }

    public static Room defaultRoom() {
        return Room.builder()
                .roomId(1)
                .department("main")
                .floor(3)
                .number(1254)
                .build();
    }

    public static List<Room> defaultRooms() {
        return List.of(defaultRoom(),
                defaultRoom().withRoomId(2),
                defaultRoom().withRoomId(3));
    }

    public static Exam defaultExam() {
        return Exam
                .builder()
                .examId(1)
                .examDate(LocalDateTime.parse("2024-07-16T17:50:50.024437100"))
                .subject(defaultSubject())
                .room(defaultRoom())
                .invigilator(defaultInvigilator())
                .build();
    }

    public static Set<Exam> defaultExams() {
        return List.of(defaultExam(),
                defaultExam().withExamId(2).withExamDate(LocalDateTime.parse("2024-07-16T17:50:50.024437100").plusDays(2)),
                defaultExam().withExamId(3).withExamDate(LocalDateTime.parse("2023-07-16T17:50:50.024437100").plusDays(3)),
                defaultExam().withExamId(4).withExamDate(LocalDateTime.parse("2022-07-16T17:50:50.024437100").plusDays(4)),
                defaultExam().withExamId(5).withExamDate(LocalDateTime.parse("2025-07-16T17:50:50.024437100").plusDays(5)),
                defaultExam().withExamId(6).withExamDate(LocalDateTime.parse("2022-07-16T17:50:50.024437100").plusDays(6)),
                defaultExam().withExamId(7).withExamDate(LocalDateTime.parse("2021-07-16T17:50:50.024437100").plusDays(7))).toLinkedSet();
    }

    public static Invigilator defaultInvigilator() {
        return Invigilator.builder()
                .invigilatorId(1)
                .firstName("Mohsen")
                .lastName("David")
                .identificationNumber(123454)
                .build();
    }

    public static List<Invigilator> defaultInvigilatorList() {
        return List.of(defaultInvigilator());
    }

    public static Set<Student> defaultStudents2() {
        return List.of(defaultStudent().withClasse(Classe.classeB),
                        defaultStudent()
                                .withStudentId(2)
                                .withFirstName("Albert")
                                .withClasse(Classe.classeB),
                        defaultStudent().withStudentId(3).withFirstName("Mickael").withClasse(Classe.classeB),
                        defaultStudent().withStudentId(4).withFirstName("Albert").withClasse(Classe.classeB))
                .toLinkedSet();
    }

}