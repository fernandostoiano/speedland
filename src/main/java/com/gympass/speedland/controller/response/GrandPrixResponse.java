package com.gympass.speedland.controller.response;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GrandPrixResponse {

    private LocalTime durationTime;

    private String betterLap;

    private List<PilotResponse> pilots;


    public GrandPrixResponse() {
        this.pilots = new ArrayList<>();
    }

    public GrandPrixResponse durationTime(LocalTime durationTime) {
        this.durationTime = durationTime;
        return this;
    }

    public GrandPrixResponse betterLap(String betterLap) {
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

    public String getBetterLap() {
        return betterLap;
    }

    public List<PilotResponse> getPilots() {
        return pilots;
    }

}
