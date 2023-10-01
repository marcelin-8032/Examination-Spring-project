package com.examination;


import com.examination.project.domain.utils.UUIDGenerator;
import com.examination.project.infrastructure.persistance.common.readonly.ReadOnlyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(
        basePackages = "com.cegefos.tp1",
        excludeFilters = @ComponentScan.Filter(ReadOnlyRepository.class),
        entityManagerFactoryRef = "entityManagerFactory"
)
@SpringBootApplication
public class ExamApplication {


	UUIDGenerator uuidGenerator;
	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}
}
