package com.gympass.speedland.models;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GrandPrix {


    private LocalTime totalTime;

    private List<Pilot> pilots;

    private boolean finished;

    public GrandPrix() {
        this.pilots = new ArrayList<>();
    }


    public LocalTime getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(LocalTime totalTime) {
        this.totalTime = totalTime;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public Pilot getPilotByCode(Integer code) {
        return pilots.stream().filter(pilot -> pilot.verifYCode(code)).findFirst().get();
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public void addPilot(Pilot pilot) { this.pilots.add(pilot); }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void calculateQualify() {
        pilots.sort(Comparator.comparing(p -> p.getLaps().size(), Comparator.reverseOrder()));

        int position = 1;
        for(Pilot pilot : pilots) {
            pilot.setPosition(position);
            position++;
        }
    }

}
