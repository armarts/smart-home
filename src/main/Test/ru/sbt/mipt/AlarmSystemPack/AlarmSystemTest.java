package ru.sbt.mipt.AlarmSystemPack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlarmSystemTest {
    private AlarmSystem alarmSystem;
    private String password;

    @org.junit.jupiter.api.BeforeEach
    public void setup() {
        this.password = password;
        alarmSystem = new AlarmSystem("garik");
        alarmSystem.turnOn();

    }

    @org.junit.jupiter.api.Test
    public void turnOn() {
        AlarmSystemState alarmSystemStateBefore = alarmSystem.getAlarmSystemState();
        alarmSystem.turnOn();
        AlarmSystemState alarmSystemStateAfter = alarmSystem.getAlarmSystemState();

        if (alarmSystemStateBefore instanceof StateOff) {
            assertEquals(new StateWaitForPassword(alarmSystemStateBefore), alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateOn) {
            assertEquals(alarmSystemStateBefore, alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateWaitForPassword) {
            assertEquals(alarmSystemStateBefore, alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateAlarm) {
            assertEquals(alarmSystemStateBefore, alarmSystemStateAfter);

            return;
        }

    }

    @org.junit.jupiter.api.Test
    public void turnOff() {
        AlarmSystemState alarmSystemStateBefore = alarmSystem.getAlarmSystemState();
        alarmSystem.turnOff();
        AlarmSystemState alarmSystemStateAfter = alarmSystem.getAlarmSystemState();

        if (alarmSystemStateBefore instanceof StateOff) {
            assertEquals(alarmSystemStateBefore, alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateOn) {
            assertEquals(new StateWaitForPassword(alarmSystemStateBefore), alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateWaitForPassword) {
            assertEquals(((StateWaitForPassword) alarmSystemStateBefore).getPrevious(), alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateAlarm) {
            assertEquals(new StateWaitForPassword(alarmSystemStateBefore), alarmSystemStateAfter);

            return;
        }

    }

    @org.junit.jupiter.api.Test
    public void onSensorEvent() {
    }

    @org.junit.jupiter.api.Test
    void enterPassword() {
        AlarmSystemState alarmSystemStateBefore = alarmSystem.getAlarmSystemState();
        alarmSystem.enterPassword("garik");
        AlarmSystemState alarmSystemStateAfter = alarmSystem.getAlarmSystemState();

        if (alarmSystemStateBefore instanceof StateOff) {
            assertEquals(alarmSystemStateBefore, alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateOn) {
            assertEquals(alarmSystemStateBefore, alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateWaitForPassword) {
            if (((StateWaitForPassword) alarmSystemStateBefore).getPrevious() instanceof StateOff)
                assertEquals(new StateOn(), alarmSystemStateAfter);

            if (((StateWaitForPassword) alarmSystemStateBefore).getPrevious() instanceof StateOn)
                assertEquals(new StateOff(), alarmSystemStateAfter);

            if (((StateWaitForPassword) alarmSystemStateBefore).getPrevious() instanceof StateAlarm)
                assertEquals(new StateOff(), alarmSystemStateAfter);

            return;
        }

        if (alarmSystemStateBefore instanceof StateAlarm) {
            assertEquals(alarmSystemStateBefore, alarmSystemStateAfter);

            return;
        }

    }

}