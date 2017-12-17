package ru.sbt.mipt.AlarmSystemPack;

import ru.sbt.mipt.oop.SensorEvent;

public class StateOff implements AlarmSystemState {

    @Override
    public AlarmSystemState turnOn() {
        return new StateWaitForPassword(this);
    }

    @Override
    public AlarmSystemState turnOff() {
        return this;
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
        return "Off";
    }

    @Override
    public boolean equals(Object obj) {
        AlarmSystemState rhs = (AlarmSystemState) obj;

        if (rhs instanceof StateOff)
            return true;

        return false;
    }
}

