

module Domain {
    requires io.vavr;
    requires lombok;
    requires spring.data.commons;
    requires spring.beans;
    requires spring.context;
    requires com.querydsl.core;
    requires Infrastructure;
    requires shared;
    exports com.examination.project.entities;
    exports com.examination.project.usecases.exam;
    exports com.examination.project.usecases.subject;
    exports com.examination.project.usecases.student;
    exports com.examination.project.usecases.room;
    exports com.examination.project.usecases.invigilator;
}