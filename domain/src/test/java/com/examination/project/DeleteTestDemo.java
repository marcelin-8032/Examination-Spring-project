package com.examination.project;

import com.examination.project.handler.persistance.exam.entities.ExamEntity;
import com.examination.project.handler.persistance.exam.repository.ExamRepository;
import com.examination.project.handler.persistance.room.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DeleteTestDemo {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ExamRepository examRepository;


    @Test
    void deleteAllSalles() {
        List<ExamEntity> examEntityList = examRepository.findAll();

        for (ExamEntity examEntity : examEntityList) {
            examEntity.setRoomEntity(null);
            examRepository.save(examEntity);
        }

        roomRepository.deleteAll();
    }

}
