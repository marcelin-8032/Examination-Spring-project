package com.examination.project.utils;

import com.examination.project.domain.entities.*;
import com.examination.project.domain.entities.SubjectModule;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

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
                .name("Alex")
                .classe(Classe.classeA)
                .build();
    }

    public static Set<Student> defaultStudents() {
        return List.of(defaultStudent(),
                        defaultStudent().withName("Albert").withClasse(Classe.classeB),
                        defaultStudent().withName("Robert").withClasse(Classe.classeC),
                        defaultStudent().withName("Mickael").withClasse(Classe.classeB),
                        defaultStudent().withName("Albert").withClasse(Classe.classeB),
                        defaultStudent().withName("Albert").withClasse(Classe.classeB),
                        defaultStudent().withName("Maria").withClasse(Classe.classeA),
                        defaultStudent().withName("Natalia").withClasse(Classe.classeC))
                .toLinkedSet();

    }

    public static Room defaultRoom() {
        return Room.builder()
                .roomId(1)
                .number(1254)
                .build();
    }

    public static Invigilator defaultInvigilator() {
        return Invigilator.builder()
                .firstName("Alex")
                .invigilatorId(1)
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

}
