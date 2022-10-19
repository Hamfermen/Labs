package com.SecondLab.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class WillOWisp extends StatusMove{
	
	public WillOWisp() {
		super(Type.FIRE, 0, 0.85);
	}
	
	@Override
	public void applyOppEffects(Pokemon p) {
		Effect.burn(p);
	}
	
	@Override
	public String describe() {
		return "use Will-O-Wisp";
	}
}
