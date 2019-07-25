package com.gympass.speedland.controller.response;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GrandPrixResponse {

    private LocalTime durationTime;

    private List<PilotResponse> pilots;


    public GrandPrixResponse() {
        this.pilots = new ArrayList<>();
    }

    public GrandPrixResponse pilots(List<PilotResponse> pilots) {
        this.pilots = pilots;
        return this;
    }

    public GrandPrixResponse durationTime(LocalTime durationTime) {
        this.durationTime = durationTime;
        return this;
    }

    public List<PilotResponse> getPilots() {
        return pilots;
    }

    public LocalTime getDurationTime() {
        return durationTime;
    }

}
