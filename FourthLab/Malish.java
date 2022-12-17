package com.ThirdLab.Classes;

import java.util.Random;

public class Malish extends Human {

	private Random rn;
	private static Malish malish = null;
	
	public static Malish getMalish() {
		if (malish == null) malish = new Malish();
		return malish;
	}
	
    private Malish() {
    	super("Малыш");
    	rn = new Random();
    }

	@Override
	public String move(Room room) {
		int whatNow = rn.nextInt(4);
		switch(whatNow) {
		case 0:
			return "окну";
		case 1:
			return "двери";
		case 2:
			return "верстаку";
		case 3:
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
    		case 1,8,9:
    			super.addLogsToFireplace(room.getFireplace(), rn.nextInt(10) + 1);
    			System.out.println(super.getName() + " добавил берёзовых дров в камин");
    			break;
    		case 2:
    			super.addKeroseneToKeroseneLamp(room.getKeroseneLamp(), rn.nextInt(10) + 1);
    			System.out.println(super.getName() + " добавил керосина в лампу");
    			break;
    		case 3:
    			System.out.print(super.getName() + " ");
    			super.eat(room);
    			break;
    		case 4:
    			System.out.println(super.getName() + " подошёл к " + move(room));
    			break;
    		case 5,6,7,10,11:
    			super.think();
    			System.out.println("подумал " + super.getName());
    			break;
    		default:
    			System.out.println(super.getName() + " отдыхает");
    			break;
    	}
		
	}

}
