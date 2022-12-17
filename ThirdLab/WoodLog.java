package com.ThirdLab.Classes;

public class WoodLog implements CanBurn {
    
    private double timeOfBurn;
	private double width;
	private double height;
	private double lenght;
	private String type;
	private double humidity; 
	private double density;
	private double weight;
	private BurnCondition state = BurnCondition.NORMAL;

	public WoodLog(String type, double timeOfBurn, double weight, double width, double lenght, double height, double humidity, double density) {
		this.timeOfBurn = timeOfBurn;
		this.width = width;
		this.height = height;
		this.lenght = lenght;
		this.type = type;
		this.humidity = humidity;
		this.density = density;
		this.weight = weight;
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

	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(density);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(humidity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lenght);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		temp = Double.doubleToLongBits(timeOfBurn);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		WoodLog other = (WoodLog) obj;
		if (Double.doubleToLongBits(density) != Double.doubleToLongBits(other.density)) {
			return false;
		}
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			return false;
		}
		if (Double.doubleToLongBits(humidity) != Double.doubleToLongBits(other.humidity)) {
			return false;
		}
		if (Double.doubleToLongBits(lenght) != Double.doubleToLongBits(other.lenght)) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		if (Double.doubleToLongBits(timeOfBurn) != Double.doubleToLongBits(other.timeOfBurn)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight)) {
			return false;
		}
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width)) {
			return false;
		}
		return true;
	}

	
    @Override
	public String toString() {
		return "WoodLog [timeOfBurn=" + timeOfBurn + ", width=" + width + ", height=" + height + ", lenght=" + lenght
				+ ", type=" + type + ", humidity=" + humidity + ", density=" + density + ", weight=" + weight
				+ ", state=" + state + "]";
	}
    
    
}