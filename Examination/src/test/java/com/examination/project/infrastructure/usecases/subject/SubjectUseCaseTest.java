package com.examination.project.infrastructure.usecases.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.infrastructure.usecases.UseCaseIntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.examination.project.utils.EntityFactory.*;
import static com.examination.project.utils.ModelFactory.defaultSubject;
import static com.examination.project.utils.ModelFactory.defaultSubjects2;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.when;

class SubjectUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_subject() {

        //when
        val result = this.subjectUseCase.createSubject(defaultSubject());

        //then
        assertTrue(result.isRight());
    }

    @Test
    void should_update_subject_coefficient() throws Exception {

        //when
        val result = this.subjectUseCase.updateSubjectCoefficient(SUBJECT_ID, COEFFICIENT_ID);

        //then
        assertTrue(result.isRight());
    }

    @Test
    void should_get_subjects_greater_than_a_coefficient() {


        //when
        val result = this.subjectUseCase.getSubjectsGreaterThanACoefficient(165);

        //then
        assertAll("find  subjects by coeff greater than >",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().stream().map(Subject::coefficient).collect(toList()), List.of(200, 180, 166))
        );
    }

    @Test
    void should_get_All_Subjects() {

        //when
        when(this.subjectMapperMocked.toSubjects(anyCollection())).thenReturn(defaultSubjects2().asJava());
        when(this.subjectRepositoryMocked.findAll()).thenReturn(defaultSubjectEntities2().asJava());

        val result = this.subjectUseCase.getAllSubjects();

        val expected = List.of(defaultSubject(), defaultSubject().withSubjectId(2), defaultSubject().withSubjectId(3));

        //then
        assertAll("find all subjects",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 3),
                () -> assertEquals(result.get(), expected)
        );
    }


    @Test
    void should_get_subject_coeff_bigger_title_eq_data_ModuleEq2() {

    }


    @Test
    void should_get_subject_coeff_bigger_than_moduleEq2() {

    }


    @Test
    void should_get_subject_title_eqDataModuleEq2() {

    }


    @Test
    void should_get_subject_by_example() {

    }


    @Test
    void should_get_subject_by_coefficient() {

    }


    @Test
    void should_get_subject_by_title_with_ignore_case() {

    }
}
