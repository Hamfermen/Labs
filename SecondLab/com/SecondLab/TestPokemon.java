package com.SecondLab;

import com.SecondLab.FirstPart.Heracross;
import com.SecondLab.SecondPart.Hitmonchan;
import com.SecondLab.SecondPart.Tyrogue;
import com.SecondLab.ThirdPart.Gallade;
import com.SecondLab.ThirdPart.Kirlia;
import com.SecondLab.ThirdPart.Ralts;

import ru.ifmo.se.pokemon.*;

public class TestPokemon {

	public static void main(String[] args) {
		Hitmonchan hitmonchan = new Hitmonchan();
		Tyrogue tyrogue = new Tyrogue();
		Heracross heracross = new Heracross();
		Ralts ralts = new Ralts();
		Kirlia kirlia = new Kirlia();
		Gallade gallade = new Gallade();
		Battle b = new Battle();
		b.addAlly(hitmonchan);
		b.addFoe(tyrogue);
		b.addAlly(heracross);
		b.addFoe(ralts);
		b.addAlly(kirlia);
		b.addFoe(gallade);
		b.go();
	}

}
