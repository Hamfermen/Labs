package com.ThirdLab.Classes;

public class Kerosene implements CanBurn {
    
    private double timeOfBurn;
	private double volume;
	private double density;
	private BurnCondition state = BurnCondition.NORMAL;

	public Kerosene(double volume) {
		this.volume = volume;
		this.density = 860;
		timeOfBurn = Calculator.calculateTimeOfBurnOfKerosene(volume, density, 40800000);
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
    
    public double getVolume() {
    	return volume;
    }
    
    public BurnCondition getState() {
    	return state;
    }
    
    public double getDensity() {
    	return density;
    }
    

}