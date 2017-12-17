package ru.sbt.mipt.AlarmSystemPack;

import ru.sbt.mipt.oop.SensorEvent;

public class AlarmSystem {

    private AlarmSystemState alarmSystemState;
    private String secret;


    public AlarmSystem(String password) {
        alarmSystemState = new StateOff();
        secret = password;
    }

    public AlarmSystemState getAlarmSystemState() {
        return alarmSystemState;
    }

    public void turnOn() {
        alarmSystemState = alarmSystemState.turnOn();
    }

    public void turnOff() {
        alarmSystemState = alarmSystemState.turnOff();
    }

    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystemState = alarmSystemState.onSensorEvent(sensorEvent);
    }

    public void enterPassword(String password) {
        alarmSystemState = alarmSystemState.enterPassword(password, secret);
    }

    @Override
    public String toString() {
        return "State = " + alarmSystemState.toString();
    }

}
