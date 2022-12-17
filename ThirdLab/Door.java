package com.ThirdLab.Classes;

public class Door {

	private String material;
	private double lenght; 
	private double width;

    public Door(String material, double lenght, double width) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lenght);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Door other = (Door) obj;
		if (Double.doubleToLongBits(lenght) != Double.doubleToLongBits(other.lenght)) {
			return false;
		}
		if (material == null) {
			if (other.material != null) {
				return false;
			}
		} else if (!material.equals(other.material)) {
			return false;
		}
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Door [material=" + material + ", lenght=" + lenght + ", width=" + width + "]";
	}

}