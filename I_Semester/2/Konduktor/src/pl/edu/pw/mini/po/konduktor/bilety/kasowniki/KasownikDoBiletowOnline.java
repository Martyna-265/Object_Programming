package pl.edu.pw.mini.po.konduktor.bilety.kasowniki;

import java.util.Random;

import pl.edu.pw.mini.po.konduktor.bilety.Bilet;

public class KasownikDoBiletowOnline extends KasownikDoBiletow {

	private static final Random random = new Random();
	
	public KasownikDoBiletowOnline(SystemSprzedazyBiletow system) {
		super(system);
	}
	
	public boolean walidujBilet(Bilet bilet) throws BrakZasieguException{
		int p = random.nextInt(100);
		if (p < 2) {
			throw new BrakZasieguException("Brak zasiegu");
		}
		return this.getSystem().zweryfikujBilet(bilet);
	}

}
