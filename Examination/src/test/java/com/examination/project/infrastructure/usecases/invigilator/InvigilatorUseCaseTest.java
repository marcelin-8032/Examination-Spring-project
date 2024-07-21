package com.examination.project.infrastructure.usecases.invigilator;

import com.examination.project.domain.entities.Invigilator;
import com.examination.project.infrastructure.usecases.UseCaseIntegrationTest;
import io.vavr.collection.List;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.examination.project.utils.EitherTools.nothing;
import static com.examination.project.utils.ModelFactory.defaultInvigilator;
import static org.junit.jupiter.api.Assertions.*;


class InvigilatorUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_invigilator() {

        //given
        val expected = Invigilator.builder()
                .invigilatorId(1)
                .firstName("Mohsen")
                .lastName("David")
                .identificationNumber(123454)
                .build();

        // when
        val result = this.invigilatorUseCase.createInvigilator(defaultInvigilator());

        //then
        assertAll("create new invigilator",
                () -> assertTrue(result.isRight()),
                () -> assertNotNull(result.get()),
                () -> assertEquals(result.get(), expected)
        );
    }

    @Test
    void should_find_all_invigilators() {

        //given
        val expected = List.of(Invigilator.builder()
                .invigilatorId(1)
                .firstName("Mohsen")
                .lastName("David")
                .identificationNumber(123454)
                .build());

        //when
        val result = this.invigilatorUseCase.findAllInvigilator();

        //then
        assertAll(
                "find all invigilator",
                () -> assertTrue(result.isRight()),
                () -> assertNotNull(result.get()),
                () -> assertEquals(result.get(), expected.asJava())
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
