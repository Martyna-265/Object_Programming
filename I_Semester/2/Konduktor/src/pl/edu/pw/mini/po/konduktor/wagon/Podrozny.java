package pl.edu.pw.mini.po.konduktor.wagon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.edu.pw.mini.po.konduktor.bilety.Bilet;
import pl.edu.pw.mini.po.konduktor.bilety.Imie;
import pl.edu.pw.mini.po.konduktor.bilety.Nazwisko;
import pl.edu.pw.mini.po.konduktor.bilety.Relacja;
import pl.edu.pw.mini.po.konduktor.bilety.kasowniki.SystemSprzedazyBiletow;

public class Podrozny implements Comparable<Podrozny>{
	
	private static final Random random = new Random();
	
	private Imie imie;
	private Nazwisko nazwisko;
	private Bilet bilet;
	private int stopienWyglodzenia;
	private SystemSprzedazyBiletow system;
	
	private List<Imie> imiona = new ArrayList<Imie>();{
		for (int i=0; i<10; i++) {
			imiona.add(Imie.values()[i]);
		}
	}
	
	private List<Nazwisko> nazwiska = new ArrayList<Nazwisko>();{
		for (int i=0; i<10; i++) {
			nazwiska.add(Nazwisko.values()[i]);
		}
	}
	
	public Podrozny(SystemSprzedazyBiletow system) {
		this.imie = imiona.get(random.nextInt(10));
		this.nazwisko = nazwiska.get(random.nextInt(10));
		this.system = system;
		this.stopienWyglodzenia = random.nextInt(10)+1;
		this.bilet = system.sprzedajBilet(imie, nazwisko, Relacja.values()[random.nextInt(1)]);
	}

	public Bilet getBilet() {
		return bilet;
	}

	@Override
	public int compareTo(Podrozny o) {
		return this.stopienWyglodzenia - o.stopienWyglodzenia;
	}
	
}
