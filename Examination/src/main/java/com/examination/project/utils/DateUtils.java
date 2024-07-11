package com.examination.project.utils;


import io.vavr.control.Option;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import static java.time.ZoneOffset.UTC;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DateUtils {

    public static class toLocalDateTime {

        public static LocalDateTime convertTo(Instant instantToConvert) {

            return Option.of(instantToConvert)
                    .map(d -> LocalDateTime.ofInstant(d, UTC))
                    .getOrNull();
        }
    }

    public static class toInstant {

        public static Instant convertTo(LocalDateTime localDateTimeToConvert) {
            return Option.of(localDateTimeToConvert)
                    .map(d -> d.toInstant(UTC))
                    .getOrNull();
        }
    }
}
