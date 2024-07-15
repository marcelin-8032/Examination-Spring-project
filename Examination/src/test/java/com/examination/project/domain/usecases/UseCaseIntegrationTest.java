package com.examination.project.domain.usecases;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.usecases.v1.invigilator.InvigilatorUseCase;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import com.examination.project.infrastructure.mapper.struct.InvigilatorMapper;
import com.examination.project.infrastructure.mapper.struct.RoomMapper;
import com.examination.project.infrastructure.persistance.invigilator.repository.InvigilatorRepository;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import com.examination.project.infrastructure.usecaseImpl.v1.invigilator.InvigilatorUseCaseImpl;
import com.examination.project.infrastructure.usecaseImpl.v1.room.RoomUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

import static com.examination.project.infrastructure.handler.utils.ModelFactory.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class UseCaseIntegrationTest {

/*
    protected ExamRepository examRepositoryMocked = mock(ExamRepository.class);

    protected StudentRepository studentRepositoryMocked = mock(StudentRepository.class);

    protected ExamMapper examMapperMocked = mock(ExamMapper.class);

    protected StudentMapper studentMapperMocked = mock(StudentMapper.class);

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

    protected InvigilatorUseCase invigilatorUseCase = new InvigilatorUseCaseImpl(
            invigilatorRepositoryMocked,
            invigilatorMapperMocked);

    protected RoomRepository roomRepositoryMocked = mock(RoomRepository.class);

    protected RoomMapper roomMapperMocked = mock(RoomMapper.class);

    protected JdbcTemplate jdbcTemplateMocked = mock(JdbcTemplate.class);

    protected RoomUseCase roomUseCase = new RoomUseCaseImpl(
            roomRepositoryMocked,
            roomMapperMocked,
            jdbcTemplateMocked
    );

    @BeforeEach
    void setUp() {

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

        when(this.roomMapperMocked.toRoomEntity(any(Room.class))).thenReturn(defaultRoomEntity());
        when(this.roomMapperMocked.toRoom(defaultRoomEntity())).thenReturn(defaultRoom());
        when(this.roomMapperMocked.toRoomEntities(anyCollection())).thenReturn(defaultRoomEntities().asJava());
        when(this.roomRepositoryMocked.findById(anyInt())).thenReturn(Optional.of(defaultRoomEntity()));
        when(this.roomRepositoryMocked.save(any(RoomEntity.class))).thenReturn(defaultRoomEntity());
        when(this.roomRepositoryMocked.findAll()).thenReturn(defaultRoomEntities().asJava());
        when(this.roomMapperMocked.toRooms(anyCollection())).thenReturn(defaultRooms().asJava());
        doNothing().when(this.jdbcTemplateMocked).execute("delete from rooms");
    }
}

