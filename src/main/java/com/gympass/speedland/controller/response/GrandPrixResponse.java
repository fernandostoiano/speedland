package com.gympass.speedland.controller.response;

import java.util.ArrayList;
import java.util.List;

public class GrandPrixResponse {

    private List<PilotResponse> pilots;


    public GrandPrixResponse() {
        this.pilots = new ArrayList<>();
    }

    public GrandPrixResponse pilots(List<PilotResponse> pilots) {
        this.pilots = pilots;
        return this;
    }

    public List<PilotResponse> getPilots() {
        return pilots;
    }

}
