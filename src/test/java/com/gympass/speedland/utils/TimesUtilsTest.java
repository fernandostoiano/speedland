package com.gympass.speedland.utils;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import java.time.LocalTime;

public class TimesUtilsTest {

    @Test
    public void shouldTestConvertStringToLocalTime() {

        String timeString = "23:49:08.277";

        LocalTime result = TimesUtils.convertStringToLocalTime(timeString);

        assertThat(result.toString(), equalTo("23:49:08.277"));
    }

    @Test
    public void shouldTestNullOnConvertStringToLocalTime() {

        String timeString = null;

        LocalTime result = TimesUtils.convertStringToLocalTime(timeString);

        assertNull(result);
    }


    @Test
    public void shouldTestConvertMinuteToLocalTime() {
        String minuteTime = "1:55.555";

        LocalTime localTime = TimesUtils.convertMinuteToLocalTime(minuteTime);

        assertThat(localTime.toString(), equalTo("00:01:55.555"));
    }

    @Test
    public void shouldTestMinuteTimeIsEmpty() {
        String minuteTime = "";

        LocalTime localTime = TimesUtils.convertMinuteToLocalTime(minuteTime);

        assertNull(localTime);
    }

    @Test
    public void shouldTestMinuteTimeIsNull() {

        LocalTime localTime = TimesUtils.convertMinuteToLocalTime(null);

        assertNull(localTime);
    }

    @Test
    public void shouldTestObtainMinusTime() {
        LocalTime l1 = TimesUtils.convertStringToLocalTime("23:49:08.277");
        LocalTime l2 = TimesUtils.convertMinuteToLocalTime("1:02.852");

        LocalTime result = TimesUtils.minus(l1, l2);

        LocalTime compere = TimesUtils.convertStringToLocalTime("23:48:05.425");
        assertThat(result, equalTo(compere));
    }

    @Test
    public void shouldTestFirstElementNullOnObtainMinusTime() {
        LocalTime l1 = null;
        LocalTime l2 = TimesUtils.convertMinuteToLocalTime("1:02.852");

        LocalTime result = TimesUtils.minus(l1, l2);

        assertNull(result);
    }

    @Test
    public void shouldTestSecondElementNullOnObtainMinusTime() {
        LocalTime l1 = TimesUtils.convertStringToLocalTime("23:49:08.277");
        LocalTime l2 = null;

        LocalTime result = TimesUtils.minus(l1, l2);

        assertNull(result);
    }

}
