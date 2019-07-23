package com.gympass.speedland.models;

import java.util.ArrayList;
import java.util.List;

public class Pilot {

    private Integer code;

    private String name;

    private Integer position;

    private List<Lap> laps;


    public Pilot() {
        this.laps = new ArrayList<>();
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

}
