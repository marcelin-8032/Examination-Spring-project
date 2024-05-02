package com.examination.project.domain.usecases.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.fixture.ExamFixture;
import com.examination.project.domain.usecases.UseCaseIntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.notNull;

@SpringBootTest
class ExamUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_Exams() {

    /*  val examList = ExamFixture.from(1);

        val expected = examUseCase.createExams(List.of(Exam.builder().build()));

        assertEquals(expected, is((Field) notNull()));*/

    }

    @Test
    void should_create_Exam(){


    }


    @Test
    void should_get_all_exams(){


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
