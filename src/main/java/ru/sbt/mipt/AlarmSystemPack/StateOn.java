package ru.sbt.mipt.AlarmSystemPack;

import ru.sbt.mipt.oop.SensorEvent;

public class StateOn implements AlarmSystemState {

    @Override
    public AlarmSystemState turnOn() {
        return this;
    }

    @Override
    public AlarmSystemState turnOff() {
        return new StateWaitForPassword(this);
    }

    @Override
    public AlarmSystemState onSensorEvent(SensorEvent sensorEvent) {
        return null; // TODO
    }

    @Override
    public AlarmSystemState enterPassword(String password, String secret) {
        return this;
    }

    @Override
    public String toString() {
        return "On";
    }

    @Override
    public boolean equals(Object obj) {
        AlarmSystemState rhs = (AlarmSystemState) obj;

        if (rhs instanceof StateOn)
            return true;

        return false;
    }
}

