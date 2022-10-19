package com.SecondLab.SecondPart;

import com.SecondLab.PhysicalMoves.LowSweep;
import com.SecondLab.PhysicalMoves.MachPunch;
import com.SecondLab.StatusMoves.WorkUp;

import ru.ifmo.se.pokemon.*;

public class Tyrogue extends Pokemon{
	
	protected Type[] types = {Type.FIGHTING};
	
	public Tyrogue() {
		super("Tyrogue", 1);
		super.setStats(35, 35, 35, 35, 35, 35);
		super.setType(types);
		super.addMove(new MachPunch());
		super.addMove(new LowSweep());
		super.addMove(new WorkUp());
	}
	
	public Tyrogue(String name, int level, double hp, double attack, double defense, double special_attack, double special_defense, double speed) {
		super(name, level);
		super.setStats(hp, attack, defense, special_attack, special_defense, speed);
		super.setType(types);
	}
}
