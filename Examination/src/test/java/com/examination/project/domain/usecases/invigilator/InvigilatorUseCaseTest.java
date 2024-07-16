package com.examination.project.domain.usecases.invigilator;

import com.examination.project.domain.usecases.UseCaseIntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;


import static com.examination.project.utils.EitherTools.nothing;
import static com.examination.project.utils.ModelFactory.*;
import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.*;


class InvigilatorUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_invigilator() {

        // when
        val expected = this.invigilatorUseCase.createInvigilator(defaultInvigilator());

        //then
        assertNotNull(expected.get());
        assertEquals(expected, right(defaultInvigilator()));
    }

    @Test
    void should_find_all_invigilators() {

        //when
        val expected = this.invigilatorUseCase.findAllInvigilator();

        //then
        assertAll(
                "find all inviglilator",
                () -> assertTrue(expected.isRight()),
                () -> assertNotNull(expected.get()),
                () -> assertEquals(expected, right(defaultInvigilatorList()))
        );
    }

    @Test
    void should_delete_invigilator_by_id() {

        //when
        val expected = this.invigilatorUseCase.deleteInvigilatorById(1);

        //then
        assertEquals(expected, nothing());
    }

    @Test
    void should_delete_all_invigilators() {

        //when
        val expected = this.invigilatorUseCase.deleteAllInvigilators();

        //then
        assertEquals(expected, nothing());
    }
}
