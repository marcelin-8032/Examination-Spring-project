package com.examination.project.domain.fixture;


import com.examination.project.domain.entities.Room;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RoomFixture {

    private static final Faker FAKER = new Faker();

    public static Room one() {

        return from(1).get(0);
    }

    public static List<Room> from(final int nbRoom) {

        return Stream.range(0, nbRoom)
                .map(i -> generateRoom()).toList();
    }

    private static Room generateRoom() {

        var random = FAKER.random();

        return Room.builder()
                .roomId(random.nextInt())
                .number(random.nextInt(100,150))
                .build();
    }

}
