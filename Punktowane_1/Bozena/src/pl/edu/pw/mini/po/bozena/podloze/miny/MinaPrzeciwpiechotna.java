package pl.edu.pw.mini.po.bozena.podloze.miny;

import java.util.Random;

import pl.edu.pw.mini.po.bozena.podloze.Obudowa;

public class MinaPrzeciwpiechotna extends Mina {

	Random random = new Random();
	private Obudowa obudowa;
	
	public MinaPrzeciwpiechotna() {
		super();
		this.obudowa = Obudowa.values()[random.nextInt(2)];
		if (this.obudowa == Obudowa.KARTON) {
			this.ekologiczna = true;
		}
		else {
			this.ekologiczna = false;
		}
	}

	@Override
	public void pressMe() {
		if (this.uzbrojona) {
			System.out.println("Boom!");
		}
		else {
			super.pressMe();
		}
	}
	
}
