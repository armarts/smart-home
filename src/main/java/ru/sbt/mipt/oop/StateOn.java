package ru.sbt.mipt.oop;

public class StateOn extends AlarmSystemState {

    @Override
    public void turnOn() {
        // nothing
    }

    @Override
    public void turnOff() {
        setAlarmSystemStateState(new StateWaitForPassword(new StateOn()));
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        // TODO
    }

    @Override
    public void enterPassword(String password, String secret) {
    }

    @Override
    public String toString() {
        return "State = StateOn";
    }
}

