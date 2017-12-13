package ru.sbt.mipt.oop;

public class StateOff extends AlarmSystemState {

    @Override
    public void turnOn() {
        setAlarmSystemStateState(new StateWaitForPassword(new StateOff()));
    }

    @Override
    public void turnOff() {
        return;
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
        return "State = StateOff";
    }
}

