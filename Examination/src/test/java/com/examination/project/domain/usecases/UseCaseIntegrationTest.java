package com.examination.project.domain.usecases;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.usecases.v1.exam.ExamUseCase;
import com.examination.project.domain.usecases.v1.invigilator.InvigilatorUseCase;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import com.examination.project.domain.usecases.v1.student.StudentUseCase;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import com.examination.project.infrastructure.mapper.struct.*;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import com.examination.project.infrastructure.persistance.exam.repository.ExamRepository;
import com.examination.project.infrastructure.persistance.invigilator.repository.InvigilatorRepository;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import com.examination.project.infrastructure.persistance.student.repository.StudentRepository;
import com.examination.project.infrastructure.persistance.subject.repository.SubjectRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public abstract class UseCaseIntegrationTest {

    protected ExamRepository examRepositoryMocked = mock(ExamRepository.class);

    protected RoomRepository roomRepositoryMocked = mock(RoomRepository.class);

    protected StudentRepository studentRepositoryMocked = mock(StudentRepository.class);

    protected ExamMapper examMapperMocked = mock(ExamMapper.class);

    protected StudentMapper studentMapperMocked = mock(StudentMapper.class);

    protected RoomMapper roomMapperMocked = mock(RoomMapper.class);

    protected InvigilatorRepository invigilatorRepositoryMocked = mock(InvigilatorRepository.class);

    protected InvigilatorMapper invigilatorMapperMocked = mock(InvigilatorMapper.class);

    protected SubjectRepository subjectRepositoryMocked = mock(SubjectRepository.class);

    protected SubjectMapper subjectMapperMocked = mock(SubjectMapper.class);

    @InjectMocks
    protected ExamUseCase examUseCase;

    @InjectMocks
    protected InvigilatorUseCase invigilatorUseCase;

    @InjectMocks
    protected RoomUseCase roomUseCase;

    @InjectMocks
    protected StudentUseCase studentUseCase;

    @InjectMocks
    protected SubjectUseCase subjectUseCase;

  /*  protected ExamUseCaseImpl examUseCase = new ExamUseCaseImpl(
            examRepositoryMocked,
            roomRepositoryMocked,
            studentRepositoryMocked,
            examMapperMocked,
            studentMapperMocked,
            roomMapperMocked
    );

    protected InvigilatorUseCaseImpl invigilatorUseCase = new InvigilatorUseCaseImpl(
            invigilatorRepositoryMocked,
            invigilatorMapperMocked);

    protected RoomUseCaseImpl roomUseCase = new RoomUseCaseImpl(
            roomRepositoryMocked,
            examRepositoryMocked,
            roomMapperMocked,
            examMapperMocked
    );

    protected StudentUseCaseImpl studentUseCase = new StudentUseCaseImpl(
            studentRepositoryMocked,
            examRepositoryMocked,
            studentMapperMocked,
            examMapperMocked
    );

    protected SubjectUseCaseImpl subjectUseCase = new SubjectUseCaseImpl(
            subjectRepositoryMocked,
            subjectMapperMocked
    );*/


    @BeforeEach
    void setUp() {
        when(this.examMapperMocked.toExamEntities(any())).thenReturn(List.of(ExamEntity.builder().build()));
        when(this.examRepositoryMocked.save(any())).thenReturn(List.of(ExamEntity.builder().build()));
        when(this.examMapperMocked.toExams(any())).thenReturn(List.of(Exam.builder().build()));
    }


    @AfterEach
    void tearDownEach() {

    }

    @AfterAll
    void tearDownAll() {

    }


}
