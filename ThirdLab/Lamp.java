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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isOn ? 1231 : 1237);
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		long temp;
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Lamp other = (Lamp) obj;
		if (isOn != other.isOn) {
			return false;
		}
		if (material == null) {
			if (other.material != null) {
				return false;
			}
		} else if (!material.equals(other.material)) {
			return false;
		}
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Lamp [isOn=" + isOn + ", type=" + type + ", size=" + size + ", material=" + material + "]";
	}
    
    
}