package ru.sbt.mipt.oop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HomeSaver {

    // Save Json format
    public static void saveJsonFormat(String jsonString) throws IOException {
        System.out.println(jsonString);
        Path path = Paths.get("output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }

    //TODO CSV, XML format saver
}
