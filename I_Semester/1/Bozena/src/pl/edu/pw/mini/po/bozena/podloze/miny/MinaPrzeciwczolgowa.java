package pl.edu.pw.mini.po.bozena.podloze.miny;

import java.util.Random;

public class MinaPrzeciwczolgowa extends Mina {

	Random random = new Random();
	private double masaMaterialuWybuchowego;

	public MinaPrzeciwczolgowa() {
		super();
		this.ekologiczna = false;
		this.masaMaterialuWybuchowego = random.nextDouble(1) + 1.5;
	}
	
	@Override
	public void pressMe() {
		if (this.uzbrojona) {
			System.out.println("Kaboom!");
		}
		else {
			super.pressMe();
		}
	}
	
	public String toString() {
		return "X";
	}
	
}
