package com.SecondLab.ThirdPart;

import com.SecondLab.SpecialMoves.ChargeBeam;
import com.SecondLab.StatusMoves.Charm;
import com.SecondLab.StatusMoves.WillOWisp;

public class Kirlia extends Ralts{
	
	public Kirlia() {
		super("Kirlia", 28, 38, 35, 35, 65, 55, 50);
		super.addMove(new ChargeBeam());
		super.addMove(new WillOWisp());
		super.addMove(new Charm());
	}
	
	public Kirlia(String name, int level, double hp, double attack, double defense, double special_attack, double special_defense, double speed) {
		super(name, level, hp, attack, defense, special_attack, special_defense, speed);
	}
}

