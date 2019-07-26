package com.gympass.speedland.services;

import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympass.speedland.converter.LineDtoConverter;
import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.factories.GrandPrixStrategyFactory;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.strategies.GrandPrixStrategy;
import com.gympass.speedland.utils.FileUtils;
import com.gympass.speedland.utils.TimesUtils;

@Service
public class GrandPrixServiceImpl implements GrandPrixService {

    private static final Logger LOG = LoggerFactory.getLogger(GrandPrixServiceImpl.class);

    private LineDtoConverter lineDtoConverter;

    private GrandPrixStrategyFactory grandPrixStrategyFactory;

    private FileUtils fileUtils;

    @Autowired
    public GrandPrixServiceImpl(LineDtoConverter lineDtoConverter,
                                GrandPrixStrategyFactory grandPrixStrategyFactory,
                                FileUtils fileUtils) {

        this.lineDtoConverter = lineDtoConverter;
        this.grandPrixStrategyFactory = grandPrixStrategyFactory;
        this.fileUtils = fileUtils;
    }

    public GrandPrix startRace(String path) {

        LOG.info("Start race");

        List<String> lines = fileUtils.getFileLines(path);

        GrandPrix grandPrix = new GrandPrix();

        this.getStartAndFinishTime(lines, grandPrix);

        for(String line : lines) {
            LineDto lineDto = lineDtoConverter.apply(line);

            GrandPrixStrategy grandPrixStrategy = grandPrixStrategyFactory.getStrategy(lineDto);
            grandPrixStrategy.registerLap(grandPrix, lineDto);
        }

        LOG.info("Finished race");

        return grandPrix;
    }

    private void getStartAndFinishTime(List<String> lines, GrandPrix grandPrix) {

        String firstLine = lines.stream().findFirst().get();
        LineDto firstLineDto = lineDtoConverter.apply(firstLine);

        LocalTime startTime = TimesUtils.minus(firstLineDto.getTime(), firstLineDto.getLapTime());


        String lastLine = lines.get(lines.size()-1);
        LineDto lastLineDto = lineDtoConverter.apply(lastLine);

        grandPrix.setStartTime(startTime);
        grandPrix.setFinishTime(lastLineDto.getTime());
    }

}
