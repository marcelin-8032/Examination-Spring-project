module Infrastructure {
    requires java.validation;
    requires spring.beans;
    requires spring.data.commons;
    requires spring.web;
    requires lombok;
    requires io.swagger.v3.oas.annotations;
    requires com.fasterxml.jackson.annotation;
    requires io.vavr;
    requires java.persistence;
    requires spring.data.jpa;
    requires spring.context;
    requires shared;
    requires Domain;
    exports com.examination.project.persistance.common;
    exports com.examination.project.persistance.exam.entities;
    exports com.examination.project.persistance.exam.repository;
    exports com.examination.project.persistance.room.entities;
    exports com.examination.project.persistance.room.repository;
    exports com.examination.project.persistance.student.entities;
    exports com.examination.project.persistance.student.repository;
    exports com.examination.project.persistance.subject.repository;
    exports com.examination.project.persistance.subject.entities;
    exports com.examination.project.persistance.invigilator.entities;
    exports com.examination.project.persistance.invigilator.repository;
}