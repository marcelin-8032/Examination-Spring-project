package com.examination.project.infrastructure.handler.controller.v1.subject;


import com.examination.project.domain.entities.Module;
import com.examination.project.domain.entities.Subject;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

@Tag(name = " Subjects API", description = "subject management")
public interface SubjectHandler {

    ResponseEntity<Void> createSubject(Subject subject);

    ResponseEntity<Void> updateSubjectWithNumber(Integer subjectId, int number) throws Exception;


    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThan(int coeff);

    ResponseEntity<Subject> getSubjectByExample(Example<?> example);


    ResponseEntity<Subject> getSubjectByCoeff(Example<?> example);


    ResponseEntity<Subject> getSubjectByTitleWithIgnoreCase(Example<?> example);


    ResponseEntity<Collection<Subject>> getSubjects();


    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule(
            int coeff, Module module);


    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndModule( int coeff,
                                                                             Module module);


    ResponseEntity<Collection<Subject>> getSubjectTitleDataAndModuleEq2(Module module);

}
