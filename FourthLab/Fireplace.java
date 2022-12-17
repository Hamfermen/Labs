package com.ThirdLab.Classes;

import java.util.*;

public class Fireplace implements CanContainFire, DynamicObjects{

    private List<WoodLog> logs;
    private List<WoodLog> logsInFireplace;
    private List<WoodLog> logsAfterBurn;
    private double timeOfBurn = 0;
    private double size;
    private double emptySpace;
    private String material;
    private LightCondition lightState = LightCondition.DARK;
    private TemperatureCondition temperatureState = TemperatureCondition.COLD;
    private double coefficientOfLayingFirewood;
    
    public Fireplace(String material, double coefficientOfLayingFirewood, double size) {
    	this.size = size;
    	emptySpace = size;
    	this.material = material;
    	this.coefficientOfLayingFirewood = coefficientOfLayingFirewood;
    	logs = new ArrayList<WoodLog>();
    	logsInFireplace = new ArrayList<WoodLog>();
    	logsAfterBurn = new ArrayList<WoodLog>();
        timeOfBurn = Calculator.calculateTimeOfBurn(timeOfBurnFromFuel(), coefficientOfLayingFirewood, size);
    }
    
    private void restoreFireplace() {
    	for (int i = logs.size() - 1; i >= 0; i--) {
    		if (logs.get(i).getSize() > emptySpace) {
    			break;
    		}else {
    			emptySpace -= logs.get(i).getSize();
    			logsInFireplace.add(logs.get(i));
    			logs.remove(i);
    		}
    	}
    }
    
    public void restoreLogs(List<WoodLog> logs) {
    	this.logs.addAll(logs);
    }
   
    private double timeOfBurnFromFuel() {
    	double time = 0;
    	for (int i = 0; i < logsInFireplace.size(); i++) {
    		time += logs.get(i).getTimeOfBurn();
    	}
    	return time;
    }

    private void destroyAfterBurn() {
    	if (logsAfterBurn.size() != 0) {
    		while (logsAfterBurn.size() != 0) logsAfterBurn.remove(logsAfterBurn.size() - 1);
    	}
    }
    
	@Override
	public boolean containFire() {
		if (logsInFireplace.size() != 0) {
			System.out.println("Камин горит");
			if (lightState == LightCondition.DARK) lightState = LightCondition.LIGHT;
			if (temperatureState == TemperatureCondition.COLD) temperatureState = TemperatureCondition.WARM;
			for (int i = logsInFireplace.size() - 1; i >= 0; i--) {
				if (!logsInFireplace.get(i).burn() && BurnCondition.AFTERBURN == logsInFireplace.get(i).getState()) {
					logsAfterBurn.add(logsInFireplace.get(i));
					emptySpace += logsInFireplace.get(i).getSize();
					logsInFireplace.remove(i);
				}
			}
			return true;
		}
		System.out.println("Камин не горит");
		if (lightState == LightCondition.LIGHT) lightState = LightCondition.DARK;
		if (temperatureState == TemperatureCondition.WARM) temperatureState = TemperatureCondition.COLD;
		return false;
	}

	@Override
	public void dynamicExist() {
		if (logsInFireplace.size() == 0) restoreFireplace();
		containFire();
		destroyAfterBurn();
	}
	
	public LightCondition getLightState() {
		return lightState;
	}
	
	public TemperatureCondition getTemperatureState() {
		return temperatureState;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public double getSize() {
		return size;
	}
	
	public double getTimeOfBurn() {
		return timeOfBurn;
	}
	
	public double getCoefficientOfLayingFirewood() {
		return coefficientOfLayingFirewood;
	}
}