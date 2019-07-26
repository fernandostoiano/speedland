package com.gympass.speedland.fixture;

import static br.com.six2six.fixturefactory.Fixture.of;

import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.models.Pilot;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gympass.speedland.utils.TimesUtils;

public class GrandPrixFixture implements TemplateLoader {

    public static final String DEFAULT_GRAND_PRIX = "DEFAULT_GRAND_PRIX";

    @Override
    public void load() {

        of(GrandPrix.class).addTemplate(DEFAULT_GRAND_PRIX,
        new Rule(){{
            add("pilots", has(6).of(Pilot.class, PilotFixture.F_MASSA, PilotFixture.R_BARRICHELLO,
                    PilotFixture.K_RAIKKONEN, PilotFixture.M_WEBBER,
                    PilotFixture.F_ALONSO, PilotFixture.S_VETTEL));
            add("startTime", TimesUtils.convertStringToLocalTime("23:38:07.277"));
            add("finishTime", TimesUtils.convertStringToLocalTime("23:54:57.757"));
        }});
    }

}
