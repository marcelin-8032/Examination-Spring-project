package com.examination.project.infrastructure.handler.controller.v1.student;

import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.examination.project.utils.ModelFactory.defaultStudent;
import static com.examination.project.utils.ModelFactory.defaultStudents;
import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StudentRestHandlerTest extends IntegrationTest {

    @Test
    void should_create_student() {

        //when
        when(this.studentUseCaseMocked.createStudent(any())).thenReturn(right(defaultStudent()));

        val result = this.studentRestHandlerFixture.createStudent().with(mockMvc, objectMapper);

        //then
        verify(studentUseCaseMocked, atLeastOnce()).createStudent(defaultStudent());
        assertEquals(result, defaultStudent());
    }

    @Test
    void should_get_All_Students() {

        //when
        when(this.studentUseCaseMocked.findAllStudents()).thenReturn(right(defaultStudents().toJavaList()));

        val result = this.studentRestHandlerFixture.getAllStudents().with(mockMvc, objectMapper);

        //then
        verify(studentUseCaseMocked, atLeastOnce()).findAllStudents();
        assertEquals(result.asJava().size(), 6);
    }

    @Test
    void should_get_Student_By_Class() {


    }


    @Test
    void should_add_Or_Update_Student_To_Exam() {


    }

    @Test
    void should_get_Exams_Assigned_To_Specific_Student() {

    }

    @Test
    void should_delete_Student_Assigned_To_Exam() {


    }
}
