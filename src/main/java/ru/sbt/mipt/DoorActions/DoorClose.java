package ru.sbt.mipt.DoorActions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SensorEvent;

public class DoorClose implements Action {
    @Override
    public void execute(Object object, SensorEvent event) {
        if (object instanceof Door) {
            if (event.getObjectId().equals(((Door) object).getId()))
                ((Door) object).setOpen(false);
        }
    }
}
