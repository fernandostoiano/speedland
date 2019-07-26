package com.gympass.speedland.converter;

import com.gympass.speedland.BasicTest;
import com.gympass.speedland.controller.response.GrandPrixResponse;
import com.gympass.speedland.fixture.GrandPrixFixture;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.utils.TimesUtils;
import org.junit.Before;
import org.junit.Test;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class GrandPrixResponseConveterTest extends BasicTest {

    private GrandPrixResponseConveter converter;

    @Before
    public void before() {
        this.converter = new GrandPrixResponseConveter();
    }

    @Test
    public void shouldTestConvertGrandPrixToGrandPrixResponse() {

        GrandPrix grandPrix = from(GrandPrix.class).gimme(GrandPrixFixture.DEFAULT_GRAND_PRIX);

        GrandPrixResponse response = converter.apply(grandPrix);

        assertThat(response, notNullValue());
        assertThat(response.getDurationTime(), equalTo(TimesUtils.convertStringToLocalTime("00:16:50.480")));
        assertThat(response.getBetterLap(), notNullValue());
        assertThat(response.getBetterLap().getPilotCode(), equalTo(38));
        assertThat(response.getBetterLap().getPilotName(), equalTo("F.MASSA"));
        assertThat(response.getBetterLap().getLapNumber(), equalTo(1));
        assertThat(response.getPilots(), hasSize(6));
    }

}
