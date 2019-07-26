package com.gympass.speedland.services;

import com.gympass.speedland.BasicTest;
import com.gympass.speedland.converter.LineDtoConverter;
import com.gympass.speedland.dto.LineDto;
import com.gympass.speedland.factories.GrandPrixStrategyFactory;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.strategies.GrandPrixStrategy;
import com.gympass.speedland.utils.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class GrandPrixServiceTest extends BasicTest {

    private GrandPrixService grandPrixService;

    @Mock
    private LineDtoConverter lineDtoConverter;

    @Mock
    private GrandPrixStrategyFactory grandPrixStrategyFactory;

    @Mock
    private FileUtils fileUtils;

    @Mock
    private LineDto lineDto;

    @Mock
    private GrandPrixStrategy strategy;

    @Before
    public void before() {
        initMocks(this);
        this.grandPrixService = new GrandPrixServiceImpl(lineDtoConverter, grandPrixStrategyFactory, fileUtils);
    }

    @Test
    public void shouldTestStartRace() {

        String filePath = "/mypath/file.txt";

        List<String> lines = new ArrayList<>();
        lines.add("Hora                               Piloto             Nº Volta   Tempo Volta       Velocidade média da volta");
        lines.add("23:49:08.277      038 – F.MASSA                           1     1:02.852                        44,275");
        lines.add("23:49:10.858      033 – R.BARRICHELLO                     1     1:04.352                        43,243");
        lines.add("23:49:11.075      002 – K.RAIKKONEN                       1     1:04.108                        43,408");

        when(fileUtils.getFileLines(filePath)).thenReturn(lines);
        when(lineDtoConverter.apply(any(String.class))).thenReturn(lineDto);
        when(grandPrixStrategyFactory.getStrategy(lineDto)).thenReturn(strategy);

        GrandPrix grandPrix = grandPrixService.startRace(filePath);

        assertThat(grandPrix, notNullValue());
        verify(fileUtils, times(1)).getFileLines(filePath);
        verify(lineDtoConverter, times(6)).apply(any());
        verify(grandPrixStrategyFactory, times(4)).getStrategy(any());
    }

}
