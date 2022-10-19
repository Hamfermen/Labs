package com.SecondLab.FirstPart;

import com.SecondLab.PhysicalMoves.BrutalSwing;
import com.SecondLab.PhysicalMoves.Megahorn;
import com.SecondLab.SpecialMoves.Venoshock;
import com.SecondLab.StatusMoves.Leer;

import ru.ifmo.se.pokemon.*;

public class Heracross extends Pokemon{
	
	public Type[] types = {Type.BUG, Type.FIGHTING};
	
	public Heracross() {
		super("Heracross", 55);
		super.setStats(80, 125, 75, 40, 95, 85);
		super.setType(types);
		super.addMove(new BrutalSwing());
		super.addMove(new Leer());
		super.addMove(new Venoshock());
		super.addMove(new Megahorn());
	}
}
