package com.SecondLab.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class Charm extends StatusMove{
	
	public Charm() {
		super(Type.FAIRY, 0, 1);
	}
	
	@Override
	public void applyOppEffects(Pokemon p) {
		p.setMod(Stat.ATTACK, -2);
	}
	
	@Override
	public String describe() {
		return "use Charm";
	}
}

