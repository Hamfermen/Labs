package com.SecondLab.SecondPart;

import com.SecondLab.PhysicalMoves.CometPunch;
import com.SecondLab.PhysicalMoves.LowSweep;
import com.SecondLab.PhysicalMoves.MachPunch;
import com.SecondLab.StatusMoves.WorkUp;

public class Hitmonchan extends Tyrogue{
	
	public Hitmonchan() {
		super("Hitmonchan", 4, 50, 105, 79, 35, 110, 76);
		super.addMove(new MachPunch());
		super.addMove(new LowSweep());
		super.addMove(new WorkUp());
		super.addMove(new CometPunch());
	}
	
	public Hitmonchan(String name, int level, double hp, double attack, double defense, double special_attack, double special_defense, double speed) {
		super(name, level, hp, attack, defense, special_attack, special_defense, speed);
	}
}
