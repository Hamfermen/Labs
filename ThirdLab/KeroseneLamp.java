package com.ThirdLab.Classes;

import java.util.ArrayList;
import java.util.List;

public class KeroseneLamp extends Lamp implements CanContainFire,DynamicObjects {

	private List<Kerosene> fuel;
    private List<Kerosene> fuelInFireplace;
    private List<Kerosene> fuelAfterBurn;
    private double timeOfBurn = 0;
    private double size;
    private double emptySpace;
    private LightCondition lightState = LightCondition.DARK;

    public KeroseneLamp(String material, double size) {
    	this("Kerosene Lamp", material, size);
    }
    
    private KeroseneLamp(String type, String material, double size) {
    	super(type, material, size);
    	this.size = size;
    	emptySpace = size;
    	fuel = new ArrayList<Kerosene>();
    	fuelInFireplace = new ArrayList<Kerosene>();
    	fuelAfterBurn = new ArrayList<Kerosene>();
    	timeOfBurn = Calculator.calculateTimeOfBurn(timeOfBurnFromFuel(), 1, size);
    }
    
    private void restoreKeroseneLamp() {
    	for (int i = fuel.size() - 1; i >= 0; i--) {
    		if (fuel.get(i).getVolume() > emptySpace) {
    			break;
    		}else {
    			emptySpace -= fuel.get(i).getVolume();
    			fuelInFireplace.add(fuel.get(i));
    			fuel.remove(i);
    		}
    	}
    }
    
    public void restoreKerosene(List<Kerosene> fuel) {
    	this.fuel.addAll(fuel);
    }
   
    private double timeOfBurnFromFuel() {
    	double time = 0;
    	for (int i = 0; i < fuelInFireplace.size(); i++) {
    		time += fuel.get(i).getTimeOfBurn();
    	}
    	return time;
    }

    private void destroyAfterBurn() {
    	if (fuelAfterBurn.size() != 0) {
    		while (fuelAfterBurn.size() != 0) fuelAfterBurn.remove(fuelAfterBurn.size() - 1);
    	}
    }
    
	@Override
	public boolean containFire() {
		if (fuelInFireplace.size() != 0) {
			System.out.println("Керосиновая лампа горит");
			if (lightState == LightCondition.DARK) lightState = LightCondition.LIGHT;
			for (int i = fuelInFireplace.size() - 1; i >= 0; i--) {
				if (!fuelInFireplace.get(i).burn() && BurnCondition.AFTERBURN == fuelInFireplace.get(i).getState()) {
					fuelAfterBurn.add(fuelInFireplace.get(i));
					emptySpace += fuelInFireplace.get(i).getVolume();
					fuelInFireplace.remove(i);
				}
			}
			return true;
		}
		System.out.println("Керосиновая лампа не горит");
		if (lightState == LightCondition.LIGHT) lightState = LightCondition.DARK;
		return false;
	}

	@Override
	public void dynamicExist() {
		if (fuelInFireplace.size() == 0) restoreKeroseneLamp();
		if (super.isOn()) {
			containFire();
		} else {
			if (lightState == LightCondition.LIGHT) lightState = LightCondition.DARK;
			System.out.println("Лампа выключена");
		}
		destroyAfterBurn();
	}
	
	public LightCondition getLightState() {
		return lightState;
	}
	
	public double getSize() {
		return size;
	}
	
	public double getTimeOfBurn() {
		return timeOfBurn;
	}

}
