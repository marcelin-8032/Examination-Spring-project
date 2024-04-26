package com.examination.project.infrastructure.handler.controller.v1.exam;

import com.examination.project.domain.fixture.ExamFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

class ExamRestHandlerTest extends IntegrationTest {

    @Test
    void should_return_all_exams() {
        //given
        val exams = ExamFixture.from(10);

        //when

        when(this.examUseCaseMocked.getAllExams()).thenReturn(Either.right(exams.asJava()));

        var expected=this.examRestHandlerFixture.getAllExams();

        assertThat(expected,isNotNull());

    }
}
