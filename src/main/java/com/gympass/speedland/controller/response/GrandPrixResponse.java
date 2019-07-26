package com.gympass.speedland.controller.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GrandPrixResponse {

    private LocalTime durationTime;

    private BetterLapResponse betterLap;

    private List<PilotResponse> pilots;


    public GrandPrixResponse() {
        this.pilots = new ArrayList<>();
    }

    public GrandPrixResponse durationTime(LocalTime durationTime) {
        this.durationTime = durationTime;
        return this;
    }

    public GrandPrixResponse betterLap(BetterLapResponse betterLap) {
        this.betterLap = betterLap;
        return this;
    }

    public GrandPrixResponse pilots(List<PilotResponse> pilots) {
        this.pilots = pilots;
        return this;
    }

    public LocalTime getDurationTime() {
        return durationTime;
    }

    public BetterLapResponse getBetterLap() {
        return betterLap;
    }

    public List<PilotResponse> getPilots() {
        return pilots;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE).toString();
    }

}
