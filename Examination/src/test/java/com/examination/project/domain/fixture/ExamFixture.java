package com.examination.project.domain.fixture;


import com.examination.project.domain.entities.Exam;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamFixture {

    private static final Faker FAKER = new Faker();

    public static Exam one() {
        return from(1).get(0);
    }

    public static List<Exam> from(final int nbExam) {

        return Stream.range(0, nbExam)
                .map(i -> generateExam())
                .toList();
    }

    private static Exam generateExam() {

        var lorem = FAKER.lorem();
        var random = FAKER.random();

        var examDate = FAKER.date().birthday().toLocalDateTime();

        return Exam.builder()
                .name(lorem.characters(1, 20))
                .dateExam(examDate)
                .invigilator(InvigilatorFixture.one())
                .room(RoomFixture.one())
                .subject(SubjectFixture.one())
                .build();
    }

}
