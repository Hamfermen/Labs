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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(density);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		temp = Double.doubleToLongBits(timeOfBurn);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(volume);
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
		Kerosene other = (Kerosene) obj;
		if (Double.doubleToLongBits(density) != Double.doubleToLongBits(other.density)) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		if (Double.doubleToLongBits(timeOfBurn) != Double.doubleToLongBits(other.timeOfBurn)) {
			return false;
		}
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Kerosene [timeOfBurn=" + timeOfBurn + ", volume=" + volume + ", density=" + density + ", state=" + state
				+ "]";
	}
    

}