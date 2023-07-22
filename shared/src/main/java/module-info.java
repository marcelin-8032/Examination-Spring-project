module shared {
    exports com.examination.project.annotation;
    exports com.examination.project.enums;
    exports com.examination.project.exception;
    exports com.examination.project.mapper;
    exports com.examination.project.audit;
    requires java.persistence;
    requires spring.data.commons;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.security.core;
    requires lombok;
    requires io.vavr;
    requires spring.web;
    requires spring.webmvc;
    requires org.mapstruct;
}