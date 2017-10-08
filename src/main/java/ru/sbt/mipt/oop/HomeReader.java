package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeReader {

    public static SmartHome getHomeState(String path) {
        Gson gson = new Gson();
        String json;
        try  {
            json = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println("I/O Error\n");
            return null;
        }
        return gson.fromJson(json, SmartHome.class);
    }

}
