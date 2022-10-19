package com.SecondLab.ThirdPart;

import com.SecondLab.SpecialMoves.ChargeBeam;
import com.SecondLab.StatusMoves.WillOWisp;

import ru.ifmo.se.pokemon.*;

public class Ralts extends Pokemon{
	
	public Type[] types = {Type.PSYCHIC, Type.FAIRY};
	
	public Ralts() {
		super("Ralts", 1);
		super.setStats(28, 25, 25, 45, 35, 40);
		super.setType(types);
		super.addMove(new ChargeBeam());
		super.addMove(new WillOWisp());
	}
	
	public Ralts(String name, int level, double hp, double attack, double defense, double special_attack, double special_defense, double speed) {
		super(name, level);
		super.setStats(hp, attack, defense, special_attack, special_defense, speed);
		super.setType(types);
	}
	
	protected void newTypes(Type...types) {
		super.setType(types);
	}
}
