package com.gympass.speedland.utils;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Objects;

public class TimesUtils {

    public static final String LOCAL_TIME_MINUTE_PATTERN = "H:m:ss.SSS";

    private static final String CONCATENATE_HOUR = "0:";

    public static LocalTime convertStringToLocalTime(String time) {
        if(isEmpty(time)) {
            return null;
        }
        return LocalTime.parse(time, DateTimeFormatter.ISO_TIME);
    }

    public static LocalTime convertMinuteToLocalTime(String timeMinute) {
        if(isEmpty(timeMinute)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOCAL_TIME_MINUTE_PATTERN);
        String lapTimeFormatted = CONCATENATE_HOUR + timeMinute;
        return LocalTime.parse(lapTimeFormatted, formatter);
    }

    public static LocalTime minus(LocalTime l1, LocalTime l2) {
        if(isNull(l1) || isNull(l2)) {
            return null;
        }
        return l1.minus(Duration.ofMillis(l2.getLong(ChronoField.MILLI_OF_DAY)));
    }

}
