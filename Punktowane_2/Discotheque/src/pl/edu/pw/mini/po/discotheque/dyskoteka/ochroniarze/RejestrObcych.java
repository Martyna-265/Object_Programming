package pl.edu.pw.mini.po.discotheque.dyskoteka.ochroniarze;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.ludzie_z_zewnatrz.CzlowiekZZewnatrz;

public class RejestrObcych {

	private HashMap<String, Set<CzlowiekZZewnatrz>> listaObcych;

	public RejestrObcych() {
		this.listaObcych = new HashMap<String, Set<CzlowiekZZewnatrz>>();
	}
	
	public boolean moznaDodac(CzlowiekZZewnatrz uczestnik) {
		if (listaObcych.containsKey(uczestnik.getImie())) {
			Set<CzlowiekZZewnatrz> uczestnicy = listaObcych.get(uczestnik.getImie());
			if (uczestnicy.contains(uczestnik)) {
				return false;
			}
		}
		return true;
	}
	
	public void dodaj(CzlowiekZZewnatrz uczestnik) {
		Set<CzlowiekZZewnatrz> kolekcja = new HashSet<CzlowiekZZewnatrz>();
		if (listaObcych.containsKey(uczestnik.getImie())) {
			kolekcja = listaObcych.get(uczestnik.getImie());
		}
		kolekcja.add(uczestnik);
		listaObcych.put(uczestnik.getImie(), kolekcja);
	}

	public HashMap<String, Set<CzlowiekZZewnatrz>> getListaObcych() {
		return listaObcych;
	}
	
}
