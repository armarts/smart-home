package ru.sbt.mipt.oop;

public abstract class AlarmSystemState {

    private AlarmSystemState alarmSystemState;

    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void onSensorEvent(SensorEvent sensorEvent);

    public abstract void enterPassword(String password, String secret);

    void setAlarmSystemStateState(AlarmSystemState alarmSystemState) {
        this.alarmSystemState = alarmSystemState;
    }
}

