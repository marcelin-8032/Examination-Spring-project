module Infrastructure {
    requires java.validation;
    requires spring.beans;
    requires spring.data.commons;
    requires spring.web;
    requires Domain;
    requires lombok;
    requires shared;
    requires io.swagger.v3.oas.annotations;
}