package ru.sbt.mipt.oop;

public class StateWaitForPassword extends AlarmSystemState {

    private AlarmSystemState previousState;

    StateWaitForPassword(AlarmSystemState previousState) {
        this.previousState = previousState;
    }

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void turnOff() {
        setAlarmSystemStateState(previousState);
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        // TODO
    }


    @Override
    public void enterPassword(String password, String secret) {
        if (password.equals(secret)) {
            System.out.println("Correct Password");

            if (previousState instanceof StateOff)
                setAlarmSystemStateState(new StateOn());

            if (previousState instanceof StateOn)
                setAlarmSystemStateState(new StateOff());

            return;
        }

        System.out.println("Uncorrect Password");
    }

    @Override
    public String toString() {
        return "State = State wait for password";
    }
}
