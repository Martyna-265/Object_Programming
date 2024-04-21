package pl.edu.pw.mini.po.konduktor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import pl.edu.pw.mini.po.konduktor.bilety.Bilet;
import pl.edu.pw.mini.po.konduktor.bilety.kasowniki.BrakZasieguException;
import pl.edu.pw.mini.po.konduktor.bilety.kasowniki.KasownikDoBiletow;
import pl.edu.pw.mini.po.konduktor.wagon.Podrozny;
import pl.edu.pw.mini.po.konduktor.wagon.Stolik;
import pl.edu.pw.mini.po.konduktor.wagon.Wagon;

public class Konduktor {

	private Map<Podrozny, Bilet> niewazneBilety;
	private KasownikDoBiletow kasownikDoBiletow;
	private Wagon wagon;
	
	public Konduktor(KasownikDoBiletow kasownikDoBiletow, Wagon wagon) {
		this.niewazneBilety = new HashMap<Podrozny, Bilet>();
		this.kasownikDoBiletow = kasownikDoBiletow;
		this.wagon = wagon;
	}
	
	public void go() {
		Map<Stolik, TreeSet<Podrozny>> pasazerowiePrzyStoliku = wagon.getPasazerowiePrzyStoliku();
		for (Stolik stolik: pasazerowiePrzyStoliku.keySet()) {
			TreeSet<Podrozny> podrozni = pasazerowiePrzyStoliku.get(stolik);
			Iterator<Podrozny> i = podrozni.iterator();
			while(i.hasNext()) {
				Podrozny podrozny = i.next();
				Bilet bilet = podrozny.getBilet();
				try {
					boolean wazny = kasownikDoBiletow.walidujBilet(bilet);
					if (!wazny) {
						System.out.println("Bilet jest nieważny");
						niewazneBilety.put(podrozny, bilet);
						i.remove();
					}
				} catch (BrakZasieguException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Liczba niewaznych biletow: " + niewazneBilety.size());
	}
	
}
