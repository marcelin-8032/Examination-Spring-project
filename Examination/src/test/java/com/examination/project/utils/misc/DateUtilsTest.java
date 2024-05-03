package com.examination.project.utils.misc;

import lombok.val;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateUtilsTest {

    @Nested
    class toOffSetDateTimeTest {

        @Test
        void testConvertToOffsetDateTimeFromLocalDateTime() {

            val expected = DateUtils.toOffSetDateTime.convertTo(LocalDateTime.now());

            assertNotNull(expected);
            assertEquals(expected.getHour(), OffsetDateTime.now().getHour());
            assertEquals(expected.getMinute(), OffsetDateTime.now().getMinute());
        }

        @Test
        void testConvertToOffsetDateTimeFromDate() {

            val expected = DateUtils.toOffSetDateTime.convertTo(new Date());

            assertNotNull(expected);
            assertEquals(expected.getHour(), OffsetDateTime.now().getHour());
            assertEquals(expected.getMinute(), OffsetDateTime.now().getMinute());

        }
    }

    @Nested
    class toLocalDateTime {

        @Test
        void testConvertToLocalDateTimeFromDate() {

            val expected = DateUtils.toLocalDateTime.convertTo(new Date());

            assertNotNull(expected);
            assertEquals(expected.getHour(), LocalDateTime.now().getHour());
            assertEquals(expected.getMinute(), LocalDateTime.now().getMinute());
        }

        @Test
        void testConvertToLocalDateTimeFromOffSetDateTime() {

            val expected = DateUtils.toLocalDateTime.convertTo(OffsetDateTime.now());

            assertNotNull(expected);
            assertEquals(expected.getHour(), LocalDateTime.now().getHour());
            assertEquals(expected.getMinute(), LocalDateTime.now().getMinute());
        }

        @Test
        void testConvertToLocalDateTimeFromInstant() {

            val expected = DateUtils.toLocalDateTime.convertTo(Instant.now());

            assertNotNull(expected);
            assertEquals(expected.getYear(), LocalDateTime.now().getYear());
            assertEquals(expected.getMinute(), LocalDateTime.now().getMinute());
        }
    }

    @Nested
    class toDate {

        @Test
        void convertToDateFromLocalDateTime() {

            val expected = DateUtils.toDate.convertTo(LocalDateTime.now());

            assertNotNull(expected);
            assertEquals(expected.getYear(), new Date().getYear());
            assertEquals(expected.getHours(), new Date().getHours());
        }
    }

    @Nested
    class toInstant {

        @Test
        void convertToInstantFromLocalDateTime() {

            val expected = DateUtils.toInstant.convertTo(LocalDateTime.now());

            assertNotNull(expected);
            assertEquals(expected.atZone(ZoneId.systemDefault()).getYear(), Instant.now().atZone(ZoneId.systemDefault()).getYear());
            assertEquals(expected.atZone(ZoneId.systemDefault()).getMonth(), Instant.now().atZone(ZoneId.systemDefault()).getMonth());
        }
    }
}



