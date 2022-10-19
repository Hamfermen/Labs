package com.SecondLab.SpecialMoves;

import ru.ifmo.se.pokemon.*;
import java.util.Random;

public class ChargeBeam extends SpecialMove{
	public ChargeBeam() {
		super(Type.ELECTRIC, 50, 0.9);
	}
	
	@Override
	public void applySelfEffects(Pokemon p) {
		p.setMod(Stat.SPECIAL_ATTACK, new Random().nextInt(100) < 70 ? 1 : 0);
	}
	
	@Override
	public String describe() {
		return "use Charge Beam";
	}
}