package com.gympass.speedland.models;

import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;

public class Pilot {

    private Integer code;

    private String name;

    private Integer position;

    private List<Lap> laps;

    private Double averageSpeed;

    public Pilot() {
        this.laps = new ArrayList<>();
        this.averageSpeed = 0.0;
    }


    public Integer getCode() {
        return code;
    }

    public boolean verifYCode(Integer code) {
        if(this.code == code) {
            return true;
        }
        return false;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<Lap> getLaps() {
        return laps;
    }

    public void setLaps(List<Lap> laps) {
        this.laps = laps;
    }

    public void addLap(Lap lap) { this.laps.add(lap); }

    public Lap getBetterLap() {
        return laps.stream().filter(Lap::isBetterPerformance).findFirst().get();
    }

    public void averageSpeedAdd(Double averageSpeed) {
        this.averageSpeed += averageSpeed;
    }

    public Double getGrandPrixAverageSpeed() {
        this.averageSpeed = this.averageSpeed / laps.size();
        return Precision.round(this.averageSpeed, 2);
    }

}
