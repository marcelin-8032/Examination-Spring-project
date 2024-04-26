package com.examination.project.infrastructure.handler.controller;

import com.examination.project.domain.exception.GlobalExceptionHandler;
import com.examination.project.domain.usecases.v1.exam.ExamUseCase;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import com.examination.project.infrastructure.config.web.ObjectMapperConfiguration;
import com.examination.project.infrastructure.handler.controller.v1.exam.ExamRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.subject.SubjectRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.subject.fixture.SubjectRestHandlerFixture;
import com.examination.project.infrastructure.handler.controller.v1.exam.fixture.ExamRestHandlerFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public abstract class IntegrationTest {

    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper;

    protected SubjectRestHandlerFixture subjectRestHandlerFixture;

    protected ExamRestHandlerFixture examRestHandlerFixture;

    @Mock
    protected SubjectUseCase subjectUseCaseMocked;

    @InjectMocks
    protected SubjectRestHandler subjectRestHandler;

    @Mock
    protected ExamUseCase examUseCaseMocked;

    @InjectMocks
    protected ExamRestHandler examRestHandler;

    @BeforeEach
    public void setUp() {
        this.mockMvc = standaloneSetup(
                subjectRestHandler
        ).setControllerAdvice(new GlobalExceptionHandler())
                .build();

        this.objectMapper = new ObjectMapperConfiguration().objectMapper();

        this.subjectRestHandlerFixture = SubjectRestHandlerFixture.from(this.mockMvc, this.objectMapper);
        this.examRestHandlerFixture = ExamRestHandlerFixture.from(this.mockMvc, this.objectMapper);
    }
}
