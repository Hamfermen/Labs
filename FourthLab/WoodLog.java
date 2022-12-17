package com.ThirdLab.Classes;

public class WoodLog implements CanBurn {
    
    private double timeOfBurn;
	private double width;
	private double height;
	private double lenght;
	private String type;
	private double humidity; 
	private double density;
	private BurnCondition state = BurnCondition.NORMAL;

	public WoodLog(String type, double timeOfBurn, double weight, double width, double lenght, double height, double humidity, double density) {
		this.timeOfBurn = timeOfBurn;
		this.width = width;
		this.height = height;
		this.lenght = lenght;
		this.type = type;
		this.humidity = humidity;
		this.density = density;
    }
    
    @Override
    public boolean burn() {
        if (timeOfBurn > 0) {
        	if (BurnCondition.NORMAL == state) state = BurnCondition.BURN;
        	timeOfBurn--;
        	return true;
        }
        if (BurnCondition.BURN == state) state = BurnCondition.AFTERBURN;
        return false;
    }
    
    public double getTimeOfBurn() {
    	return timeOfBurn;
    }
    
    public double getSize() {
    	return width * height * lenght;
    }
    
    public BurnCondition getState() {
    	return state;
    }

    public String getType() {
    	return type;
    }
    
    public double getHumidity() {
    	return humidity;
    }
    
    public double getDensity() {
    	return density;
    }
    
}