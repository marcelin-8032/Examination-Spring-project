package com.examination.project.infrastructure.handler.controller.v1.subject;

import com.examination.project.domain.fixture.SubjectFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.vavr.control.Either.right;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SubjectHandlerTest extends IntegrationTest {

    @Test
    void should_create_new_subject() {

        //GIVEN
        var subject = SubjectFixture.one();

        //WHEN
        when(this.subjectUseCaseMocked.createSubject(subject)).thenReturn(null);

        //THEN

       // verify(this.subjectRestHandlerFixture.createSubject(), times(1)).createSubject();
    }


    @Test
    void should_return_all_subjects() {

        //GIVEN
        var subjects = SubjectFixture.from(5);

        //WHEN
        when(this.subjectUseCaseMocked.getAllSubjects()).thenReturn(right(subjects.asJava()));

        var expected = this.subjectRestHandlerFixture.getAllSubjects();

        assertThat(expected, is(subjects));
    }

}
