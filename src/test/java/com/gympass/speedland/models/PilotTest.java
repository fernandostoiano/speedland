package com.gympass.speedland.models;

import br.com.six2six.fixturefactory.Fixture;
import com.gympass.speedland.BasicTest;
import com.gympass.speedland.fixture.PilotFixture;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PilotTest extends BasicTest {

    @Test
    public void shouldTestGetBetterLap() {
        Pilot pilot = Fixture.from(Pilot.class).gimme(PilotFixture.R_BARRICHELLO);

        Lap betterLap = pilot.getBetterLap();

        assertThat(betterLap.getNumber(), equalTo(2));
    }

    @Test
    public void shouldTestGetGrandPrixAverageSpeed() {
        Pilot pilot = Fixture.from(Pilot.class).gimme(PilotFixture.K_RAIKKONEN);

        Double grandPrixAverageSpeed = pilot.getGrandPrixAverageSpeed();

        assertThat(grandPrixAverageSpeed, equalTo(27.28));
    }

}
