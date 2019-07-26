package com.gympass.speedland.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileUtils {

    @Autowired
    private Environment env;

    public List<String> getFileLines() {

        String filePath = env.getProperty("default.file.race.path");

        Path path = Paths.get(filePath);

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
