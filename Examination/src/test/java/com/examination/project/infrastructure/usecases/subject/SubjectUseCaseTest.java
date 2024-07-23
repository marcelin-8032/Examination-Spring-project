package com.examination.project.infrastructure.usecases.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.entities.SubjectModule;
import com.examination.project.infrastructure.persistance.subject.entities.QSubjectEntity;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import com.examination.project.infrastructure.usecases.UseCaseIntegrationTest;
import io.vavr.control.Option;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;
import java.util.Optional;

import static com.examination.project.utils.EntityFactory.*;
import static com.examination.project.utils.ModelFactory.*;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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

        val subjectEntity = QSubjectEntity.subjectEntity;
        val filterByCoeff = subjectEntity.coefficient.gt(164);
        val filterByTitle = subjectEntity.title.contains("Chemistry");
        val filterByModule = subjectEntity.subjectModule.eq(SubjectModule.MODULE_2);

        when(this.subjectRepositoryMocked.saveAll(any())).thenReturn(defaultSubjectEntitiesQueryDsl().asJava());

        when(this.subjectRepositoryMocked.findAll(filterByCoeff.and(filterByTitle).and(filterByModule)))
                .thenReturn(defaultSubjectEntitiesQueryDsl().iterator());

        when(this.subjectMapperMocked.toSubjects(anyCollection()))
                .thenReturn(defaultSubjectsQueryDsl().asJava());

        val result = this.subjectUseCase.getSubjectCoeffBiggerTitleEqDataModuleEq2(164, SubjectModule.MODULE_2);

        //then
        assertAll("find subjects by coeff bigger than title eq chemistry and subject module eq MODULE_2",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 2),
                () -> assertTrue(result.get().stream().allMatch(
                        s -> s.subjectModule().equals(SubjectModule.MODULE_2) &&
                                s.coefficient() > 164 &&
                                s.title().equals("Chemistry")))
        );
    }

    @Test
    void should_get_subject_coeff_bigger_than_and_module_eq_to() {

        //given
        val subjectEntity = QSubjectEntity.subjectEntity;
        val filterByCoeff = subjectEntity.coefficient.gt(100);
        val filterByModule = subjectEntity.subjectModule.eq(SubjectModule.MODULE_2);

        //when
        when(this.subjectRepositoryMocked.saveAll(any())).thenReturn(defaultSubjectEntitiesQueryDsl().asJava());
        when(this.subjectRepositoryMocked.findAll(filterByCoeff.and(filterByModule))).thenReturn(defaultSubjectEntitiesQueryDsl().iterator());
        when(this.subjectMapperMocked.toSubjects(anyCollection())).thenReturn(defaultSubjectsQueryDsl().asJava());

        val result = this.subjectUseCase.getSubjectCoeffBiggerThanModuleEq2(100, SubjectModule.MODULE_2);

        //then
        assertAll("find subjects by coeff bigger and subject module eq module2",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 2),
                () -> assertTrue(result.get().stream().allMatch(s -> s.subjectModule().equals(SubjectModule.MODULE_2) && s.coefficient() > 100))
        );
    }

    @Test
    void should_get_subject_title_eq_Data_Science_ModuleEq3() {

        //given
        val qSubjectEntity = QSubjectEntity.subjectEntity;
        val filterByTitle = qSubjectEntity.title.contains("Data_Science");
        val filterByModule = qSubjectEntity.subjectModule.eq(SubjectModule.MODULE_3);

        //when
        when(this.subjectRepositoryMocked.saveAll(any())).thenReturn(defaultSubjectEntitiesQueryDsl2().asJava());
        when(this.subjectRepositoryMocked.findAll(filterByTitle.and(filterByModule))).thenReturn(defaultSubjectEntitiesQueryDsl2().iterator());
        when(this.subjectMapperMocked.toSubjects(anyCollection())).thenReturn(defaultSubjectsQueryDsl2().asJava());

        val result = this.subjectUseCase.getSubjectsTitleEqDataScienceModuleEq2(SubjectModule.MODULE_3);

        //then
        assertAll("find subjects by subject module eq module_3",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 2),
                () -> assertTrue(result.get().stream().allMatch(s -> s.subjectModule().equals(SubjectModule.MODULE_3) &&
                        s.title().equals("Data_Science")))
        );
    }

    @Test
    void should_get_subject_by_example() {

        //given
        val expected = Subject.builder()
                .subjectId(1)
                .title("Physics")
                .subjectModule(SubjectModule.MODULE_2)
                .coefficient(164)
                .build();

        var matcher = Example.of(defaultSubjectEntity(), ExampleMatcher.matchingAll());

        //when
        when(this.subjectMapperMocked.toSubjectEntity(any())).thenReturn(defaultSubjectEntity());
        when(this.subjectRepositoryMocked.save(any())).thenReturn(defaultSubjectEntity());
        when(this.subjectRepositoryMocked.findOne(matcher)).thenReturn(Optional.of(defaultSubjectEntity()));
        when(this.subjectMapperMocked.unwrapReferenceToOption(any())).thenReturn(Option.of(defaultSubject()));

        val result = this.subjectUseCase.getSubjectByExample(defaultSubject());

        //then
        assertAll("find subject by subject Example",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().get(), expected)
        );
    }


    @Test
    void should_get_subject_by_coefficient_and_title() {

        //given
        val subjectEntity = SubjectEntity.builder()
                .title("Physics")
                .coefficient(100)
                .build();

        var matcher = Example.of(subjectEntity, ExampleMatcher.matchingAll());

        //when
        when(this.subjectRepositoryMocked.saveAll(anyCollection())).thenReturn(List.of(subjectEntity));
        when(this.subjectRepositoryMocked.findAll(matcher)).thenReturn(List.of(subjectEntity));
        when(this.subjectMapperMocked.toSubjects(anyCollection())).thenReturn(List.of(Subject.builder().title("Physics").coefficient(100).build()));

        val result = this.subjectUseCase.getSubjectByCoefficientAndTitle("Physics", 100);

        //then
        assertAll("find subjects by subject title and coeff",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertTrue(result.get().stream().allMatch(s -> s.coefficient() == 100 &&
                        s.title().equals("Physics")))
        );

    }

    @Test
    void should_get_subject_by_title_with_ignore_case() {

        //given
        val subjectEntity = SubjectEntity.builder()
                .title("Chemistry")
                .build();

        val matcher = Example.of(subjectEntity, ExampleMatcher.matchingAll().withIgnoreCase());

        //when
        when(this.subjectRepositoryMocked.saveAll(anyCollection())).thenReturn(List.of(subjectEntity, subjectEntity));
        when(this.subjectRepositoryMocked.findAll(matcher)).thenReturn(List.of(subjectEntity, subjectEntity));
        when(this.subjectMapperMocked.toSubjects(anyCollection()))
                .thenReturn(List.of(Subject.builder().title("Chemistry").build(),
                        Subject.builder().title("Chemistry").build()));

        val result = this.subjectUseCase.getSubjectByTitleWithIgnoreCase("Chemistry");

        //then
        assertAll("find subjects by subject title ignore case",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 2),
                () -> assertTrue(result.get().stream().allMatch(s -> s.title().equals("Chemistry")))
        );
    }
}
