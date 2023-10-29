package com.examination.project.domain.usecases.v1.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.mapper.ExamMapper;
import com.examination.project.utils.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

class ExamUseCaseImplTest {
    private ExamUseCase examUseCase;
    private ExamMapper examMapper;


    @BeforeEach
    void setUp() {
        this.examUseCase = mock(ExamUseCase.class);
        this.examMapper = mock(ExamMapper.class);
    }


    @Test
    void createExams() {
      this.examUseCase.createExams((List<Exam>) ModelFactory.defaultExams());

    }

    @Test
    void getAllExams() {
    }

    @Test
    void getExamsByDate() {
    }

    @Test
    void getExamsAtRoomAndGivenDate() {
    }

    @Test
    void getExamsAtRoomAndAfterADate() {
    }

    @Test
    void getExamsAtRecentDateAtSpecificRoom() {
    }

    @Test
    void getAllExamsInPages() {
    }

    @Test
    void getAllExamsByRoom() {

    }
}