package com.examination.project.domain.usecases.invigilator;

import com.examination.project.domain.usecases.UseCaseIntegrationTest;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.examination.project.infrastructure.handler.utils.ModelFactory.defaultInvigilator;
import static com.examination.project.infrastructure.handler.utils.ModelFactory.defaultInvigilatorList;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class InvigilatorUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_invigilator() {

        // when
        val expected = this.invigilatorUseCase.createInvigilator(defaultInvigilator());

        //then
        assertNotNull(expected.get());
        assertEquals(expected, Either.right(defaultInvigilator()));
    }

    @Test
    void should_find_all_invigilators() {
        //when
        val expected = this.invigilatorUseCase.findAllInvigilator();

        //then
        assertNotNull(expected.get());
        assertEquals(expected, Either.right(defaultInvigilatorList()));
    }

    @Test
    void should_delete_invigilator_by_id() {

        //when
        val expected = this.invigilatorUseCase.deleteInvigilatorById(1);

        //then
        assertNotNull(expected.isRight());
       // assertEquals(expected, is);
    }

    @Test
    void should_delete_all_invigilators() {
        //when
        val expected = this.invigilatorUseCase.deleteAllInvigilators();

        //then
        assertNotNull(expected.isRight());
      //  assertEquals(expected, Either.right(defaultInvigilatorList()));
    }

}
