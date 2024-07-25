package com.examination.project.utils;


import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.SubjectModule;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import com.examination.project.infrastructure.persistance.student.entities.StudentEntity;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.Instant;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class EntityFactory {

    public static final Integer EXAM_ID = 1;
    public static final Integer STUDENT_ID = 1;
    public static final Integer SUBJECT_ID = 1;
    public static final Integer COEFFICIENT_ID = 164;
    public static final String SUBJECT_TITLE = "Physics";
    public static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.parse("2024-07-16T17:50:50.024437100");
    public static final Integer ROOM_ID = 1;

    public static StudentEntity defaultStudentEntity() {
        return StudentEntity
                .builder()
                .studentId(1)
                .firstName("Alex")
                .lastName("Fergosen")
                .studyYear(2023)
                .identificationId(15698)
                .birthDay(Instant.parse("2024-07-15T17:34:43.257072800Z"))
                .classe(Classe.classeA)
                .build();
    }

    public static Set<StudentEntity> defaultStudentEntities() {
        return List.of(defaultStudentEntity(),
                        defaultStudentEntity().toBuilder().studentId(2).build()
                )
                .toLinkedSet();
    }

    public static Set<StudentEntity> defaultStudentEntities2() {
        return List.of(defaultStudentEntity()
                                .toBuilder()
                                .classe(Classe.classeB)
                                .build(),
                        defaultStudentEntity().toBuilder()
                                .studentId(2)
                                .classe(Classe.classeB)
                                .build(),
                        defaultStudentEntity().toBuilder()
                                .classe(Classe.classeB)
                                .studentId(3)
                                .build()
                )
                .toLinkedSet();
    }

    public static InvigilatorEntity defaultInvigilatorEntity() {
        return InvigilatorEntity.builder()
                .invigilatorId(1)
                .firstName("Mohsen")
                .lastName("David")
                .identificationNumber(123454)
                .build();
    }

    public static List<InvigilatorEntity> defaultInvigilatorEntityList() {
        return List.of(defaultInvigilatorEntity());
    }

    public static List<RoomEntity> defaultRoomEntities() {
        return List.of(defaultRoomEntity(),
                defaultRoomEntity()
                        .toBuilder()
                        .roomId(2)
                        .build(),
                defaultRoomEntity()
                        .toBuilder()
                        .roomId(3)
                        .build());
    }

    public static RoomEntity defaultRoomEntity() {
        return RoomEntity.builder()
                .roomId(1)
                .department("main")
                .floor(3)
                .number(1254)
                .build();
    }

    public static SubjectEntity defaultSubjectEntity() {
        return SubjectEntity.builder()
                .subjectId(1)
                .title("Physics")
                .subjectModule(SubjectModule.MODULE_2)
                .coefficient(164)
                .build();
    }

    public static List<SubjectEntity> defaultSubjectEntities() {
        return List.of(defaultSubjectEntity().toBuilder()
                        .subjectId(2)
                        .coefficient(200)
                        .build(),
                defaultSubjectEntity().toBuilder()
                        .subjectId(4)
                        .coefficient(180)
                        .build(),
                defaultSubjectEntity().toBuilder()
                        .subjectId(8)
                        .coefficient(166)
                        .build()
        );
    }

    public static List<SubjectEntity> defaultSubjectEntities2() {
        return List.of(defaultSubjectEntity().toBuilder()
                        .subjectId(2)
                        .build(),
                defaultSubjectEntity().toBuilder()
                        .subjectId(3)
                        .build()
        );
    }


    public static List<SubjectEntity> defaultSubjectEntitiesQueryDsl() {
        return List.of(defaultSubjectEntity().toBuilder()
                        .subjectId(2)
                        .title("Chemistry")
                        .coefficient(200)
                        .subjectModule(SubjectModule.MODULE_2)
                        .build(),
                defaultSubjectEntity().toBuilder()
                        .subjectId(10)
                        .title("Chemistry")
                        .coefficient(500)
                        .subjectModule(SubjectModule.MODULE_2)
                        .build()
        );
    }

    public static List<SubjectEntity> defaultSubjectEntitiesQueryDsl2() {
        return List.of(defaultSubjectEntity().toBuilder()
                        .subjectId(2)
                        .title("Data_Science")
                        .subjectModule(SubjectModule.MODULE_3)
                        .build(),
                defaultSubjectEntity().toBuilder()
                        .subjectId(10)
                        .title("Data_Science")
                        .subjectModule(SubjectModule.MODULE_3)
                        .build()
        );
    }

    public static ExamEntity defaultExamEntity() {
        return ExamEntity.builder()
                .examId(EXAM_ID)
                .examName("examName")
                .examDate(Instant.parse("2024-07-15T17:34:43.257072800Z"))
                .subject(defaultSubjectEntity())
                .room(defaultRoomEntity())
                .invigilator(defaultInvigilatorEntity())
                .build();
    }

    public static List<ExamEntity> defaultExamEntities() {
        return List.of(defaultExamEntity(),
                defaultExamEntity().toBuilder().examId(2).build());
    }

    public static Page<ExamEntity> defaultPageExamEntities() {
        return new PageImpl<>(defaultExamEntities().asJava());
    }
}
