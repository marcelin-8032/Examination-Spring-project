package com.examination.project.infrastructure.handler.controller.v1.invigilator;

import com.examination.project.domain.fixture.InvigilatorFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;

import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InvigilatorRestHandlerTest extends IntegrationTest {

    @Test
    void should_add_new_Invigilator() {

        //given
        val invigilator = InvigilatorFixture.one();

        //when
        when(this.invigilatorUseCaseMocked.createInvigilator(invigilator)).thenReturn(right(invigilator));

        val expectedResponse = this.invigilatorRestHandlerFixture.createInvigilator().with(mockMvc, objectMapper);

        //then
        verify(invigilatorUseCaseMocked, atLeastOnce()).createInvigilator(invigilator);
        assertEquals(expectedResponse, isNotNull());
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

        //given
        val invigilator = InvigilatorFixture.one().withInvigilatorId(1);

        //when
        when(this.invigilatorUseCaseMocked.deleteInvigilatorById(invigilator.invigilatorId())).thenReturn(Either.right(null));

        //then
       val expected = this.invigilatorRestHandlerFixture.deleteInvigilatorById().with(mockMvc,objectMapper);

       verify(invigilatorUseCaseMocked, atMostOnce()).deleteInvigilatorById(1);
       assertEquals(expected,isNotNull());

    }


    @Test
    void should_delete_all_invigilators() {

        //when
        when(this.invigilatorUseCaseMocked.deleteAllInvigilators()).thenReturn(Either.right(null));

        //then
        val expected = this.invigilatorRestHandlerFixture.deleteAllInvigilator().with(mockMvc,objectMapper);

        verify(invigilatorUseCaseMocked, atMostOnce()).deleteAllInvigilators();
        assertEquals(expected,isNotNull());
    }

}
