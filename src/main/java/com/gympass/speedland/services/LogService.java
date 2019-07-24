package com.gympass.speedland.services;

import com.gympass.speedland.converter.LineDtoConverter;
import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.factories.GrandPrixStrategyFactory;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.models.Pilot;
import com.gympass.speedland.strategies.GrandPrixStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private GrandPrixStrategyFactory grandPrixStrategyFactory;

    public GrandPrix readLog() throws IOException {

        Path path = Paths.get("/Users/fernandostoianogonzalez/dev/gympass/speedland/speed.txt");

        List<String> lines = Files.readAllLines(path);

        GrandPrix grandPrix = new GrandPrix();

        for(String line : lines) {
            LineDtoConverter lineDtoConverter = new LineDtoConverter();
            LineDto lineDto = lineDtoConverter.apply(line);

            GrandPrixStrategy grandPrixStrategy = grandPrixStrategyFactory.getStrategy(lineDto);
            grandPrixStrategy.registerLap(grandPrix, lineDto);
        }

        return grandPrix;
    }

}
