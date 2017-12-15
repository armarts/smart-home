package ru.sbt.mipt.AlarmSystemPack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Decorator {

    private AlarmSystem alarmSystem;

    public Decorator(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    public void action(String act) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = AlarmSystem.class.getMethods();

        for (Method method : methods)
            if (method.getName().equals(act)) {
                method.invoke(alarmSystem, null);
                break;
            }

        System.out.println(alarmSystem);
    }
}
