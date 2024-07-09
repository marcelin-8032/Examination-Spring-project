package com.examination.project.utils;

import com.examination.project.domain.entities.*;
import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collections;

import static lombok.AccessLevel.PRIVATE;


@NoArgsConstructor(access = PRIVATE)
public class ModelFactory {

    public static Subject defaultSubject() {
        return Subject.builder()
                .title("Physics")
                .subjectModule(SubjectModule.MODULE_2)
                .coefficient(164)
                .build();
    }

    public static Student defaultStudent() {
        return Student
                .builder()
                .studentId(1)
                .firstName("Alex")
                .lastName("Fergosen")
                .studyYear(2023)
                .identificationId(15698)
                .birthDay(Instant.now())
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
                .number(1254)
                .build();
    }

    public static Exam defaultExam() {
        return Exam
                .builder()
                .examDate(LocalDateTime.now())
                .subject(defaultSubject())
                .room(defaultRoom())
                .invigilator(defaultInvigilator())
                .build();
    }

    public static Set<Exam> defaultExams() {
        return List.of(defaultExam(),
                defaultExam().withExamDate(LocalDateTime.now().plusDays(2)),
                defaultExam().withExamDate(LocalDateTime.now().plusDays(3)),
                defaultExam().withExamDate(LocalDateTime.now().plusDays(4)),
                defaultExam().withExamDate(LocalDateTime.now().plusDays(5)),
                defaultExam().withExamDate(LocalDateTime.now().plusDays(6)),
                defaultExam().withExamDate(LocalDateTime.now().plusDays(7))).toLinkedSet();
    }

    public static Invigilator defaultInvigilator() {
        return Invigilator.builder()
                .invigilatorId(1)
                .firstName("Mohsen")
                .lastName("David")
                .identificationNumber(123454)
                .build();
    }

    public static InvigilatorEntity defaultInvigilatorEntity() {
        return InvigilatorEntity.builder()
                .invigilatorId(1)
                .firstName("Mohsen")
                .lastName("David")
                .identificationNumber(123454)
                .build();
    }

    public static java.util.List defaultInvigilatorEntityList() {
        return Collections.singletonList(defaultInvigilatorEntity());
    }

    public static java.util.List defaultInvigilatorList() {
        return Collections.singletonList(defaultInvigilator());
    }
}