package com.ThirdLab.Classes;

public class Lamp {
	
	private boolean isOn = true;
	private String type;
	private double size;
	private String material;
	
    public Lamp(String type, String material, double size) {
    	this.type = type;
    	this.size = size;
    	this.material = material;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
    
    public boolean isOn() {
    	return isOn;
    }
    
    public String getType() {
    	return type;
    }
    
    public double getSize() {
    	return size;
    }
    
    public String getMaterial() {
		return material;
	}
}