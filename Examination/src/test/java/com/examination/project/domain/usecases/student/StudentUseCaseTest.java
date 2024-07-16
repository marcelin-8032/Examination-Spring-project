package com.examination.project.domain.usecases.student;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.usecases.UseCaseIntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static com.examination.project.utils.EntityFactory.examId;
import static com.examination.project.utils.EntityFactory.studentId;
import static com.examination.project.utils.ModelFactory.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_student() {

        //when
        val result = this.studentUseCase.createStudent(defaultStudent());

        //then
        assertAll("create new student",
                () -> assertTrue(result.isRight()),
                () -> assertNotNull(result.get()),
                () -> assertEquals(result.get().birthDay().truncatedTo(ChronoUnit.DAYS),
                        Instant.now().truncatedTo(ChronoUnit.DAYS))
        );
    }

    @Test
    void should_find_students() {

        val result = this.studentUseCase.findAllStudents();

        assertAll("find all students",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 4)
        );
    }

    @Test
    void should_find_students_by_class() {

        //when
        val result = this.studentUseCase.findStudentByClasse(Classe.classeB);

        //then
        assertAll("find  students by their class",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get(), defaultStudents2().toJavaList())
        );
    }

    @Test
    void should_add_or_update_student_to_exam() {

         //when
        val result = this.studentUseCase.addOrUpdateStudentToExam(examId, studentId);

        //then
        assertTrue(result.isRight());
    }

    @Test
    void should_fetch_exams_assigned_to_specific_student() {

        //when
        val result = this.studentUseCase.fetchExamsAssignedToSpecificStudent(studentId);

        //then
        assertAll("find exams attached to specific student",
                () -> assertTrue(result.isRight()),
                () -> assertFalse(result.get().isEmpty()),
                () -> assertEquals(result.get().size(), 7)
        );
    }

    @Test
    void should_delete_student() {

        //when
        val result = this.studentUseCase.deleteStudent(examId,studentId);

        //then
        assertTrue(result.isRight());
    }
}
