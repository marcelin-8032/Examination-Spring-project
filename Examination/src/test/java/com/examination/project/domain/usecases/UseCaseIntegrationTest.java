package com.examination.project.domain.usecases;

import com.examination.project.domain.entities.*;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.domain.usecases.v1.exam.ExamUseCase;
import com.examination.project.domain.usecases.v1.invigilator.InvigilatorUseCase;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import com.examination.project.domain.usecases.v1.student.StudentUseCase;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import com.examination.project.infrastructure.mapper.struct.*;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import com.examination.project.infrastructure.persistance.exam.repository.ExamRepository;
import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.infrastructure.persistance.invigilator.repository.InvigilatorRepository;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import com.examination.project.infrastructure.persistance.student.entities.StudentEntity;
import com.examination.project.infrastructure.persistance.student.repository.StudentRepository;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import com.examination.project.infrastructure.persistance.subject.repository.SubjectRepository;
import com.examination.project.infrastructure.usecaseImpl.v1.exam.ExamUseCaseImpl;
import com.examination.project.infrastructure.usecaseImpl.v1.invigilator.InvigilatorUseCaseImpl;
import com.examination.project.infrastructure.usecaseImpl.v1.room.RoomUseCaseImpl;
import com.examination.project.infrastructure.usecaseImpl.v1.student.StudentUseCaseImpl;
import com.examination.project.infrastructure.usecaseImpl.v1.subject.SubjectUseCaseImpl;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

import static com.examination.project.utils.EntityFactory.*;
import static com.examination.project.utils.ModelFactory.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.data.domain.PageRequest.of;

@ExtendWith(MockitoExtension.class)
public abstract class UseCaseIntegrationTest {

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

    protected StudentRepository studentRepositoryMocked = mock(StudentRepository.class);

    protected StudentMapper studentMapperMocked = mock(StudentMapper.class);

    protected ExamRepository examRepositoryMocked = mock(ExamRepository.class);

    protected ExamMapper examMapperMocked = mock(ExamMapper.class);

    protected StudentUseCase studentUseCase = new StudentUseCaseImpl(
            studentRepositoryMocked,
            examRepositoryMocked,
            studentMapperMocked,
            examMapperMocked
    );

    protected SubjectRepository subjectRepositoryMocked = mock(SubjectRepository.class);

    protected SubjectMapper subjectMapperMocked = mock(SubjectMapper.class);

    protected SubjectUseCase subjectUseCase = new SubjectUseCaseImpl(
            subjectRepositoryMocked,
            subjectMapperMocked
    );

    protected ExamUseCase examUseCase = new ExamUseCaseImpl(
            examRepositoryMocked,
            roomRepositoryMocked,
            examMapperMocked,
            roomMapperMocked,
            jdbcTemplateMocked
    );

