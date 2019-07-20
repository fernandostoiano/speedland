package com.gympass.speedland.utils;

import static org.springframework.util.StringUtils.isEmpty;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimesUtils {

    public static final String LOCAL_TIME_MINUTE_PATTERN = "H:m:ss.SSS";

    private static final String CONCATENATE_HOUR = "0:";

    public static LocalTime convertMinuteToLocalTime(String timeMinute) {
        if(isEmpty(timeMinute)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOCAL_TIME_MINUTE_PATTERN);
        String lapTimeFormatted = CONCATENATE_HOUR + timeMinute;
        return LocalTime.parse(lapTimeFormatted, formatter);
    }

}
