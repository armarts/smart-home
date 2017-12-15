package ru.sbt.mipt.oop;

import ru.sbt.mipt.DoorActions.DoorClose;
import ru.sbt.mipt.DoorActions.DoorOpen;
import ru.sbt.mipt.LightActions.LightOff;
import ru.sbt.mipt.LightActions.LightOn;

public class EventProcessorImpl implements EventProcessor{
    @Override
    public void eventProcessor(SmartHome home, SensorEvent event) {
            switch (event.getType()) {
                case LIGHT_ON:
                    home.doAction(new LightOn(), event);
                    break;

                case LIGHT_OFF:
                    home.doAction(new LightOff(), event);
                    break;

                case DOOR_OPEN:
                    home.doAction(new DoorOpen(), event);
                    break;

                case DOOR_CLOSED:
                    home.doAction(new DoorClose(), event);
                    break;

                default:
                    break;
            }
    }
}
