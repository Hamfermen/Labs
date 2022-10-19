package com.SecondLab.PhysicalMoves;

import ru.ifmo.se.pokemon.*;

public class Megahorn extends PhysicalMove{
		
	public Megahorn() {
		super(Type.BUG, 120, 0.85);
	}
	
	@Override
	public String describe(){
		return "use Megahorn";
	}

}
