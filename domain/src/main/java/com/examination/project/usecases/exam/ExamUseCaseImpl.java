package com.examination.project.usecases.exam;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.mapper.ExamMapper;
import com.examination.project.mapper.RoomMapper;
import com.examination.project.handler.persistance.exam.repository.ExamRepository;
import com.examination.project.handler.persistance.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamUseCaseImpl implements ExamUseCase {

    private final ExamRepository examRepository;

    private final RoomRepository roomRepository;

    private final ExamMapper  examMapper;

    private final RoomMapper roomMapper;

    @Override
    public void createExams(List<Exam> exams) {
        examRepository.saveAll(examMapper.toExamEntities(exams));
    }

    @Override
    public Collection<Exam> getAllExams() {
        return examMapper.toExams(examRepository.findAll());
    }

    @Override
    public Collection<Exam> getExamsByDate(Date date) {
        return examMapper.toExams(examRepository.findExamenByDateExam(date));
    }

    @Override
    public Collection<Exam> getExamAtRoomAndAfterADate(Room room, Date date) {
        Integer id = 0;
        var roomEntity = roomRepository.findById(id).get();
        return examMapper.toExams(examRepository.findBySalleAndDateExamGreaterThan(roomEntity, date));
    }

    @Override
    public Collection<Exam> getExamensAtRecentDataAtSpecificSalle(Room room) {
        return examMapper.toExams(
                examRepository.findTopBySalleOrderByDateExamDesc(
                        roomMapper.toRoomEntity(room)));
    }

    @Override
    public Page<Exam> getAllExamensInPages(Pageable pageable) {
        pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "examen_id");
      //  return examMapper.toExamPage(examRepository.findAllExamens(pageable));
        return  null;
    }

    @Override
    public Page<Exam> getAllExamensBySalle(Integer id, Pageable pageable) {
        pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "date_exam");
       // return examMapper.toExamPage(examRepository.findBysurveillant(id, pageable));
        return null;
    }


}
