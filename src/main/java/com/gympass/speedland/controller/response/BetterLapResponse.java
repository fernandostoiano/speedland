package com.gympass.speedland.controller.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BetterLapResponse {

    private Integer pilotCode;

    private String pilotName;

    private Integer lapNumber;

    public BetterLapResponse pilotCode(Integer pilotCode) {
        this.pilotCode = pilotCode;
        return this;
    }

    public BetterLapResponse pilotName(String pilotName) {
        this.pilotName = pilotName;
        return this;
    }

    public BetterLapResponse lapNumber(Integer lapNumber) {
        this.lapNumber = lapNumber;
        return this;
    }

    public Integer getPilotCode() {
        return pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }

    public Integer getLapNumber() {
        return lapNumber;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE).toString();
    }

}
