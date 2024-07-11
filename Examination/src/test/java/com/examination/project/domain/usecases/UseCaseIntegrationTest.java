package com.examination.project.domain.usecases;

import com.examination.project.infrastructure.mapper.struct.InvigilatorMapper;
import com.examination.project.infrastructure.persistance.invigilator.repository.InvigilatorRepository;
import com.examination.project.infrastructure.usecaseImpl.v1.invigilator.InvigilatorUseCaseImpl;
import io.vavr.control.Either;
import org.junit.jupiter.api.BeforeEach;

import static com.examination.project.infrastructure.handler.utils.ModelFactory.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public abstract class UseCaseIntegrationTest {

/*
    protected ExamRepository examRepositoryMocked = mock(ExamRepository.class);

    protected RoomRepository roomRepositoryMocked = mock(RoomRepository.class);

    protected StudentRepository studentRepositoryMocked = mock(StudentRepository.class);

    protected ExamMapper examMapperMocked = mock(ExamMapper.class);

    protected StudentMapper studentMapperMocked = mock(StudentMapper.class);

    protected RoomMapper roomMapperMocked = mock(RoomMapper.class);

    protected SubjectRepository subjectRepositoryMocked = mock(SubjectRepository.class);

    protected SubjectMapper subjectMapperMocked = mock(SubjectMapper.class);

    @InjectMocks
    protected ExamUseCase examUseCase;

    @InjectMocks
    protected RoomUseCase roomUseCase;

    @InjectMocks
    protected StudentUseCase studentUseCase;

    @InjectMocks
    protected SubjectUseCase subjectUseCase;
*/

  /*  protected ExamUseCaseImpl examUseCase = new ExamUseCaseImpl(
            examRepositoryMocked,
            roomRepositoryMocked,
            studentRepositoryMocked,
            examMapperMocked,
            studentMapperMocked,
            roomMapperMocked
    );


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

    protected InvigilatorRepository invigilatorRepositoryMocked = mock(InvigilatorRepository.class);

    protected InvigilatorMapper invigilatorMapperMocked = mock(InvigilatorMapper.class);

    protected InvigilatorUseCaseImpl invigilatorUseCase = new InvigilatorUseCaseImpl(
            invigilatorRepositoryMocked,
            invigilatorMapperMocked);

    @BeforeEach
    void setUp() {
    /*    when(this.examMapperMocked.toExamEntities(any())).thenReturn(List.of(ExamEntity.builder().build()));
        when(this.examRepositoryMocked.save(any())).thenReturn(List.of(ExamEntity.builder().build()));
        when(this.examMapperMocked.toExams(any())).thenReturn(List.of(Exam.builder().build()));
*/
        when(this.invigilatorRepositoryMocked.save(any()))
                .thenReturn(defaultInvigilatorEntity());
        when(this.invigilatorMapperMocked.toInvigilator(defaultInvigilatorEntity()))
                .thenReturn(defaultInvigilator());

        when(this.invigilatorRepositoryMocked.findAll())
                .thenReturn(defaultInvigilatorEntityList());
        when(this.invigilatorMapperMocked.toInvigilators(defaultInvigilatorEntityList()))
                .thenReturn(defaultInvigilatorList());

        doNothing().when(this.invigilatorRepositoryMocked).deleteById(1);
        doNothing().when(this.invigilatorRepositoryMocked).deleteAll();

    }
}
