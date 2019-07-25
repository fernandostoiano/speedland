package com.gympass.speedland.controller.response;


public class PilotResponse {

    private Integer position;

    private Integer code;

    private String name;

    private Integer completedLaps;

    private Integer betterLap;

    private Double averageSpeed;

    public PilotResponse position(Integer position) {
        this.position = position;
        return this;
    }

    public PilotResponse code(Integer code) {
        this.code = code;
        return this;
    }

    public PilotResponse name(String name) {
        this.name = name;
        return  this;
    }

    public PilotResponse completedLaps(Integer completedLaps) {
        this.completedLaps = completedLaps;
        return this;
    }

    public PilotResponse betterLap(Integer betterLap) {
        this.betterLap = betterLap;
        return this;
    }

    public PilotResponse averageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getCompletedLaps() {
        return completedLaps;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getBetterLap() {
        return betterLap;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

}
