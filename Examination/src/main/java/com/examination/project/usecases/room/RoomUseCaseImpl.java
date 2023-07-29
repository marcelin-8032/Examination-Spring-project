package com.examination.project.usecases.room;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.mapper.ExamMapper;
import com.examination.project.mapper.RoomMapper;
import com.examination.project.handler.persistance.exam.repository.ExamRepository;
import com.examination.project.handler.persistance.room.repository.RoomRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoomUseCaseImpl implements RoomUseCase {

    private  RoomRepository roomRepository;

    private ExamRepository examRepository;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private  ExamMapper examMapper;

    @Override
    public void createRoom(Room room) {

        roomRepository.save(roomMapper.toRoomEntity(room));
    }

    @Override
    public void deleteAllRooms() {
        var examList = examMapper.toExams(examRepository.findAll());

        for (Exam exam : examList) {
            exam.withRoom(null);
            examRepository.save(examMapper.toExamEntity(exam));
        }

        roomRepository.deleteAll();

    }

    @Override
    public void updateRoom(Integer id, int numero) throws Exception {

        if (roomRepository.findById(id).isPresent()) {
            var oldRoomDto = roomMapper.toRoom(roomRepository.findById(id).get());
            oldRoomDto.withNumber(numero);

            roomRepository.save(roomMapper.toRoomEntity(oldRoomDto));
        } else {
            throw new Exception("there is a problem in updating salle number");
        }

    }

    @Override
    public void createTwoRooms(List<Room> rooms) {
        roomRepository.saveAll(roomMapper.toRoomEntities(rooms));
    }

}
