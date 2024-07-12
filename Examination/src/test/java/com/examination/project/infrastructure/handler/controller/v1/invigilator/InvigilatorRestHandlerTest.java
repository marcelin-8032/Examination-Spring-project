package com.examination.project.infrastructure.handler.controller.v1.invigilator;

import com.examination.project.domain.entities.Invigilator;
import com.examination.project.domain.fixture.InvigilatorFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.examination.project.infrastructure.handler.utils.ModelFactory.defaultInvigilator;
import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class InvigilatorRestHandlerTest extends IntegrationTest {

    @Test
    void should_add_new_Invigilator() {

        given(this.invigilatorUseCaseMocked.createInvigilator(any(Invigilator.class)))
                .willAnswer((invocationOnMock -> Either.right(invocationOnMock.getArgument(0))));

        val resultActions = this.invigilatorRestHandlerFixture.createInvigilator();

        verify(invigilatorUseCaseMocked, atLeastOnce()).createInvigilator(defaultInvigilator());
        assertEquals(resultActions.andReturn().getResponse().getStatus(), 201);

    }

    @Test
    void should_return_all_invigilators() {

        //given
        val invigilatorList = InvigilatorFixture.from(10);

        //when
        when(this.invigilatorUseCaseMocked.findAllInvigilator()).thenReturn(right(invigilatorList.asJava()));

        val expected = this.invigilatorRestHandlerFixture.getAllInvigilators().with(mockMvc, objectMapper);

        //then
        assertEquals(expected.asJava().size(), invigilatorList.asJava().size());
        assertEquals(expected, invigilatorList);
    }

    @Test
    void should_delete_invigilator_byId() {

        //when
        when(this.invigilatorUseCaseMocked.deleteInvigilatorById(1)).thenReturn(Either.right(null));

        val resultActions = this.invigilatorRestHandlerFixture.deleteInvigilatorById();

        //then
        verify(invigilatorUseCaseMocked, atMostOnce()).deleteInvigilatorById(1);
        assertEquals(resultActions.getResponse().getStatus(), 204);
    }

    @Test
    void should_delete_all_invigilators() {

        //when
        when(this.invigilatorUseCaseMocked.deleteAllInvigilators()).thenReturn(Either.right(null));

        var resultActions = this.invigilatorRestHandlerFixture.deleteAllInvigilator();

        //then
        verify(invigilatorUseCaseMocked, atMostOnce()).deleteAllInvigilators();
        assertEquals(resultActions.getResponse().getStatus(), 204);
    }
}
