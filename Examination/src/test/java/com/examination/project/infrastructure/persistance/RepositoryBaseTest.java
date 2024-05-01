package com.examination.project.infrastructure.persistance;


import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public abstract class RepositoryBaseTest {

    @Autowired
    protected TestEntityManager entityManager;

    @Autowired
    protected RoomRepository roomRepository;

    @BeforeEach
    void setUp() {
        // roomRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        //roomRepository.deleteAll();
    }
}