    @BeforeEach
    void setUp() {

        //Invigilator
        when(this.invigilatorMapperMocked.toInvigilatorEntity(any(Invigilator.class)))
                .thenReturn(defaultInvigilatorEntity());
        when(this.invigilatorRepositoryMocked.save(any(InvigilatorEntity.class)))
                .thenReturn(defaultInvigilatorEntity());
        when(this.invigilatorMapperMocked.toInvigilator(any(InvigilatorEntity.class)))
                .thenReturn(defaultInvigilator());
        when(this.invigilatorRepositoryMocked.findAll())
                .thenReturn(defaultInvigilatorEntityList().asJava());
        when(this.invigilatorMapperMocked.toInvigilators(anyCollection()))
                .thenReturn(defaultInvigilatorList().asJava());
        doNothing().when(this.invigilatorRepositoryMocked).deleteById(1);
        doNothing().when(this.invigilatorRepositoryMocked).deleteAll();

        //Room
        when(this.roomMapperMocked.toRoomEntity(any(Room.class))).thenReturn(defaultRoomEntity());
        when(this.roomMapperMocked.toRoom(defaultRoomEntity())).thenReturn(defaultRoom());
        when(this.roomMapperMocked.toRoomEntities(anyCollection())).thenReturn(defaultRoomEntities().asJava());
        when(this.roomRepositoryMocked.findById(anyInt())).thenReturn(Optional.of(defaultRoomEntity()));
        when(this.roomRepositoryMocked.save(any(RoomEntity.class))).thenReturn(defaultRoomEntity());
        when(this.roomRepositoryMocked.findAll()).thenReturn(defaultRoomEntities().asJava());
        when(this.roomMapperMocked.toRooms(anyCollection())).thenReturn(defaultRooms().asJava());
        doNothing().when(this.jdbcTemplateMocked).execute("delete from rooms");

        //Student
        when(this.studentMapperMocked.toStudentEntity(any(Student.class))).thenReturn(defaultStudentEntity());
        when(this.studentRepositoryMocked.save(any(StudentEntity.class))).thenReturn(defaultStudentEntity());
        when(this.studentMapperMocked.toStudent(any(StudentEntity.class))).thenReturn(defaultStudent());
        when(this.studentRepositoryMocked.findAll()).thenReturn(defaultStudentEntities().toJavaList());
        when(this.studentMapperMocked.toStudents(anyCollection())).thenReturn(defaultStudents().toJavaList());
        when(this.studentRepositoryMocked.findStudentsByClasse(any())).thenReturn(defaultStudentEntities2().toJavaList());
        when(this.studentMapperMocked.toStudents(anyCollection())).thenReturn(defaultStudents2().toJavaList());
        when(this.examRepositoryMocked.findById(EXAM_ID)).thenReturn(Optional.of(defaultExamEntity()));
        when(this.studentRepositoryMocked.findById(STUDENT_ID)).thenReturn(Optional.of(defaultStudentEntity()));
        when(this.examRepositoryMocked.findExamsByStudentId(STUDENT_ID)).thenReturn(defaultExamEntities().asJava());
        when(this.examMapperMocked.toExams(anyCollection())).thenReturn(defaultExams().toJavaList());
        when(this.studentRepositoryMocked.findById(STUDENT_ID)).thenReturn(Optional.of(defaultStudentEntity()));

        //Subject
        when(this.subjectMapperMocked.toSubjectEntity(any(Subject.class))).thenReturn(defaultSubjectEntity());
        when(this.subjectRepositoryMocked.save(any(SubjectEntity.class))).thenReturn(defaultSubjectEntity());
        when(this.subjectRepositoryMocked.findById(SUBJECT_ID)).thenReturn(Optional.of(defaultSubjectEntity()));
        when(this.subjectRepositoryMocked.findByCoefficientGreaterThan(COEFFICIENT_ID)).thenReturn(defaultSubjectEntities().asJava());
        when(this.subjectMapperMocked.toSubjects(anyCollection())).thenReturn(defaultSubjects().asJava());

        //Exam
        when(this.examMapperMocked.toExamEntities(anyCollection())).thenReturn(defaultExamEntities().asJava());
        when(this.examRepositoryMocked.save(any(ExamEntity.class))).thenReturn(defaultExamEntity());
        when(this.examMapperMocked.toExams(anyCollection())).thenReturn(defaultExams().toJavaList());
        when(this.examMapperMocked.toExamEntity(any(Exam.class))).thenReturn(defaultExamEntity());
        when(this.examMapperMocked.toExam(any(ExamEntity.class))).thenReturn(defaultExam());
        when(this.examRepositoryMocked.findAll()).thenReturn(defaultExamEntities().asJava());
        when(this.roomMapperMocked.optionToOptional(Option.of(any()))).thenReturn(Optional.of(defaultRoom()));
        when(this.roomRepositoryMocked.findById(anyInt())).thenReturn(Optional.of(defaultRoomEntity()));
        when(this.examRepositoryMocked.findByRoomAndExamDate(any(), any())).thenReturn(defaultExamEntities().asJava());
        when(this.examMapperMocked.toExams(anyCollection())).thenReturn(defaultExams().toJavaList());
        when(this.roomRepositoryMocked.findById(anyInt())).thenReturn(Optional.of(defaultRoomEntity()));
        when(this.roomMapperMocked.unwrapReferenceToOptionalRoom(any())).thenReturn(Optional.of(defaultRoomEntity()));
        when(this.examRepositoryMocked.findByRoomAndExamDateGreaterThan(any(),any())).thenReturn(defaultExamEntities().asJava());
        when(this.examMapperMocked.toExams(anyCollection())).thenReturn(defaultExams().toJavaList());
        when(this.roomMapperMocked.toRoomEntity(any())).thenReturn(defaultRoomEntity());
        when(this.examRepositoryMocked.findByRoomOrderByExamDateDesc(any())).thenReturn(defaultExamEntities().asJava());
        when(this.examMapperMocked.toExams(anyCollection())).thenReturn(defaultExams().toJavaList());
        when(this.roomMapperMocked.toRoomEntity(any())).thenReturn(defaultRoomEntity());
        when(this.examRepositoryMocked.findByRoomOrderByExamDateDesc(any())).thenReturn(defaultExamEntities().asJava());
        when(this.examMapperMocked.toExams(anyCollection())).thenReturn(defaultExams().toJavaList());

        doNothing().when(this.jdbcTemplateMocked).execute("delete from students_exams");
        doNothing().when(this.jdbcTemplateMocked).execute("delete from exams");
    }
}

