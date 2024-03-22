package pl.edu.pw.mini.po.grzybobranie.las.grzyby;

import java.util.Random;

public class MuchomorKolczastoglowy extends Grzyb {

	Random random = new Random();
	
	public MuchomorKolczastoglowy() {
		super();
		this.masaOwocnika = random.nextInt(25) + 25;
		this.trujacy = false;
	}
	
	@Override
	public String toString() {
		return "Muchomor Kolczastoglowy [twardosc = " + twardosc + ", masa owocnika = " + masaOwocnika + "]";
	}
	
}
