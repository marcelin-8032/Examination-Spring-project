package com.examination.project.utils.misc;


import io.vavr.control.Option;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import static java.time.ZoneOffset.UTC;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DateUtils {

    public static class toOffSetDateTime {

        public static OffsetDateTime convertTo(LocalDateTime dateToConvert) {

            return Option.of(dateToConvert)
                    .map(d -> OffsetDateTime.of(d, UTC))
                    .getOrNull();
        }

        public static OffsetDateTime convertTo(Date dateToConvert) {

            return Option.of(dateToConvert)
                    .map(d -> d.toInstant().atZone(ZoneId.systemDefault()).toOffsetDateTime())
                    .getOrNull();
        }

    }

    public static class toLocalDateTime {

        public static LocalDateTime convertTo(Date dateToConvert) {

            return Option.of(dateToConvert)
                    .map(d -> d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                    .getOrNull();
        }

        public static LocalDateTime convertTo(OffsetDateTime dateToConvert) {

            return Option.of(dateToConvert)
                    .map(d -> d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                    .getOrNull();
        }
    }


    public static class toDate {

        public static Date convertTo(LocalDateTime dateToConvert) {

            return Option.of(dateToConvert)
                    .map(d->d.atZone(ZoneId.systemDefault()).toInstant())
                    .map(Date::from)
                    .getOrNull();
        }

    }
}
