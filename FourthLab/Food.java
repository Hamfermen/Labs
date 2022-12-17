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
}
