package com.examination.project.infrastructure.usecases.exam;

import com.examination.project.infrastructure.usecases.UseCaseIntegrationTest;
import io.vavr.control.Option;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

import static com.examination.project.utils.EitherTools.nothing;
import static com.examination.project.utils.EntityFactory.*;
import static com.examination.project.utils.ModelFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.when;

class ExamUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_exams() {

        //when
        val result = this.examUseCase.createExams(defaultExams().toJavaList());

        //then
        assertAll("create several exams",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 7)
        );
    }

    @Test
    void should_create_exam() {

        //when
        val result = this.examUseCase.createExam(defaultExam());

        //then
        assertAll("create an exam",
                () -> assertTrue(result.isRight()),
                () -> assertEquals(result.get().examDate(), LocalDateTime.parse("2024-07-16T17:50:50.024437100")),
                () -> assertEquals(result.get().invigilator(), defaultInvigilator())
        );
    }

    @Test
    void should_get_all_exams() {

        //when
        val result = this.examUseCase.getAllExams();

        //then
        assertAll("find all exams",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 7)
        );
    }


    @Test
    void should_get_exams_by_date() {

        //given
        val expected = List.of(defaultExam().withExamDate(LOCAL_DATE_TIME),
                defaultExam().withExamId(2).withExamDate(LOCAL_DATE_TIME));

        //when
        when(this.examRepositoryMocked.findByExamDate(any())).thenReturn(defaultExamEntities().asJava());
        when(this.examMapperMocked.toExams(anyCollection())).thenReturn(expected);

        val result = this.examUseCase.getExamsByDate(LOCAL_DATE_TIME);

        //then
        assertAll("finds by their date",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get(), expected)
        );
    }

    @Test
    void should_get_exams_at_room_and_given_date() {

        //when
        val result = this.examUseCase.getExamsAtRoomAndGivenDate(Option.of(defaultRoom()), LOCAL_DATE_TIME);

        //then
        assertTrue(result.isRight());
        assertEquals(result.get().size(), 7);
    }


    @Test
    void get_exams_at_room_and_after_a_date() {

        //when
        val result = this.examUseCase.getExamsAtRoomAndAfterADate(defaultRoom(), LOCAL_DATE_TIME);

        //then
        assertTrue(result.isRight());
        assertEquals(result.get().size(), 7);
    }


    @Test
    void should_get_exams_at_recent_date_at_specific_room() {

        //when
        val result = this.examUseCase.getExamsAtRecentDateAtSpecificRoom(defaultRoom());

        //then
        assertTrue(result.isRight());
        assertEquals(result.get().size(), 7);

    }


    @Test
    void should_get_all_exams_in_pages() {

        //when
        when(this.examRepositoryMocked.findAll()).thenReturn(defaultExamEntities().asJava());
        when(this.examMapperMocked.pageExamEntityToPageExamDto(any())).thenReturn(defaultPageExam());

        val result = this.examUseCase.getAllExamsInPages(Pageable.ofSize(10));

        //then
        assertTrue(result.isRight());
        assertEquals(result.get().getTotalElements(), 7);
    }

    @Test
    void should_get_all_exams_by_room() {

        //when
        when(this.examRepositoryMocked.findByRoom(any(),any())).thenReturn(defaultPageExamEntities());
        when(this.examMapperMocked.pageExamEntityToPageExamDto(any())).thenReturn(defaultPageExam());

        val result = this.examUseCase.getAllExamsByRoom(ROOM_ID,Pageable.ofSize(10));

        //then
        assertTrue(result.isRight());
        assertEquals(result.get().getTotalElements(), 7);
    }

    @Test
    void should_delete_all_exams() {

        //when
        val result = this.examUseCase.deleteAllExams();

        //then
        assertTrue(result.isRight());
        assertEquals(result, nothing());
    }

    @Test
    void should_fetch_exams_assigned_to_specific_student() {

        //when
        val result = this.examUseCase.fetchExamsAssignedToSpecificStudent(STUDENT_ID);

        //then
        assertAll("find exams attached to specific student",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 7)
        );
    }
}
