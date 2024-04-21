package pl.edu.pw.mini.po.konduktor.bilety.kasowniki;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import pl.edu.pw.mini.po.konduktor.bilety.Bilet;

public class KasownikDoBiletowOffline extends KasownikDoBiletow {

	private Set<Bilet> sprzedaneBilety; // ja bym dala linked listę
	private Set<Bilet> sprawdzoneBilety;

	public KasownikDoBiletowOffline(SystemSprzedazyBiletow system) {
		super(system);
		this.sprzedaneBilety = new LinkedHashSet<Bilet>();
		this.sprawdzoneBilety = new HashSet<Bilet>();
	}
	
	public boolean walidujBilet(Bilet bilet) {
		if (sprzedaneBilety.contains(bilet)) {
			sprawdzoneBilety.add(bilet);
			sprzedaneBilety.remove(bilet);
			return true;
		}
		return false;
	}
	
	public void wgrajInformacjeOSprzedanychBiletach() {
		Set<Bilet> sprzedaneBiletySystem = this.getSystem().getSprzedaneBilety();
		sprzedaneBilety.clear();
		sprzedaneBilety.addAll(sprzedaneBiletySystem);
	}
	
}
