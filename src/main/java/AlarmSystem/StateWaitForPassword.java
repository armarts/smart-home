package AlarmSystem;

import ru.sbt.mipt.oop.SensorEvent;

public class StateWaitForPassword implements AlarmSystemState {

    private AlarmSystemState previous;

    public StateWaitForPassword(AlarmSystemState alarmSystemState) {
        previous = alarmSystemState;
    }

    @Override
    public AlarmSystemState turnOn() {
        return this;
    }

    @Override
    public AlarmSystemState turnOff() {
        return previous;
    }

    @Override
    public AlarmSystemState onSensorEvent(SensorEvent sensorEvent) {
        return null; // TODO
    }

    @Override
    public AlarmSystemState enterPassword(String password, String secret) {
        if (password.equals(secret)) {
            System.out.println("Correct Password");
            if (previous instanceof StateOn)
                return new StateOff();

            if (previous instanceof StateOff)
                return new StateOn();

            if (previous instanceof StateAlarm)
                return new StateOn();
        }
        else
            System.out.println("Uncorrect Password");

        return this;
    }

    @Override
    public String toString() {
        return "Waite For Password";
    }
}
