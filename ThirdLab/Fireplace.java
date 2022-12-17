package com.ThirdLab.Classes;

import java.util.*;

public class Fireplace implements CanContainFire, DynamicObjects {

	private List<WoodLog> logs;
	private List<WoodLog> logsInFireplace;
	private List<WoodLog> logsAfterBurn;
	private double timeOfBurn = 0;
	private double size;
	private double emptySpace;
	private String material;
	private LightCondition lightState = LightCondition.DARK;
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
			} else {
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
			while (logsAfterBurn.size() != 0)
				logsAfterBurn.remove(logsAfterBurn.size() - 1);
		}
	}

	@Override
	public boolean containFire() {
		if (logsInFireplace.size() != 0) {
			System.out.println("Камин горит");
			if (lightState == LightCondition.DARK)
				lightState = LightCondition.LIGHT;
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
		if (lightState == LightCondition.LIGHT)
			lightState = LightCondition.DARK;
		return false;
	}

	@Override
	public void dynamicExist() {
		if (logsInFireplace.size() == 0)
			restoreFireplace();
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

	@Override
	public String toString() {
		return "Fireplace [logs=" + logs + ", logsInFireplace=" + logsInFireplace + ", logsAfterBurn=" + logsAfterBurn
				+ ", timeOfBurn=" + timeOfBurn + ", size=" + size + ", emptySpace=" + emptySpace + ", material="
				+ material + ", lightState=" + lightState + ", coefficientOfLayingFirewood=" + coefficientOfLayingFirewood + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coefficientOfLayingFirewood);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(emptySpace);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lightState == null) ? 0 : lightState.hashCode());
		result = prime * result + ((logs == null) ? 0 : logs.hashCode());
		result = prime * result + ((logsAfterBurn == null) ? 0 : logsAfterBurn.hashCode());
		result = prime * result + ((logsInFireplace == null) ? 0 : logsInFireplace.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(timeOfBurn);
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
		Fireplace other = (Fireplace) obj;
		if (Double.doubleToLongBits(coefficientOfLayingFirewood) != Double
				.doubleToLongBits(other.coefficientOfLayingFirewood)) {
			return false;
		}
		if (Double.doubleToLongBits(emptySpace) != Double.doubleToLongBits(other.emptySpace)) {
			return false;
		}
		if (lightState != other.lightState) {
			return false;
		}
		if (logs == null) {
			if (other.logs != null) {
				return false;
			}
		} else if (!logs.equals(other.logs)) {
			return false;
		}
		if (logsAfterBurn == null) {
			if (other.logsAfterBurn != null) {
				return false;
			}
		} else if (!logsAfterBurn.equals(other.logsAfterBurn)) {
			return false;
		}
		if (logsInFireplace == null) {
			if (other.logsInFireplace != null) {
				return false;
			}
		} else if (!logsInFireplace.equals(other.logsInFireplace)) {
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
		if (Double.doubleToLongBits(timeOfBurn) != Double.doubleToLongBits(other.timeOfBurn)) {
			return false;
		}
		return true;
	}
}
