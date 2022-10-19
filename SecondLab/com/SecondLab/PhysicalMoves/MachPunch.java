package com.SecondLab.PhysicalMoves;

import ru.ifmo.se.pokemon.*;

public class MachPunch extends PhysicalMove{
		
	public MachPunch() {
		super(Type.FIGHTING, 40, 1, 1, 1);
	}
	
	@Override
	public String describe(){
		return "use Mach Punch";
	}

}
