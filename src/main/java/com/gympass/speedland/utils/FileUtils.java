package com.gympass.speedland.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileUtils {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);

    @Autowired
    private Environment env;

    public List<String> getFileLines(String filePath) {
        Path path = Paths.get(getFilePath(filePath));

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            LOG.error("Error ocurred on try read file: {}", filePath);
            new RuntimeException("Error ocurred on try read file: " + filePath);
        }

        lines.remove(0);
        return lines;
    }

    private String getFilePath(String filePath) {
        if(StringUtils.isEmpty(filePath)) {
            String userDir = System.getProperty("user.dir");
            String fileName = env.getProperty("default.file.name");
            return userDir + "/" + fileName;
        }
        return filePath;
    }

}
