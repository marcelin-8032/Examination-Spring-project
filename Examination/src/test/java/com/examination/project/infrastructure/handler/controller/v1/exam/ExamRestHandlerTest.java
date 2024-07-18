package com.examination.project.infrastructure.handler.controller.v1.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.fixture.ExamFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import com.fasterxml.jackson.core.type.TypeReference;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.examination.project.utils.EntityFactory.ROOM_ID;
import static com.examination.project.utils.ModelFactory.*;
import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
    void should_return_all_exams_by_their_room() throws Exception {

        //when
        given(this.examUseCaseMocked.getAllExamsByRoom(ROOM_ID, Pageable.ofSize(2))).willReturn(right(defaultPageExam2()));

        val resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/exams" + "/examPages/" + "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print());

        val result = resultActions.andReturn();
        objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });

        //val result2 = this.examRestHandlerFixture.getAllExamsByRoom();

        // verify(this.examUseCaseMocked, atLeastOnce()).getAllExamsByRoom(ROOM_ID,Pageable.ofSize(2));
        //then
        // assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        //assertEquals(result.getTotalElements(), 5);
    }


    @Test
    void should_get_exams_by_date() {


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
}