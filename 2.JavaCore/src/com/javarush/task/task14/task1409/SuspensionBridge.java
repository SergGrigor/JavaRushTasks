package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    private static final int CARS_COUNT = 200;

    @Override
    public int getCarsCount() {
        return CARS_COUNT;
    }
}
