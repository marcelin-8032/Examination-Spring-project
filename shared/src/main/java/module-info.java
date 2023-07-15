module shared {
    exports com.examination.project.enums;
    requires java.persistence;
    requires spring.data.commons;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.security.core;
    requires lombok;
    requires io.vavr;
    requires spring.web;
    requires spring.webmvc;
}