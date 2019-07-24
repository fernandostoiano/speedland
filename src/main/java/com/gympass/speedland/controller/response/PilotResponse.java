package com.gympass.speedland.controller.response;


public class PilotResponse {

    private Integer position;

    private Integer code;

    private String name;

    private Integer laps;

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

    public PilotResponse laps(Integer laps) {
        this.laps = laps;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getLaps() {
        return laps;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
