package pl.edu.pw.mini.po.bozena.podloze.rosliny;

import java.util.Random;

public class Trawa extends Roslina {

	Random random = new Random();
	
	public Trawa() {
		super();
		this.wysokosc = random.nextDouble(40) + 10.5;
		this.ekologiczna = true;
	}

}
