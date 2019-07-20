package com.gympass.speedland.dto;

import java.time.LocalTime;

public class LineDto {

    private LocalTime time;

    private Integer pilotCode;

    private String pilotName;

    private Integer lap;

    private LocalTime lapTime;

    private Double averageSpeed;

    public LineDto time(LocalTime time) {
        this.time = time;
        return this;
    }

    public LineDto pilotCode(Integer pilotCode) {
        this.pilotCode = pilotCode;
        return this;
    }

    public LineDto pilotName(String pilotName) {
        this.pilotName = pilotName;
        return this;
    }

    public LineDto lap(Integer lap) {
        this.lap = lap;
        return this;
    }

    public LineDto lapTime(LocalTime lapTime) {
        this.lapTime = lapTime;
        return this;
    }

    public LineDto averageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public Integer getPilotCode() {
        return pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }

    public Integer getLap() {
        return lap;
    }

    public LocalTime getLapTime() {
        return lapTime;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

}
