package com.gympass.speedland.models;

import com.gympass.speedland.BasicTest;
import com.gympass.speedland.fixture.GrandPrixFixture;
import com.gympass.speedland.fixture.LapFixture;
import org.junit.Test;

import java.util.List;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class GrandPrixTest extends BasicTest {

    @Test
    public void shouldTestGetPilotByCode() {
        GrandPrix grandPrix = from(GrandPrix.class).gimme(GrandPrixFixture.DEFAULT_GRAND_PRIX);

        Pilot pilot = grandPrix.getPilotByCode(38);

        assertThat(pilot.getCode(), equalTo(38));
        assertThat(pilot.getName(), equalTo("F.MASSA"));
    }


    @Test
    public void shouldTestCalculateQualify() {
        GrandPrix grandPrix = from(GrandPrix.class).gimme(GrandPrixFixture.DEFAULT_GRAND_PRIX);

        Lap lap = from(Lap.class).gimme(LapFixture.THIRD_LAP);
        grandPrix.getPilotByCode(2).addLap(lap);

        lap = from(Lap.class).gimme(LapFixture.SECOND_LAP);
        grandPrix.getPilotByCode(11).addLap(lap);

        grandPrix.getQualify();

        assertThat(grandPrix.getPilots().get(0).getCode(), equalTo(2));
        assertThat(grandPrix.getPilots().get(0).getPosition(), equalTo(1));
        assertThat(grandPrix.getPilots().get(1).getCode(), equalTo(38));
        assertThat(grandPrix.getPilots().get(1).getPosition(), equalTo(2));
        assertThat(grandPrix.getPilots().get(2).getCode(), equalTo(33));
        assertThat(grandPrix.getPilots().get(2).getPosition(), equalTo(3));
        assertThat(grandPrix.getPilots().get(3).getCode(), equalTo(23));
        assertThat(grandPrix.getPilots().get(3).getPosition(), equalTo(4));
        assertThat(grandPrix.getPilots().get(4).getCode(), equalTo(15));
        assertThat(grandPrix.getPilots().get(4).getPosition(), equalTo(5));
        assertThat(grandPrix.getPilots().get(5).getCode(), equalTo(11));
        assertThat(grandPrix.getPilots().get(5).getPosition(), equalTo(6));
    }

    @Test
    public void shouldTestGetBetterLaps() {

        GrandPrix grandPrix = from(GrandPrix.class).gimme(GrandPrixFixture.DEFAULT_GRAND_PRIX);

        List<Lap> betterLaps = grandPrix.getBetterLaps();

        assertThat(betterLaps, hasSize(6));
    }

    @Test
    public void shouldTestGetBetterLap() {
        GrandPrix grandPrix = from(GrandPrix.class).gimme(GrandPrixFixture.DEFAULT_GRAND_PRIX);

        Lap betterLap = grandPrix.getBetterLap();

        assertThat(betterLap.getPilot().getCode(), equalTo(38));
        assertThat(betterLap.getPilot().getName(), equalTo("F.MASSA"));
        assertThat(betterLap.getNumber(), equalTo(1));
    }

}
