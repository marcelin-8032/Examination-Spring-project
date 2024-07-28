package com.examination.project.infrastructure.handler.controller.v1.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.fixture.ExamFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static com.examination.project.utils.EntityFactory.ROOM_ID;
import static com.examination.project.utils.ModelFactory.defaultExam;
import static com.examination.project.utils.ModelFactory.defaultExams;
import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ExamRestHandlerTest extends IntegrationTest {

    @Test
    void should_create_exam() {

        given(this.examUseCaseMocked.createExam(any(Exam.class)))
                .willAnswer((invocationOnMock -> Either.right(invocationOnMock.getArgument(0))));

        val resultActions = this.examRestHandlerFixture.addExam();

        verify(examUseCaseMocked, atLeastOnce()).createExam(defaultExam());
        assertEquals(resultActions.andReturn().getResponse().getStatus(), HttpStatus.CREATED.value());
    }

    @Test
    void should_create_list_exams() {

        given(this.examUseCaseMocked.createExams(anyList()))
                .willAnswer((invocationOnMock -> Either.right(invocationOnMock.getArgument(0))));

        val resultActions = this.examRestHandlerFixture.addListExams();

        verify(examUseCaseMocked, atLeastOnce()).createExams(defaultExams().toJavaList());
        assertEquals(resultActions.andReturn().getResponse().getStatus(), HttpStatus.CREATED.value());
    }


    @Test
    void should_return_all_exams() {

        //given
        val exams = ExamFixture.from(10);

        //when
        when(this.examUseCaseMocked.getAllExams()).thenReturn(right(exams.asJava()));

        val result = this.examRestHandlerFixture.getAllExams().with(mockMvc, objectMapper);

        //then
        assertEquals(result.asJava().size(), 10);
        assertEquals(result, exams);
    }

    @Test
    void should_return_all_exams_by_their_room() {

        //given
        val exams = defaultExams().toJavaList();

        val examPage = new PageImpl<>(exams, PageRequest.of(0, 3), 10);

        //when
        when(this.examUseCaseMocked.getAllExamsByRoom(eq(ROOM_ID), any())).thenReturn(right(examPage));

        val result = this.examRestHandlerFixture.getAllExamsByRoom();

        //then
        verify(this.examUseCaseMocked, times(1)).getAllExamsByRoom(eq(ROOM_ID), any());
        assertEquals(result.getContent(), examPage.getContent());
        assertEquals(result.getContent(), examPage.getContent());
        assertEquals(result.getTotalElements(), examPage.getTotalElements());
        assertEquals(result.getTotalPages(), examPage.getTotalPages());
    }

    @Test
    void should_get_exams_by_date() {

/*        //given
        val exams = List.of(defaultExam().withExamDate(LocalDateTime.parse("2024-07-16T17:50:50.024437100")));

        //when
        when(this.examUseCaseMocked.getExamsByDate(any())).thenReturn(right(exams.asJava()));

        val result = this.examRestHandlerFixture.getExamsByDate().with(mockMvc, objectMapper);

        //then
        verify(this.examUseCaseMocked, times(1)).getExamsByDate(any());

        assertEquals(result.asJava().size(), 10);*/
    }

    @Test
    void should_get_exams_at_room_and_after_date() {


    }

    @Test
    void should_get_exams_at_recent_date_at_specific_room() {


    }


    @Test
    void should_get_all_exams_in_pages() {


    }

    @Test
    void should_delete_all_exams() {

        //when
        when(this.examUseCaseMocked.deleteAllExams()).thenReturn(Either.right(null));

        var resultActions = this.examRestHandlerFixture.deleteAllExams();

        //then
        verify(examUseCaseMocked, atMostOnce()).deleteAllExams();
        assertEquals(resultActions.getResponse().getStatus(), HttpStatus.NO_CONTENT.value());
    }

    @Test
    void should_get_Exams_Assigned_To_Specific_Student() {

        //when
        // when(this.examUseCaseMocked.createExams(anyList())).thenReturn(right(defaultExams().toJavaList()));
//        when(this.examUseCaseMocked.fetchExamsAssignedToSpecificStudent(anyInt())).thenReturn(right(defaultExams().toJavaList()));
//
//       val result = this.examRestHandlerFixture.getExamsAssignedToSpecificStudent().with(mockMvc, objectMapper);
//
//        verify(this.examUseCaseMocked, atLeastOnce()).fetchExamsAssignedToSpecificStudent(STUDENT_ID);
//        assertEquals(result.asJava().size(),6);

    }
}