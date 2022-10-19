package com.SecondLab.SpecialMoves;

import ru.ifmo.se.pokemon.*;

public class Venoshock extends SpecialMove{
	public Venoshock() {
		super(Type.POISON, 65, 1);
	}
	
	@Override
	public void applyOppDamage(Pokemon p, double dam) {
		dam *= p.getCondition() == Status.POISON ? 2 : 1;
		p.setMod(Stat.HP, (int) Math.round(dam));
	}
	
	@Override
	public String describe() {
		return "use Venoshock";
	}
}
