package com.gympass.speedland.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gympass.speedland.models.Lap;

import static br.com.six2six.fixturefactory.Fixture.of;

public class LapFixture implements TemplateLoader {

    public static final String FIRST_LAP = "FIRST_LAP";
    public static final String FIRST_BETTER_LAP = "FIRST_BETTER_LAP";
    public static final String SECOND_LAP = "SECOND_LAP";
    public static final String SECOND_BETTER_LAP = "SECOND_BETTER_LAP";
    public static final String THIRD_LAP = "THIRD_LAP";
    public static final String THIRD_BETTER_LAP = "THIRD_BETTER_LAP";
    public static final String BETTER_LAP = "BETTER_LAP";

    @Override
    public void load() {

        of(Lap.class).addTemplate(FIRST_LAP,
        new Rule(){{
            add("number", 1);
        }});

        of(Lap.class).addTemplate(FIRST_BETTER_LAP,
        new Rule(){{
            add("number", 1);
            add("averageSpeed", 42.32);
            add("betterPerformance", true);
        }});

        of(Lap.class).addTemplate(SECOND_LAP,
        new Rule(){{
            add("number", 2);
        }});

        of(Lap.class).addTemplate(SECOND_BETTER_LAP,
        new Rule(){{
            add("number", 2);
            add("averageSpeed", 40.31);
            add("betterPerformance", true);
        }});

        of(Lap.class).addTemplate(THIRD_LAP,
        new Rule(){{
            add("number", 3);
        }});

        of(Lap.class).addTemplate(THIRD_BETTER_LAP,
        new Rule(){{
            add("number", 3);
            add("averageSpeed", 39.23);
            add("betterPerformance", true);
        }});

        of(Lap.class).addTemplate(BETTER_LAP,
        new Rule(){{
            add("number", 1);
            add("averageSpeed", 50.23);
            add("betterPerformance", true);
        }});

    }

}
