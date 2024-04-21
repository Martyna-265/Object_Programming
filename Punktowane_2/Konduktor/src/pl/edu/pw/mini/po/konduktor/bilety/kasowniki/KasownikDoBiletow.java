package pl.edu.pw.mini.po.konduktor.bilety.kasowniki;

import pl.edu.pw.mini.po.konduktor.bilety.Bilet;

public abstract class KasownikDoBiletow implements SprawdzaczBiletow{

	private SystemSprzedazyBiletow system;
	
	public KasownikDoBiletow(SystemSprzedazyBiletow system) {
		this.system = system;
	}

	public boolean walidujBilet(Bilet bilet) throws BrakZasieguException {
		return true;
	}

	public SystemSprzedazyBiletow getSystem() {
		return system;
	}
	
}
