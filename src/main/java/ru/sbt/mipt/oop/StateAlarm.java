package ru.sbt.mipt.oop;

public class StateAlarm extends AlarmSystemState {

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void turnOff() {
        setAlarmSystemStateState(new StateOn());
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
        return "State = Alarm";
    }
}