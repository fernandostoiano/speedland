package com.gympass.speedland.utils;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import java.time.LocalTime;

public class TimesUtilsTest {

    @Test
    public void mustConvertMinuteToLocalTime() {
        String minuteTime = "1:55.555";

        LocalTime localTime = TimesUtils.convertMinuteToLocalTime(minuteTime);

        assertThat(localTime.toString(), equalTo("00:01:55.555"));
    }

    @Test
    public void mustValidateMinuteTimeIsEmpty() {
        String minuteTime = "";

        LocalTime localTime = TimesUtils.convertMinuteToLocalTime(minuteTime);

        assertNull(localTime);
    }

    @Test
    public void mustValidateMinuteTimeIsNull() {

        LocalTime localTime = TimesUtils.convertMinuteToLocalTime(null);

        assertNull(localTime);
    }

}
