package com.ThirdLab.Classes;

public class Food {
	
	private String flavor;
	private String food_type;
	private String howEatIt;
	
	public Food(String flavor, String food_type, String howEatIt) {
		this.flavor = flavor;
		this.food_type = food_type;
		this.howEatIt = howEatIt;
	}
	
	public void eatIt() {;
		System.out.println(howEatIt + " " + flavor + " " + food_type);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + ((food_type == null) ? 0 : food_type.hashCode());
		result = prime * result + ((howEatIt == null) ? 0 : howEatIt.hashCode());
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
		Food other = (Food) obj;
		if (flavor == null) {
			if (other.flavor != null) {
				return false;
			}
		} else if (!flavor.equals(other.flavor)) {
			return false;
		}
		if (food_type == null) {
			if (other.food_type != null) {
				return false;
			}
		} else if (!food_type.equals(other.food_type)) {
			return false;
		}
		if (howEatIt == null) {
			if (other.howEatIt != null) {
				return false;
			}
		} else if (!howEatIt.equals(other.howEatIt)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Food [flavor=" + flavor + ", food_type=" + food_type + ", howEatIt=" + howEatIt + "]";
	}
	
	
}
