package com.cegefos.tp2;

import com.cegefos.tp2.entity.Examen;
import com.cegefos.tp2.repository.ExamenRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
 class ReadTestDemo {

    @Autowired
    private ExamenRepository examenRepository;


    @Test
    void ListAllExams() {
        Collection<Examen> examenList = (Collection<Examen>) examenRepository.findAll();
        examenList.stream().forEach(System.out::println);
    }


}
