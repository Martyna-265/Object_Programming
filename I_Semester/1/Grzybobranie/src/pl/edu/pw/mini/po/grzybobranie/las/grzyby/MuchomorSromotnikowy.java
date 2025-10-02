package pl.edu.pw.mini.po.grzybobranie.las.grzyby;

import java.util.Random;

public class MuchomorSromotnikowy extends Grzyb {

	Random random = new Random();
	
	private Toksyny toksyny;

	public MuchomorSromotnikowy() {
		super();
		this.masaOwocnika = random.nextInt(50) + 25;
		if (this.masaOwocnika < 50) {
			this.toksyny = Toksyny.ZABOJCZE;
		}
		else {
			this.toksyny = Toksyny.WYJATKOWO_ZABOJCZE;
		}
	}

	@Override
	public String toString() {
		return "Muchomor Sromotnikowy [twardosc = " + twardosc + ", masa owocnika = " + masaOwocnika + ", toksyny = " + toksyny + "]";
	}
	
}
