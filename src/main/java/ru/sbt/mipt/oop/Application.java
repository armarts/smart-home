package ru.sbt.mipt.oop;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

public class Application {

    public static void main(String... args) throws IOException, InvocationTargetException, IllegalAccessException {
        // считываем состояние дома из файла
        SmartHome smartHome = HomeReader.getHomeStateFromJson("smart-home-1.js");
        Collection<EventProcessor> eventProcessors = new ArrayList<>();

        eventProcessors.add(new EventProcessorImpl());

        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eventProcessor: eventProcessors)
                eventProcessor.eventProcessor(smartHome, event);
            event = getNextSensorEvent();
        }
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
