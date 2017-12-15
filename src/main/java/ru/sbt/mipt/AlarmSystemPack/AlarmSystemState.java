package ru.sbt.mipt.AlarmSystemPack;

import ru.sbt.mipt.oop.SensorEvent;

public interface AlarmSystemState {

    AlarmSystemState turnOn();

    AlarmSystemState turnOff();

    AlarmSystemState onSensorEvent(SensorEvent sensorEvent);

    AlarmSystemState enterPassword(String password, String secret);

}

