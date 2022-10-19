package com.SecondLab.PhysicalMoves;

import java.util.Random;
import ru.ifmo.se.pokemon.*;


public class CometPunch extends PhysicalMove{
	
	static int punch_count = 0;
	
	public CometPunch() {
		super(Type.NORMAL, 18, 0.85);
	}
	
	@Override
	public void applySelfEffects(Pokemon p) {
		if (punch_count < 1) {
			int rn = new Random().nextInt(8);
			super.hits = punch_count = rn < 3 ? 2 : rn < 6 ? 3 : rn < 7 ? 4 : 5;
		}else punch_count--;
	}
	
	@Override
	public String describe(){
		return "use Comet Punch";
	}

}
