package com.gympass.speedland.factories;

import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.strategies.GrandPrixStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GrandPrixStrategyFactory {

    @Autowired
    @Qualifier("grandPrixFirstLapStrategy")
    private GrandPrixStrategy grandPrixFirstLapStrategy;

    @Autowired
    @Qualifier("grandPrixAnyLapStrategy")
    private GrandPrixStrategy grandPrixAnyLapStrategy;


    public GrandPrixStrategy getStrategy(LineDto lineDto) {

        if(lineDto.isFirsLap()) {
            return grandPrixFirstLapStrategy;
        }

        return grandPrixAnyLapStrategy;
    }

}
