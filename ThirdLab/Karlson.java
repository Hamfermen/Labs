package com.ThirdLab.Classes;

import java.util.*;

public class Karlson extends Human {

	private Random rn;
	private static Karlson karlson = null;
	
	public static Karlson getKarlson() {
		if (karlson == null) karlson = new Karlson();
		return karlson;
	}
	
    private Karlson() {
    	super("Карлосон");
    	rn = new Random();
    }

	@Override
	public String move(Room room) {
		int whatNow = rn.nextInt(5);
		switch(whatNow) {
		case 0:
			return "потолку";
		case 1:
			return "окну";
		case 2:
			return "двери";
		case 3:
			return "верстаку";
		case 4:
			return "стене";
		default:
			return "месту где стоит сейчас";
		}
	}

	@Override
	public void exist(Room room) {
		int whatNow = rn.nextInt(15);
    	switch(whatNow) {
    		case 0:
    			super.turnSwitchOnLamp(room.getKeroseneLamp());
    			System.out.println(super.getName() + " нажал на переключатель");
    			break;
    		case 1:
    			super.addLogsToFireplace(room.getFireplace(), rn.nextInt(10) + 1);
    			System.out.println(super.getName() + " добавил берёзовых дров в камин");
    			break;
    		case 2,8,9:
    			super.addKeroseneToKeroseneLamp(room.getKeroseneLamp(), rn.nextInt(10) + 1);
    			System.out.println(super.getName() + " добавил керосина в лампу");
    			break;
    		case 3,10,11,12,13:
    			System.out.print(super.getName() + " ");
				super.eat(room);
    			break;
    		case 4:
    			System.out.println(super.getName() + " подлетел к " + move(room));
    			break;
    		case 5,6,7:
    			super.think();
    			System.out.println("подумал " + super.getName());
    			break;
    		default:
    			System.out.println(super.getName() + " отдыхает");
    			break;
    	}
		
	}

}