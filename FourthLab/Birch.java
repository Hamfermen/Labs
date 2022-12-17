package com.ThirdLab.Classes;

public class Birch extends WoodLog{
	
	public Birch(double lenght, double width, double height, double humidity) {
		this("Birch", Calculator.calculateTimeOfBurnOfLog(lenght*width*height*610, humidity, 1194444.411), lenght*width*height*610, width, lenght, height, humidity, 610.0);
    }
	
    private Birch(String type, double timeOfBurn, double weight, double width, double lenght, double height, double humidity, double density) {
        super(type, timeOfBurn, weight, width, lenght, height, humidity, density);
    }

}