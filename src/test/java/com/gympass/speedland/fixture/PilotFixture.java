package com.gympass.speedland.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gympass.speedland.models.Lap;
import com.gympass.speedland.models.Pilot;


import static br.com.six2six.fixturefactory.Fixture.of;

public class PilotFixture implements TemplateLoader {

    public static final String F_MASSA = "F_MASSA";
    public static final String R_BARRICHELLO = "R_BARRICHELLO";
    public static final String K_RAIKKONEN = "K_RAIKKONEN";
    public static final String M_WEBBER = "M_WEBBER";
    public static final String F_ALONSO = "F_ALONSO";
    public static final String S_VETTEL = "S_VETTEL";

    @Override
    public void load() {

        of(Pilot.class).addTemplate(F_MASSA,
        new Rule(){{
            add("code", 38);
            add("name", "F.MASSA");
            add("laps", has(2).of(Lap.class, LapFixture.BETTER_LAP, LapFixture.SECOND_LAP));
        }});

        of(Pilot.class).addTemplate(R_BARRICHELLO,
        new Rule(){{
            add("code", 33);
            add("name", "R.BARRICHELLO");
            add("laps", has(2).of(Lap.class, LapFixture.FIRST_LAP, LapFixture.SECOND_BETTER_LAP));
        }});

        of(Pilot.class).addTemplate(K_RAIKKONEN,
        new Rule(){{
            add("code", 2);
            add("name", "K.RAIKKONEN");
            add("laps", has(2).of(Lap.class, LapFixture.FIRST_BETTER_LAP, LapFixture.SECOND_LAP));
        }});

        of(Pilot.class).addTemplate(M_WEBBER,
        new Rule(){{
            add("code", 23);
            add("name", "M.WEBBER");
            add("laps", has(2).of(Lap.class, LapFixture.FIRST_LAP, LapFixture.SECOND_BETTER_LAP));
        }});

        of(Pilot.class).addTemplate(F_ALONSO,
        new Rule(){{
            add("code", 15);
            add("name", "F.ALONSO");
            add("laps", has(2).of(Lap.class, LapFixture.FIRST_LAP, LapFixture.SECOND_BETTER_LAP));
        }});

        of(Pilot.class).addTemplate(S_VETTEL,
        new Rule(){{
            add("code", 11);
            add("name", "S.VETTEL");
            add("laps", has(1).of(Lap.class, LapFixture.FIRST_BETTER_LAP));
        }});
    }

}
