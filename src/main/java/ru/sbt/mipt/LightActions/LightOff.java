package ru.sbt.mipt.LightActions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SensorEvent;

public class LightOff implements Action {
    @Override
    public void execute(Object object, SensorEvent event) {
        if (object instanceof Light) {
            if (event.getObjectId().equals(((Light) object).getId()))
                ((Light) object).setOn(false);
        }
    }
}
