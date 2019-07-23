package com.gympass.speedland.models;


import java.time.LocalTime;

public class Lap {

    private Integer number;

    private LocalTime time;

    private Double averageSpeed;

    private LocalTime completedTime;

    private Pilot pilot;


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public LocalTime getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(LocalTime completedTime) {
        this.completedTime = completedTime;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

}
