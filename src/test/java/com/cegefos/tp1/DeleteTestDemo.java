package com.cegefos.tp1;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import com.cegefos.tp1.persistance.repository.ExamRepository;
import com.cegefos.tp1.persistance.repository.RoomRepository;
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
