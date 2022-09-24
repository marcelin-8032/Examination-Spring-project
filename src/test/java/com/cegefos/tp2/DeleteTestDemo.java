package com.cegefos.tp2;

import com.cegefos.tp2.entity.Examen;
import com.cegefos.tp2.repository.ExamenRepository;
import com.cegefos.tp2.repository.SalleRepository;
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
    private SalleRepository salleRepository;

    @Autowired
    private ExamenRepository examenRepository;


    @Test
    void deleteAllSalles() {
        List<Examen> examenList = examenRepository.findAll();

        for (Examen examen : examenList) {
            examen.setSalle(null);
            examenRepository.save(examen);
        }

        salleRepository.deleteAll();
    }

}
