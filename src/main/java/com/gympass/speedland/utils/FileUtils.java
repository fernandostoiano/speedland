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
        String userDir = System.getProperty("user.dir");
        String fileName = env.getProperty("default.file.name");

        Path path = Paths.get(userDir + "/" + fileName);

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
