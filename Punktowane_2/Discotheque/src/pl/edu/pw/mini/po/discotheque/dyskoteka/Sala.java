package pl.edu.pw.mini.po.discotheque.dyskoteka;

import java.util.LinkedHashSet;

import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.Uczestnik;

public class Sala {

	private LinkedHashSet<Uczestnik> uczestnicy;
	private int maksymalnaPojemnosc;
	
	public Sala(int maksymalnaPojemnosc) {
		this.uczestnicy = new LinkedHashSet<Uczestnik>();
		this.maksymalnaPojemnosc = maksymalnaPojemnosc;
	}
	
	public boolean jestNaSali(Uczestnik uczestnik) {
		if (uczestnicy.contains(uczestnik)) {
			return true;
		}
		return false;
	}
	
	public void dodajUczestnika(Uczestnik uczestnik) throws PrzepelnionaSalaException{
		if (uczestnicy.size()==maksymalnaPojemnosc) {
			throw new PrzepelnionaSalaException();
		}
		else {
			uczestnicy.add(uczestnik);
		}
	}
	
}
