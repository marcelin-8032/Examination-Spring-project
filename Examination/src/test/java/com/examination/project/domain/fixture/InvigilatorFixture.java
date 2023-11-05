package com.examination.project.domain.fixture;

import com.examination.project.domain.entities.Invigilator;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class InvigilatorFixture {

    private static final Faker FAKER = new Faker();


    public static Invigilator one() {

        return from(1).get(0);
    }


    public static List<Invigilator> from(final int nbInv) {

        return Stream.range(0, nbInv)
                .map(i -> generateInvigilator()).toList();
    }

    private static Invigilator generateInvigilator() {

        var lorem = FAKER.lorem();
        var random = FAKER.random();

        return Invigilator.builder()
                .invigilatorId(random.nextInt())
                .name(lorem.characters(1,20))
                .exams(List.of(ExamFixture.one(),ExamFixture.one()).toSet())
                .build();
    }

}
