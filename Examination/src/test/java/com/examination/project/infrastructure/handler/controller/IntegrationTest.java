package com.examination.project.infrastructure.handler.controller;

import com.examination.project.domain.exception.GlobalExceptionHandler;
import com.examination.project.domain.usecases.v1.exam.ExamUseCase;
import com.examination.project.domain.usecases.v1.invigilator.InvigilatorUseCase;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import com.examination.project.domain.usecases.v1.student.StudentUseCase;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import com.examination.project.infrastructure.config.web.ObjectMapperConfiguration;
import com.examination.project.infrastructure.handler.controller.v1.exam.ExamHandler;
import com.examination.project.infrastructure.handler.controller.v1.exam.ExamRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.exam.fixture.ExamRestHandlerFixture;
import com.examination.project.infrastructure.handler.controller.v1.invigilator.InvigilatorHandler;
import com.examination.project.infrastructure.handler.controller.v1.invigilator.InvigilatorRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.invigilator.fixture.InvigilatorRestHandlerFixture;
import com.examination.project.infrastructure.handler.controller.v1.room.RoomHandler;
import com.examination.project.infrastructure.handler.controller.v1.room.RoomRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.room.fixture.RoomRestHandlerFixture;
import com.examination.project.infrastructure.handler.controller.v1.student.StudentHandler;
import com.examination.project.infrastructure.handler.controller.v1.student.StudentRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.student.fixture.StudentRestHandlerFixture;
import com.examination.project.infrastructure.handler.controller.v1.subject.SubjectHandler;
import com.examination.project.infrastructure.handler.controller.v1.subject.SubjectRestHandler;
import com.examination.project.infrastructure.handler.controller.v1.subject.fixture.SubjectRestHandlerFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class IntegrationTest {

    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper;

    protected ExamRestHandlerFixture examRestHandlerFixture;

    protected InvigilatorRestHandlerFixture invigilatorRestHandlerFixture;

    protected RoomRestHandlerFixture roomRestHandlerFixture;

    protected StudentRestHandlerFixture studentRestHandlerFixture;

    protected SubjectRestHandlerFixture subjectRestHandlerFixture;

    protected ExamUseCase examUseCaseMocked = mock(ExamUseCase.class);

    protected InvigilatorUseCase invigilatorUseCaseMocked = mock(InvigilatorUseCase.class);

    protected RoomUseCase roomUseCaseMocked = mock(RoomUseCase.class);

    protected StudentUseCase studentUseCaseMocked = mock(StudentUseCase.class);

    protected SubjectUseCase subjectUseCaseMocked = mock(SubjectUseCase.class);

    protected ExamHandler examRestHandler = new ExamRestHandler(examUseCaseMocked);

    protected InvigilatorHandler invigilatorRestHandler = new InvigilatorRestHandler(invigilatorUseCaseMocked);

    protected RoomHandler roomRestHandler = new RoomRestHandler(roomUseCaseMocked);

    protected StudentHandler studentRestHandler = new StudentRestHandler(studentUseCaseMocked);

    protected SubjectHandler subjectRestHandler = new SubjectRestHandler(subjectUseCaseMocked);

    @BeforeEach
    public void setUp() {
        this.mockMvc = standaloneSetup(
                examRestHandler,
                invigilatorRestHandler,
                roomRestHandler,
                studentRestHandler,
                subjectRestHandler
        ).setControllerAdvice(new GlobalExceptionHandler())
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();

        this.objectMapper = new ObjectMapperConfiguration().objectMapper();

        this.examRestHandlerFixture = ExamRestHandlerFixture.from(this.mockMvc, this.objectMapper);
        this.invigilatorRestHandlerFixture = InvigilatorRestHandlerFixture.from(this.mockMvc, this.objectMapper);
        this.roomRestHandlerFixture = RoomRestHandlerFixture.from(this.mockMvc, this.objectMapper);
        this.studentRestHandlerFixture = StudentRestHandlerFixture.from(this.mockMvc, this.objectMapper);
        this.subjectRestHandlerFixture = SubjectRestHandlerFixture.from(this.mockMvc, this.objectMapper);
    }
}