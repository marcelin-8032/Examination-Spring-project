package com.examination.project.infrastructure.handler.controller;

import com.examination.project.domain.exception.GlobalExceptionHandler;
import com.examination.project.domain.usecases.v1.exam.ExamUseCase;
import com.examination.project.domain.usecases.v1.invigilator.InvigilatorUseCase;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import com.examination.project.infrastructure.config.web.ObjectMapperConfiguration;
import com.examination.project.infrastructure.handler.controller.v1.exam.ExamRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.exam.fixture.ExamRestHandlerFixture;
import com.examination.project.infrastructure.handler.controller.v1.invigilator.InvigilatorRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.invigilator.fixture.InvigilatorRestHandlerFixture;
import com.examination.project.infrastructure.handler.controller.v1.room.RoomRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.room.fixture.RoomRestHandlerFixture;
import com.examination.project.infrastructure.handler.controller.v1.subject.SubjectRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.subject.fixture.SubjectRestHandlerFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class IntegrationTest {

    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper;

    protected SubjectRestHandlerFixture subjectRestHandlerFixture;

    protected ExamRestHandlerFixture examRestHandlerFixture;

    protected InvigilatorRestHandlerFixture invigilatorRestHandlerFixture;


    protected RoomRestHandlerFixture roomRestHandlerFixture;

    @Mock
    protected SubjectUseCase subjectUseCaseMocked;

    @InjectMocks
    protected SubjectRestHandler subjectRestHandler;

    @Mock
    protected ExamUseCase examUseCaseMocked;

    @InjectMocks
    protected ExamRestHandler examRestHandler;

    @Mock
    protected InvigilatorUseCase invigilatorUseCaseMocked;

    @InjectMocks
    protected InvigilatorRestHandler invigilatorRestHandler;

    @Mock
    protected RoomUseCase roomUseCaseMocked;

    @InjectMocks
    protected RoomRestHandler roomRestHandler;

    @BeforeEach
    public void setUp() {
        this.mockMvc = standaloneSetup(
                examRestHandler,
                subjectRestHandler,
                invigilatorRestHandler,
                roomRestHandler
        ).setControllerAdvice(new GlobalExceptionHandler())
                .build();

        this.objectMapper = new ObjectMapperConfiguration().objectMapper();

        this.subjectRestHandlerFixture = SubjectRestHandlerFixture.from(this.mockMvc, this.objectMapper);
        this.examRestHandlerFixture = ExamRestHandlerFixture.from(this.mockMvc, this.objectMapper);
        this.invigilatorRestHandlerFixture = InvigilatorRestHandlerFixture.from(this.mockMvc, this.objectMapper);
        this.roomRestHandlerFixture = RoomRestHandlerFixture.from(this.mockMvc, this.objectMapper);

    }
}
