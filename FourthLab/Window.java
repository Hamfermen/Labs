package com.ThirdLab.Classes;

public class Window {
	
	private String material;
	private double lenght; 
	private double width;

    public Window(String material, double lenght, double width) {
    	this.lenght = lenght;
    	this.material = material;
    	this.width = width;
    }
    
    public String getMaterial() {
		return material;
	}
	
    public double getLenght() {
		return lenght;
	}
	
    public double getWidth() {
		return width;
	}
	
}