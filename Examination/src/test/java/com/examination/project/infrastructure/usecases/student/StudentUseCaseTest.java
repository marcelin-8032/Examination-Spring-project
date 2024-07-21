package com.examination.project.infrastructure.usecases.student;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Student;
import com.examination.project.infrastructure.usecases.UseCaseIntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static com.examination.project.utils.EntityFactory.EXAM_ID;
import static com.examination.project.utils.EntityFactory.STUDENT_ID;
import static com.examination.project.utils.ModelFactory.defaultStudent;
import static com.examination.project.utils.ModelFactory.defaultStudents2;
import static org.junit.jupiter.api.Assertions.*;

class StudentUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_student() {

        //given
        val expected = Student
                .builder()
                .studentId(1)
                .firstName("Alex")
                .lastName("Fergosen")
                .studyYear(2023)
                .identificationId(15698)
                .birthDay(Instant.parse("2024-07-15T17:34:43.257072800Z"))
                .classe(Classe.classeA)
                .build();

        //when
        val result = this.studentUseCase.createStudent(defaultStudent());

        //then
        assertAll("create new student",
                () -> assertTrue(result.isRight()),
                () -> assertNotNull(result.get()),
                () -> assertEquals(result.get(), expected)
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
        val result = this.studentUseCase.addOrUpdateStudentToExam(EXAM_ID, STUDENT_ID);

        //then
        assertTrue(result.isRight());
    }

    @Test
    void should_fetch_exams_assigned_to_specific_student() {

        //when
        val result = this.studentUseCase.fetchExamsAssignedToSpecificStudent(STUDENT_ID);

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
        val result = this.studentUseCase.deleteStudent(EXAM_ID, STUDENT_ID);

        //then
        assertTrue(result.isRight());
    }
}
