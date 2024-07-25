package com.examination.project.infrastructure.handler.controller.v1.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import com.examination.project.infrastructure.handler.controller.v1.subject.fixture.SubjectRestHandlerFixture;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.examination.project.domain.entities.SubjectModule.MODULE_2;
import static com.examination.project.utils.EitherTools.nothing;
import static com.examination.project.utils.EntityFactory.COEFFICIENT_ID;
import static com.examination.project.utils.EntityFactory.SUBJECT_ID;
import static com.examination.project.utils.ModelFactory.defaultSubject;
import static com.examination.project.utils.ModelFactory.defaultSubjects;
import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


class SubjectHandlerTest extends IntegrationTest {

    @Test
    void should_create_new_subject() {

        //When
        when(this.subjectUseCaseMocked.createSubject(any(Subject.class))).thenReturn(nothing());

        val result = this.subjectRestHandlerFixture.createSubject();

        //Then
        verify(this.subjectUseCaseMocked, times(1)).createSubject(defaultSubject());
        assertEquals(result.andReturn().getResponse().getStatus(), HttpStatus.CREATED.value());
    }

    @Test
    void should_update_Subject_Coefficient() throws Exception {

        //when
        when(this.subjectUseCaseMocked.updateSubjectCoefficient(SUBJECT_ID, COEFFICIENT_ID))
                .thenReturn(nothing());

        val result = this.subjectRestHandlerFixture.updateSubjectCoefficient();

        //Then
        verify(this.subjectUseCaseMocked, times(1)).updateSubjectCoefficient(SUBJECT_ID, COEFFICIENT_ID);
        assertEquals(result.andReturn().getResponse().getStatus(), HttpStatus.OK.value());
    }

    @Test
    void should_get_Subject_By_Coeff_Bigger_Than() {

        //when
        when(this.subjectUseCaseMocked.getSubjectsGreaterThanACoefficient(COEFFICIENT_ID))
                .thenReturn(right(defaultSubjects().asJava()));

        val result = this.subjectRestHandlerFixture.getSubjectByCoeffBiggerThan().with(mockMvc, objectMapper);

        //Then
        verify(this.subjectUseCaseMocked, times(1)).getSubjectsGreaterThanACoefficient(COEFFICIENT_ID);
        assertTrue(result.asJava().stream().allMatch(subject -> subject.coefficient() > COEFFICIENT_ID));
    }

    @Test
    void should_return_all_subjects() {

        //when
        when(this.subjectUseCaseMocked.getAllSubjects()).thenReturn(right(defaultSubjects().asJava()));

        val result = SubjectRestHandlerFixture.getAllSubjects().with(mockMvc, objectMapper);

        //Then
        verify(this.subjectUseCaseMocked, times(1)).getAllSubjects();
        assertEquals(result.asJava().size(), 3);
    }

    @Test
    void should_get_Subject_By_Coeff_Bigger_Than_And_Title_Data_And_Module() {

        val subject = Subject.builder()
                .title("Chemistry")
                .coefficient(170)
                .subjectModule(MODULE_2)
                .build();

        val subjects = List.of(subject,
                subject.withCoefficient(200));

        //when
        when(this.subjectUseCaseMocked.getSubjectCoeffBiggerTitleEqDataModuleEq2(COEFFICIENT_ID, MODULE_2)).thenReturn(right(subjects));

        val result = SubjectRestHandlerFixture.getSubjectByCoeffBiggerThanAndTitleDataAndModule().with(mockMvc, objectMapper);

        //Then
        verify(this.subjectUseCaseMocked, times(1)).getSubjectCoeffBiggerTitleEqDataModuleEq2(COEFFICIENT_ID, MODULE_2);
        assertEquals(result.asJava().size(), 2);
    }

    @Test
    void getSubjectByCoeffBiggerThanAndModule() {

    }

    @Test
    void getSubjectTitleDataAndModuleEq2() {

    }

    @Test
    void getSubjectByExample() {

    }

    @Test
    void getSubjectByExampleCoeffAndTitle() {

    }

    @Test
    void getSubjectByTitleWithIgnoreCase() {

    }
}
