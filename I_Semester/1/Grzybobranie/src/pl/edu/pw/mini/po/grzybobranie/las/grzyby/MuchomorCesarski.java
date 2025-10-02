package pl.edu.pw.mini.po.grzybobranie.las.grzyby;

import java.util.Random;

public class MuchomorCesarski extends Grzyb {

	Random random = new Random();
	
	public MuchomorCesarski() {
		super();
		this.twardosc = Twardosc.TWARDY;
		this.masaOwocnika = random.nextInt(25) + 50;
		this.trujacy = false;
	}

	@Override
	public String toString() {
		return "Muchomor Cesarski [twardosc = " + twardosc + ", masa owocnika = " + masaOwocnika + "]";
	}

}
