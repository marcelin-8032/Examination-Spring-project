package com.examination.project.infrastructure.handler.controller.v1.subject;

import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class SubjectHandlerTest extends IntegrationTest {

    @Test
    void should_create_new_subject() {
        //GIVEN
     /*   var subject = SubjectFixture.one();

        //  var subjectArgumentCaptor = ArgumentCaptor.forClass(Subject.class);
        //WHEN
        when(this.subjectUseCaseMocked.createSubject(subject)).thenReturn(null);

       // var expectedSubject = SubjectRestHandlerFixture.createSubject();

                //.with(mockMvc, objectMapper);

        //THEN
        assertThat(this.subjectUseCaseMocked.createSubject(subject).isRight(), is(true));
       // assertThat(expectedSubject,is(subject));*/
    }


    @Test
    void should_return_all_subjects() {

      /*  //GIVEN
        var subjects = SubjectFixture.from(5);

        //WHEN
        when(this.subjectUseCaseMocked.getAllSubjects()).thenReturn(right(subjects.asJava()));

        var expected = SubjectRestHandlerFixture.getAllSubjects().with(mockMvc, objectMapper);

        assertThat(expected, is(subjects));*/
    }


    @Test
    void updateSubjectCoefficient() throws Exception {

    }

    @Test
    void getSubjectByCoeffBiggerThan() {

    }

    @Test
    void getSubjectByCoeffBiggerThanAndTitleDataAndModule() {

    }

    @Test
    void getSubjectByCoeffBiggerThanAndModule() {

    }

    @Test
    void getSubjectTitleDataAndModuleEq2() {

    }

    @Test
    void getSubjectByExample() {

    }

    @Test
    void getSubjectByExampleCoeffAndTitle() {

    }

    @Test
    void getSubjectByTitleWithIgnoreCase() {

    }
}
