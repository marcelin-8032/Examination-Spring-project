package com.examination;

import com.examination.project.infrastructure.persistance.common.readonly.ReadOnlyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories (excludeFilters = @ComponentScan.Filter(ReadOnlyRepository.class))
public class ExamApplication {

    //UUIDGenerator uuidGenerator;
    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }
}
