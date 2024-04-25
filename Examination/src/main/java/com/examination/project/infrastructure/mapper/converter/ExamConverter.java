package com.examination.project.infrastructure.mapper.converter;

import com.examination.project.domain.entities.Exam;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import lombok.val;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;

public class ExamConverter implements Converter<Exam, ExamEntity> {

    @Override
    public ExamEntity convert(Exam source) {

        val roomEntity = new RoomEntity();
        roomEntity.setRoomId(source.room().roomId());
        roomEntity.setNumber(source.room().number());
        roomEntity.setBuilding(source.room().building());
        roomEntity.setFloor(source.room().floor());

        val invigilatorEntity = new InvigilatorEntity();
        invigilatorEntity.setFirstName(source.invigilator().firstName());
        invigilatorEntity.setLastName(source.invigilator().lastName());
        invigilatorEntity.setIdentificationNumber(source.invigilator().identificationNumber());

        val subjectEntity = new SubjectEntity();
        subjectEntity.setTitle(source.subject().title());
        subjectEntity.setCoefficient(source.subject().coefficient());
        subjectEntity.setSubjectModule(source.subject().subjectModule());

        val examEntity = new ExamEntity();
        examEntity.setExamName(source.examName());
        examEntity.setExamDate(Instant.from(source.examDate()));
        examEntity.setCreateDate(Instant.now());
        examEntity.setRoom(roomEntity);
        examEntity.setInvigilator(invigilatorEntity);
        examEntity.setSubject(subjectEntity);

        return examEntity;
    }

}
