package com.gympass.speedland.models;

import com.gympass.speedland.utils.TimesUtils;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GrandPrix {

    private List<Pilot> pilots;

    private LocalTime startTime;

    private LocalTime finishTime;

    public GrandPrix() {
        this.pilots = new ArrayList<>();
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    public void getQualify() {
        pilots.sort(Comparator.comparing(p -> p.getLaps().size(), Comparator.reverseOrder()));

        int position = 1;
        for(Pilot pilot : pilots) {
            pilot.setPosition(position);
            position++;
        }
    }

    public LocalTime getDurationTime() {
        return TimesUtils.minus(finishTime, startTime);
    }

    public List<Lap> getBetterLaps() {
        return pilots.stream().map(pilot -> {
            return pilot.getBetterLap();
        }).collect(Collectors.toList());
    }

    public Lap getBetterLap() {
        Lap betterLap = null;
        Double better = 0.0;
        for(Lap lap: getBetterLaps()) {
            if(lap.getAverageSpeed() > better) {
                better = lap.getAverageSpeed();
                betterLap = lap;
            }
        }
        return betterLap;
    }

}
