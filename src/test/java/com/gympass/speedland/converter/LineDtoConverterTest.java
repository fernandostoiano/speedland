package com.gympass.speedland.converter;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.utils.TimesUtils;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LineDtoConverterTest {

    private LineDtoConverter spy;

    @Before
    public void setUp() {
        spy = new LineDtoConverter();
    }

    @Test
    public void mustConvertLineToDto() {

        String line = "23:49:08.277      038 – F.MASSA                           1     1:02.852                        44,275";

        LineDto lineDto = spy.apply(line);

        assertThat(lineDto.getTime(), equalTo(LocalTime.parse("23:49:08.277", DateTimeFormatter.ISO_TIME)));
        assertThat(lineDto.getPilotCode(), equalTo(38));
        assertThat(lineDto.getPilotName(), equalTo("F.MASSA"));
        assertThat(lineDto.getLap(), equalTo(1));
        assertThat(lineDto.getLapTime(), equalTo(TimesUtils.convertMinuteToLocalTime("1:02.852")));
        assertThat(lineDto.getAverageSpeed(), equalTo(Double.parseDouble("44.275")));
    }

    @Test
    public void mustValidateLineIsEmpty() {

        String line = "";

        LineDto lineDto = spy.apply(line);

        assertNull(lineDto);
    }

    @Test
    public void mustValidateLineIsNull() {

        LineDto lineDto = spy.apply(null);

        assertNull(lineDto);
    }

    @Test
    public void mustValidateLineLength() {

        String line = "23:49:08.277      038 – F.MASSA                      ";

        LineDto lineDto = spy.apply(line);

        assertNull(lineDto);
    }

}
