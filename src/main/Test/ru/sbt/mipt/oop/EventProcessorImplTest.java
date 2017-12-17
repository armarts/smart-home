package ru.sbt.mipt.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.DoorActions.Door;
import ru.sbt.mipt.LightActions.Light;

import static org.junit.jupiter.api.Assertions.*;

class EventProcessorImplTest {

    private EventProcessorImpl eventProcessor;

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        eventProcessor = new EventProcessorImpl();
    }

    Object findLight(SmartHome home, String objId) {
        for (Room room : home.getRooms()) {

            // find ans among lights
            for (Light light : room.getLights()) {
                if (light.getId().equals(objId))
                    return light;
            }
        }

        return null;
    }

    Object findDoor(SmartHome home, String objId) {
        for (Room room : home.getRooms()) {

            // find ans among doors
            for (Door door : room.getDoors()) {
                if (door.getId().equals(objId))
                    return door;
            }

        }

        return null;
    }

    @org.junit.jupiter.api.Test
    void eventProcessor() {
        SmartHome home = HomeReader.getHomeStateFromJson("smart-home-1.js");
        Light light;
        Door door;

        // Tests for Light event
        eventProcessor.eventProcessor(home, new SensorEvent(SensorEventType.LIGHT_OFF, "4"));
        light = (Light) findLight(home, "4");

        assertEquals(false, light.isOn());

        eventProcessor.eventProcessor(home, new SensorEvent(SensorEventType.LIGHT_ON, "1"));
        light = (Light) findLight(home, "1");

        assertEquals(true, light.isOn());


        // Tests for Doors

        eventProcessor.eventProcessor(home, new SensorEvent(SensorEventType.DOOR_OPEN, "1"));
        door = (Door) findDoor(home, "1");

        assertEquals(true, door.isOpen());


    }

}