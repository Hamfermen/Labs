package com.ThirdLab.Classes;

import java.util.*;

public abstract class Human{

	private Random rn;
	private String name;
	
    public Human(String name) {
    	rn = new Random();
    	this.name = name;
    }

    public abstract String move(Room room);
    
    public void think() {
    	final class TextGenerator {
    		public TextGenerator() {}
    		
    		private String[] nouns = {"бревно","камин","еда","время года","дни","лампа","керосин","месяц","год","конец света","абсолютная пустота","комната"};
    		private String[] adjectives = {"Длинный","Вкусная","Холодное","Счастливые","Керосиновая","Березовое","Страшный","Длинный","Тяжелый","Каменный","Загадочная","Наша"};
    		private String[] verbs = {"горит","лежит","течёт","светит","идет","наступил","укатилось","прошёл","завершился","появится","существует"};
    		
    		private Random rn = new Random();
    		
    		public String generateText() {
    			return adjectives[rn.nextInt(adjectives.length)] + " " + nouns[rn.nextInt(nouns.length)] + " " + verbs[rn.nextInt(verbs.length)];
    		}
    	}
    	TextGenerator textGenerator = new TextGenerator();
    	System.out.print("\"" + textGenerator.generateText() + "\" - ");
    }

    public void eat(Room room) {
        int whatFood = rn.nextInt(room.getFoodList().size());
        room.getFoodList().get(whatFood).eatIt();;
    }

    public void turnSwitchOnLamp(Lamp lamp) {
    	if (lamp.isOn()) lamp.turnOff();
    	else lamp.turnOn(); 
    }
    
    public void addLogsToFireplace(Fireplace fireplace, int n) {
    	List<WoodLog> local = new ArrayList<>();
    	for (int i = 0; i < n; i++) local.add(new Birch(rn.nextDouble(), rn.nextDouble(), rn.nextDouble(), rn.nextDouble()));
    	fireplace.restoreLogs(local);
    }
    
    public void addKeroseneToKeroseneLamp(KeroseneLamp keroseneLamp, int n) {
    	List<Kerosene> local = new ArrayList<>();
    	for (int i = 0; i < n; i++) local.add(new Kerosene(rn.nextDouble() / 10));
    	keroseneLamp.restoreKerosene(local);
    }

    public abstract void exist(Room room);
    
    public String getName() {
    	return name;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Human other = (Human) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + "]";
	}
    
}