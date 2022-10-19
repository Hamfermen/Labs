package com.SecondLab.PhysicalMoves;

import ru.ifmo.se.pokemon.*;

public class BrutalSwing extends PhysicalMove{
	
	public BrutalSwing() {
		super(Type.DARK, 60, 1);
	}
	
	@Override
	public String describe(){
		return "use Brutal Swing";
	}
	
	
	
}
