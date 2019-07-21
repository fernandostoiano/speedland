package com.gympass.speedland.services;

import com.gympass.speedland.converter.LineDtoConverter;
import com.gympass.speedland.dto.LineDto;

public class LogService {

    public void readLog() {

        String line = "23:49:08.277      038 – F.MASSA                           1     1:02.852                        44,275";

        LineDtoConverter lineDtoConverter = new LineDtoConverter();

        LineDto lineDto = lineDtoConverter.apply(line);

        System.out.println(lineDto);
    }

    public static void main(String ...args) {

        LogService service = new LogService();

        service.readLog();
    }

}
