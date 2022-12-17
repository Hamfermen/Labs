package com.ThirdLab.Classes;

public final class Calculator {

    private Calculator() {}

    public static double calculateTimeOfBurnOfLog(double weight, double humidity, double q) {
    	return weight * (q * (1 - humidity) - 600 * humidity) / Room.RoomConsts.JPS / (Room.RoomConsts.DELAY / 1000);
    }
    
    public static double calculateTimeOfBurnOfKerosene(double volume, double density, double q) {
    	return volume * density * q / Room.RoomConsts.JPS;
    }

    public static double calculateTimeOfBurn(double timeOfBurn, double coefficientOfLaying, double size) {
        return coefficientOfLaying * size / timeOfBurn / (Room.RoomConsts.DELAY / 1000);
    }

}