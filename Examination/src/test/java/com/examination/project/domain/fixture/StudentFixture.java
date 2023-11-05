package com.examination.project.domain.fixture;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Student;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import static com.examination.project.utils.EnumTools.randomEnum;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class StudentFixture {

    private static final Faker FAKER = new Faker();


    public static Student one() {

        return from(1).get(0);
    }

    public static List<Student> from(final int nbInv) {

        return Stream.range(0, nbInv)
                .map(i -> generateStudent()).toList();
    }

    private static Student generateStudent() {

        var lorem = FAKER.lorem();
        var random = FAKER.random();

        return Student.builder()
                .studentId(random.nextInt())
                .name(lorem.characters(1,20))
                .classe(Classe.valueOf(randomEnum(Classe.class).name()))
                .exams(List.of(ExamFixture.one(),ExamFixture.one()).toSet())
                .build();
    }

}
