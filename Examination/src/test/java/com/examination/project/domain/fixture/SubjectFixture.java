package com.examination.project.domain.fixture;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.entities.SubjectModule;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SubjectFixture {

    private static final Faker FAKER = new Faker();

    public static Subject one() {

        return from(1).get(0);
    }

    public static List<Subject> from(final int nbInv) {

        return Stream.range(0, nbInv)
                .map(i -> generateSubject()).toList();
    }

    private static Subject generateSubject() {

        var lorem = FAKER.lorem();
        var random = FAKER.random();

        return Subject.builder()
                .subjectId(random.nextInt())
                .coefficient(random.nextInt(100,200))
                .title(lorem.characters(1,20))
               .subjectModule(SubjectModule.MODULE_1)
                .build();
    }
}
