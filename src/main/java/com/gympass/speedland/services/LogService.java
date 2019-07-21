package com.gympass.speedland.services;

import com.gympass.speedland.converter.LineDtoConverter;
import com.gympass.speedland.dto.LineDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LogService {

    public void readLog() throws IOException {

        Path path = Paths.get("/Users/fernandostoianogonzalez/dev/gympass/speedland/speed.txt");

        List<String> lines = Files.readAllLines(path);

        //String line = "23:49:08.277      038 – F.MASSA                           1     1:02.852                        44,275";

        for(String line : lines) {
            LineDtoConverter lineDtoConverter = new LineDtoConverter();
            LineDto lineDto = lineDtoConverter.apply(line);
            System.out.println(lineDto);
        }
    }

    public static void main(String ...args) {

        LogService service = new LogService();

        try {
            service.readLog();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
