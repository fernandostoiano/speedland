package com.gympass.speedland.model;

import java.time.LocalTime;
import java.util.List;

public class GrandPrix {


    private LocalTime totalTime;

    private List<Pilot> pilots;

    private boolean finished;


    public LocalTime getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(LocalTime totalTime) {
        this.totalTime = totalTime;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}
