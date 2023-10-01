package com.examination.project.utils;

import com.examination.project.domain.entities.*;
import com.examination.project.domain.entities.Module;
import io.vavr.collection.List;
import io.vavr.collection.Set;


import java.time.LocalDateTime;


public class ModelFactory {

    private ModelFactory() {

    }

    public static Subject defaultSubject() {
        return Subject.builder()
                .title("Physics")
                .module(Module.MODULE_2)
                .coefficient(164)
                .exams(defaultExams())
                .build();
    }


    public static Student defaultStudent() {
        return Student
                .builder()
                .studentId(1)
                .name("Alex")
                .classe(Classe.classeA)
                .exams(defaultExams())
                .build();
    }

    public static Set<Student> defaultStudents() {
        return List.of(defaultStudent(),
                        defaultStudent().withName("Albert").withClasse(Classe.classeB).withExams(defaultExams()),
                        defaultStudent().withName("Robert").withClasse(Classe.classeC).withExams(defaultExams()),
                        defaultStudent().withName("Mickael").withClasse(Classe.classeB).withExams(defaultExams()),
                        defaultStudent().withName("Albert").withClasse(Classe.classeB).withExams(defaultExams()),
                        defaultStudent().withName("Albert").withClasse(Classe.classeB).withExams(defaultExams()),
                        defaultStudent().withName("Maria").withClasse(Classe.classeA).withExams(defaultExams()),
                        defaultStudent().withName("Natalia").withClasse(Classe.classeC).withExams(defaultExams()))
                .toLinkedSet();

    }


    public static Room defaultRoom() {
        return Room.builder()
                .roomId(1)
                .number(1254)
                .exams(defaultExams())
                .build();
    }

    public static Invigilator defaultInvigilator() {
        return Invigilator.builder()
                .name("Alex")
                .invigilatorId(1)
                .exams(defaultExams())
                .build();
    }


    public static Exam defaultExam() {
        return Exam
                .builder()
                .dateExam(LocalDateTime.now())
                .subject(defaultSubject())
                .room(defaultRoom())
                .invigilator(defaultInvigilator())
                .students(defaultStudents())
                .build();
    }


    public static Set<Exam> defaultExams() {
        return List.of(defaultExam(),
                defaultExam().withDateExam(LocalDateTime.now().plusDays(2)),
                defaultExam().withDateExam(LocalDateTime.now().plusDays(3)),
                defaultExam().withDateExam(LocalDateTime.now().plusDays(4)),
                defaultExam().withDateExam(LocalDateTime.now().plusDays(5)),
                defaultExam().withDateExam(LocalDateTime.now().plusDays(6)),
                defaultExam().withDateExam(LocalDateTime.now().plusDays(7))).toLinkedSet();
    }

}
