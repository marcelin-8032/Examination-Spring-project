package com.examination.project.infrastructure.handler.controller.v1.subject;

import com.examination.project.domain.fixture.SubjectFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import com.examination.project.infrastructure.handler.controller.v1.subject.fixture.SubjectRestHandlerFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.examination.project.utils.EitherTools.nothing;
import static io.vavr.control.Either.right;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SubjectHandlerTest extends IntegrationTest {

    @Test
    void should_create_new_subject()  {
        //GIVEN
        var subject = SubjectFixture.one();

        //  var subjectArgumentCaptor = ArgumentCaptor.forClass(Subject.class);
        //WHEN
        when(this.subjectUseCaseMocked.createSubject(subject)).thenReturn(nothing());

        var expectedSubject = SubjectRestHandlerFixture.createSubject().with(mockMvc, objectMapper);

        //THEN
        assertThat(this.subjectUseCaseMocked.createSubject(subject).isRight(), is(true));
        assertThat(expectedSubject,is(subject));
    }


    @Test
    void should_return_all_subjects() {

        //GIVEN
        var subjects = SubjectFixture.from(5);

        //WHEN
        when(this.subjectUseCaseMocked.getAllSubjects()).thenReturn(right(subjects.asJava()));

        var expected = SubjectRestHandlerFixture.getAllSubjects().with(mockMvc, objectMapper);

        assertThat(expected, is(subjects));
    }

}
