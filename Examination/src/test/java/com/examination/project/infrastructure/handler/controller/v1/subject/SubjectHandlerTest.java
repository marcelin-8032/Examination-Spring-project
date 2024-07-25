package com.examination.project.infrastructure.handler.controller.v1.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import com.examination.project.infrastructure.handler.controller.v1.subject.fixture.SubjectRestHandlerFixture;
import io.vavr.control.Option;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.examination.project.domain.entities.SubjectModule.*;
import static com.examination.project.utils.EitherTools.nothing;
import static com.examination.project.utils.EntityFactory.*;
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

        //given
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
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.title().equals("Chemistry")));
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.subjectModule() == MODULE_2));
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.coefficient() > COEFFICIENT_ID));
    }

    @Test
    void should_get_Subject_By_Coeff_Bigger_Than_And_Module() {

        //given
        val subject = Subject.builder()
                .coefficient(170)
                .subjectModule(MODULE_2)
                .build();

        val subjects = List.of(subject,
                subject.withCoefficient(200));

        //when
        when(this.subjectUseCaseMocked.getSubjectCoeffBiggerThanModuleEq2(COEFFICIENT_ID, MODULE_2)).thenReturn(right(subjects));

        val result = SubjectRestHandlerFixture.getSubjectByCoeffBiggerThanAndModule().with(mockMvc, objectMapper);

        //Then
        verify(this.subjectUseCaseMocked, times(1)).getSubjectCoeffBiggerThanModuleEq2(COEFFICIENT_ID, MODULE_2);
        assertEquals(result.asJava().size(), 2);
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.subjectModule() == MODULE_2));
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.coefficient() > COEFFICIENT_ID));
    }

    @Test
    void should_get_Subject_Title_Data_And_Module_Eq2() {

        //given
        val subject = Subject.builder()
                .title("Data_Science")
                .subjectModule(MODULE_3)
                .build();

        val subjects = List.of(subject, subject);

        //when
        when(this.subjectUseCaseMocked.getSubjectsTitleEqDataScienceModuleEq2(any())).thenReturn(right(subjects));

        val result = SubjectRestHandlerFixture.getSubjectTitleDataAndModuleEq2().with(mockMvc, objectMapper);

        //Then
        verify(this.subjectUseCaseMocked, times(1)).getSubjectsTitleEqDataScienceModuleEq2(MODULE_3);
        assertEquals(result.asJava().size(), 2);
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.title().equals("Data_Science")));
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.subjectModule() == MODULE_3));
    }

    @Test
    void should_get_Subject_By_Example() {

        val subject = Subject.builder().build();

        //when
        when(this.subjectUseCaseMocked.getSubjectByExample(any(Subject.class))).thenReturn(right(Option.of(subject)));

        val result = SubjectRestHandlerFixture.getSubjectByExample().with(mockMvc, objectMapper);

        //Then
        verify(this.subjectUseCaseMocked, times(1)).getSubjectByExample(subject);
        assertEquals(result, subject);
    }

    @Test
    void should_get_Subject_By_Example_Coeff_And_Title() {

        //given
        val subject = Subject.builder()
                .title(SUBJECT_TITLE)
                .coefficient(COEFFICIENT_ID)
                .build();

        val subjects = List.of(subject, subject);

        //when
        when(this.subjectUseCaseMocked.getSubjectByCoefficientAndTitle(SUBJECT_TITLE, COEFFICIENT_ID)).thenReturn(right(subjects));

        val result = SubjectRestHandlerFixture.getSubjectByExampleCoeffAndTitle().with(mockMvc, objectMapper);

        //Then
        verify(this.subjectUseCaseMocked, times(1)).getSubjectByCoefficientAndTitle(SUBJECT_TITLE, COEFFICIENT_ID);
        assertEquals(result.asJava().size(), 2);
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.title().equals(SUBJECT_TITLE)));
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.coefficient() == COEFFICIENT_ID));
    }

    @Test
    void should_get_Subject_By_Title_With_IgnoreCase() {

        //given
        val subject = Subject.builder()
                .title(SUBJECT_TITLE)
                .build();

        val subjects = List.of(subject, subject);

        //when
        when(this.subjectUseCaseMocked.getSubjectByTitleWithIgnoreCase(SUBJECT_TITLE)).thenReturn(right(subjects));

        val result = SubjectRestHandlerFixture.getSubjectByTitleWithIgnoreCase().with(mockMvc, objectMapper);

        //Then
        verify(this.subjectUseCaseMocked, times(1)).getSubjectByTitleWithIgnoreCase(SUBJECT_TITLE);
        assertEquals(result.asJava().size(), 2);
        assertTrue(result.asJava().stream().allMatch(subject1 -> subject1.title().equals(SUBJECT_TITLE)));
    }
}
