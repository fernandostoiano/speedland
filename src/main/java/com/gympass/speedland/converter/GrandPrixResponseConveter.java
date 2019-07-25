package com.gympass.speedland.converter;

import com.gympass.speedland.controller.response.BetterLapResponse;
import com.gympass.speedland.controller.response.GrandPrixResponse;
import com.gympass.speedland.controller.response.PilotResponse;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.models.Lap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.Objects.isNull;

@Component
public class GrandPrixResponseConveter implements Function<GrandPrix, GrandPrixResponse> {

    @Override
    public GrandPrixResponse apply(GrandPrix grandPrix) {
        if(isNull(grandPrix)) {
            return null;
        }

        List<PilotResponse> pilots = new ArrayList<>();

        grandPrix.getPilots().forEach(p -> {

            PilotResponse pilotResponse = new PilotResponse()
                    .code(p.getCode())
                    .position(p.getPosition())
                    .name(p.getName())
                    .completedLaps(p.getLaps().size())
                    .betterLap(p.getBetterLap().getNumber())
                    .averageSpeed(p.getGrandPrixAverageSpeed());

            pilots.add(pilotResponse);
        });

        Lap betterLap = grandPrix.getBetterLap();

        BetterLapResponse betterLapResponse = new BetterLapResponse()
                .pilotCode(betterLap.getPilot().getCode())
                .pilotName(betterLap.getPilot().getName())
                .lapNumber(betterLap.getNumber());

        GrandPrixResponse response = new GrandPrixResponse()
                .durationTime(grandPrix.getDurationTime())
                .betterLap(betterLapResponse)
                .pilots(pilots);

        return response;
    }

}
