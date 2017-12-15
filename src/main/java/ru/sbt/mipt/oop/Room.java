package ru.sbt.mipt.oop;


import ru.sbt.mipt.DoorActions.Door;
import ru.sbt.mipt.LightActions.Light;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void doAction(Action action, SensorEvent event) {
        action.execute(this, event);

        // Iterator for lights
        for (Light light : lights) {
            light.doAction(action, event);
        }

        // Iterator for doors
        for (Door door : doors) {
            door.doAction(action, event);
        }
    }
}
