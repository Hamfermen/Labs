package com.SecondLab.ThirdPart;

import com.SecondLab.SpecialMoves.ChargeBeam;
import com.SecondLab.SpecialMoves.ShadowBall;
import com.SecondLab.StatusMoves.Charm;
import com.SecondLab.StatusMoves.WillOWisp;

import ru.ifmo.se.pokemon.Type;

public class Gallade extends Kirlia{
	
	public Gallade() {
		super("Gallade", 1, 68, 125, 65, 65, 115, 80);
		super.newTypes(Type.PSYCHIC, Type.FIGHTING);
		super.addMove(new ChargeBeam());
		super.addMove(new WillOWisp());
		super.addMove(new Charm());
		super.addMove(new ShadowBall());
	}
}
