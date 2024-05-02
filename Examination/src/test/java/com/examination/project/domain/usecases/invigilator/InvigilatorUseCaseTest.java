package com.examination.project.domain.usecases.invigilator;

import com.examination.project.domain.usecases.UseCaseIntegrationTest;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.examination.project.utils.ModelFactory.defaultInvigilator;
import static com.examination.project.utils.ModelFactory.defaultInvigilatorList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class InvigilatorUseCaseTest  extends UseCaseIntegrationTest {

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

}
