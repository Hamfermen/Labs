package com.SecondLab.SpecialMoves;

import java.util.Random;

import ru.ifmo.se.pokemon.*;

public class ShadowBall extends SpecialMove{
	public ShadowBall() {
		super(Type.GHOST, 80, 1);
	}
	
	@Override
	public void applyOppEffects(Pokemon p) {
		p.setMod(Stat.SPECIAL_DEFENSE, new Random().nextInt(100) < 20 ? -1 : 0);
	}
	
	@Override
	public String describe() {
		return "use Shadow Ball";
	}
}