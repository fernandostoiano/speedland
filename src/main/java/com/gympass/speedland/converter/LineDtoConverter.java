package com.gympass.speedland.converter;

import static org.springframework.util.StringUtils.isEmpty;

import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.utils.TimesUtils;
import org.springframework.util.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;


public class LineDtoConverter implements Function<String, LineDto> {

    @Override
    public LineDto apply(String line) {

        if(isEmpty(line) || line.length() < 102) {
            return null;
        }

        LocalTime time = convertTime(line);

        Integer pilotCode = convertPilotCode(line);

        String pilotName = convertPilotName(line);

        Integer lap = convertLap(line);

        LocalTime lapTime = convertLapTime(line);

        Double averageSpeed = convertAverageSpeed(line);

        return new LineDto().time(time)
                .pilotCode(pilotCode)
                .pilotName(pilotName)
                .lap(lap)
                .lapTime(lapTime)
                .averageSpeed(averageSpeed);
    }

    private LocalTime convertTime(String line) {

        String hora = line.substring(0, 12);

        LocalTime time = LocalTime.parse(hora, DateTimeFormatter.ISO_TIME);

        return time;
    }

    private Integer convertPilotCode(String line) {
        String pilot = line.substring(18, 31);

        String pilotCode = pilot.substring(0, 3);

        return Integer.parseInt(pilotCode);
    }

    private String convertPilotName(String line) {
        String pilot = line.substring(18, 31);

        String pilotName = pilot.substring(6, 13);

        return pilotName;
    }

    private Integer convertLap(String line) {

        String lap = line.substring(58, 59);

        return Integer.parseInt(lap);
    }

    private LocalTime convertLapTime(String line) {
        String lapTime = line.substring(64, 72);

        LocalTime time = TimesUtils.convertMinuteToLocalTime(lapTime);

        return time;
    }

    private Double convertAverageSpeed(String line) {
        int lineLength = line.length();
        
        String averageSpeed = line.substring(96, lineLength);

        String averageSpeedReplaced = StringUtils.replace(averageSpeed, ",", ".");

        return Double.parseDouble(averageSpeedReplaced);
    }

}
