package com.examination.project.domain.usecases.exam;

import com.examination.project.domain.usecases.UseCaseIntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.examination.project.utils.EntityFactory.LOCAL_DATE_TIME;
import static com.examination.project.utils.EntityFactory.defaultExamEntities;
import static com.examination.project.utils.ModelFactory.*;
import static org.junit.jupiter.api.Assertions.*;

class ExamUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_exams() {

        //when
        val result=this.examUseCase.createExams(defaultExams().toJavaList());

        //then
        assertAll("create several exams",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 7)
        );
    }


    @Test
    void should_create_exam(){

        //when
        val result=this.examUseCase.createExam(defaultExam());

        //then
        assertAll("create an exam",
                () -> assertTrue(result.isRight()),
                () -> assertEquals(result.get().examDate(), LocalDateTime.parse("2024-07-16T17:50:50.024437100" )),
                () -> assertEquals(result.get().invigilator(),defaultInvigilator())
        );

    }


    @Test
    void should_get_all_exams(){

        //when
        val result=this.examUseCase.getAllExams();

        //then
        assertAll("find all exams",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 7)
        );
    }


    @Test
    void should_get_exams_by_date(){


    }



    @Test
    void should_get_exams_at_room_and_given_date(){

    }



    @Test
    void get_exams_at_room_and_after_a_date(){


    }


    @Test
    void should_get_exams_at_recent_date_at_specific_room(){

    }


    @Test
    void should_get_all_exams_in_pages(){

    }

    @Test
    void should_get_all_exams_by_room(){

    }

}
