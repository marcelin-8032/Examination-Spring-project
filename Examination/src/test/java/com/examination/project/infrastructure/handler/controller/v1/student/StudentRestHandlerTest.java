package com.examination.project.infrastructure.handler.controller.v1.student;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Student;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.examination.project.utils.EitherTools.nothing;
import static com.examination.project.utils.EntityFactory.EXAM_ID;
import static com.examination.project.utils.EntityFactory.STUDENT_ID;
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
        verify(this.studentUseCaseMocked, atLeastOnce()).findAllStudents();
        assertEquals(result.asJava().size(), 6);
    }

    @Test
    void should_get_Student_By_Class() {

        val studentList = List.of(defaultStudent().withClasse(Classe.classeA),
                defaultStudent().withClasse(Classe.classeA));

        //when
        when(this.studentUseCaseMocked.findStudentByClasse(any())).thenReturn(right(studentList));

        val result = this.studentRestHandlerFixture.getAllStudentsByClasse().with(mockMvc, objectMapper);

        //then
        verify(this.studentUseCaseMocked, atLeastOnce()).findStudentByClasse(Classe.classeA);
        assertEquals(result.asJava().size(), 2);
        assertEquals(result.asJava().stream().map(Student::classe).toList(), List.of(Classe.classeA, Classe.classeA));
    }


    @Test
    void should_add_Or_Update_Student_To_Exam() {

        //when
        when(this.studentUseCaseMocked.addOrUpdateStudentToExam(EXAM_ID, STUDENT_ID)).thenReturn(nothing());

        val result = this.studentRestHandlerFixture.addOrUpdateStudentToExam();

        //then
        verify(this.studentUseCaseMocked, atLeastOnce()).addOrUpdateStudentToExam(EXAM_ID, STUDENT_ID);
        assertEquals(result.andReturn().getResponse().getStatus(), HttpStatus.OK.value());
    }

    @Test
    void should_delete_Student_Assigned_To_Exam() {

        //when
        when(this.studentUseCaseMocked.deleteStudent(EXAM_ID, STUDENT_ID)).thenReturn(nothing());

        val result = this.studentRestHandlerFixture.deleteStudentAssignedToExam();

        //then
        verify(this.studentUseCaseMocked, times(1)).deleteStudent(EXAM_ID, STUDENT_ID);
        assertEquals(result.andReturn().getResponse().getStatus(), HttpStatus.NO_CONTENT.value());
    }
}
