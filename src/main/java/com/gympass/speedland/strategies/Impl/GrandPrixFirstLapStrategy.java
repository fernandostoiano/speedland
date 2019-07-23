package com.gympass.speedland.strategies.Impl;

import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.models.Lap;
import com.gympass.speedland.models.Pilot;
import com.gympass.speedland.strategies.GrandPrixStrategy;
import org.springframework.stereotype.Service;

@Service("grandPrixFirstLapStrategy")
public class GrandPrixFirstLapStrategy implements GrandPrixStrategy {

    @Override
    public void registerLap(GrandPrix grandPrix, LineDto lineDto) {

        Pilot pilot = new Pilot();

        pilot.setCode(lineDto.getPilotCode());
        pilot.setName(lineDto.getPilotName());

        Lap lap = new Lap();
        lap.setNumber(lineDto.getLap());
        lap.setPilot(pilot);
        lap.setCompletedTime(lineDto.getLapTime());
        lap.setTime(lineDto.getTime());
        lap.setAverageSpeed(lineDto.getAverageSpeed());

        pilot.addLap(lap);

        grandPrix.addPilot(pilot);

        grandPrix.calculateQualify();
    }

}
