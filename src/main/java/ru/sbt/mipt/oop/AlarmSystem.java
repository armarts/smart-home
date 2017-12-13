package ru.sbt.mipt.oop;

public class AlarmSystem {
    private AlarmSystemState alarmSystemState;
    private String secret;

    public AlarmSystem(String password) {
        alarmSystemState = new StateOff();
        secret = new String(password);
    }

    public void turnOn() {
        alarmSystemState.turnOn();
    }

    public void turnOff() {
        alarmSystemState.turnOff();
    }

    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystemState.onSensorEvent(sensorEvent);
    }

    public void enterPassword(String password) {
        alarmSystemState.enterPassword(password, secret);
    }

}
