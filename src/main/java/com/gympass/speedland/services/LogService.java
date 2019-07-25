package com.gympass.speedland.services;

import com.gympass.speedland.converter.LineDtoConverter;
import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.factories.GrandPrixStrategyFactory;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.strategies.GrandPrixStrategy;
import com.gympass.speedland.utils.TimesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LineDtoConverter lineDtoConverter;

    @Autowired
    private GrandPrixStrategyFactory grandPrixStrategyFactory;

    public GrandPrix readLog() throws IOException {

        Path path = Paths.get("/Users/fernandostoianogonzalez/dev/gympass/speedland/speed.txt");

        List<String> lines = Files.readAllLines(path);

        GrandPrix grandPrix = new GrandPrix();

        this.getStartAndFinishTime(lines, grandPrix);

        for(String line : lines) {
            LineDto lineDto = lineDtoConverter.apply(line);

            GrandPrixStrategy grandPrixStrategy = grandPrixStrategyFactory.getStrategy(lineDto);
            grandPrixStrategy.registerLap(grandPrix, lineDto);
        }

        return grandPrix;
    }

    public void getStartAndFinishTime(List<String> lines, GrandPrix grandPrix) {

        String firstLine = lines.stream().findFirst().get();
        LineDto firstLineDto = lineDtoConverter.apply(firstLine);

        LocalTime startTime = TimesUtils.minus(firstLineDto.getTime(), firstLineDto.getLapTime());


        String lastLine = lines.get(lines.size()-1);
        LineDto lastLineDto = lineDtoConverter.apply(lastLine);

        grandPrix.setStartTime(startTime);
        grandPrix.setFinishTime(lastLineDto.getTime());
    }

}
