package com.gympass.speedland.strategies;

import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.models.GrandPrix;

public interface GrandPrixStrategy {

    void registerLap(GrandPrix grandPrix, LineDto lineDto);
}
