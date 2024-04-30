package com.examination.project.infrastructure.handler.controller.v1.invigilator;

import com.examination.project.domain.fixture.InvigilatorFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InvigilatorRestHandlerTest extends IntegrationTest {

    @Test
    void should_add_new_Invigilator() {

        //given

        val invigilator = InvigilatorFixture.one();

        //when
        when(this.invigilatorUseCaseMocked.createInvigilator(invigilator)).thenReturn(Either.right(invigilator));

        val expected = this.invigilatorRestHandler.createAnInvigilator(invigilator);

       //then
        verify(invigilatorUseCaseMocked, atLeastOnce()).createInvigilator(invigilator);
        assertEquals(expected, new ResponseEntity<>(HttpStatus.CREATED));
    }

    @Test
    void should_return_all_invigilators() {

        //given
        val invigilatorList = InvigilatorFixture.from(10);

        //when
        when(this.invigilatorUseCaseMocked.findAllInvigilator()).thenReturn(Either.right(invigilatorList.asJava()));

        val expected = this.invigilatorRestHandlerFixture.getAllInvigilators();

        //then
        assertEquals(expected.asJava().size(), invigilatorList.asJava().size());
        assertEquals(expected, invigilatorList);
    }

}
