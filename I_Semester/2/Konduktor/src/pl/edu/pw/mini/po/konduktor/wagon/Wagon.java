package pl.edu.pw.mini.po.konduktor.wagon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import pl.edu.pw.mini.po.konduktor.bilety.Bilet;

public class Wagon {

	private static int liczbaStolikow = 8;
	private List<Stolik> stoliki;{
		stoliki = new ArrayList<Stolik>();
		for (int i=1; i<liczbaStolikow; i++) {
			stoliki.add(Stolik.values()[i]);
		}
	}
	
	private Map<Stolik, TreeSet<Podrozny>> pasazerowiePrzyStoliku;

	public Wagon(TreeSet<Podrozny> podrozni) {
		this.pasazerowiePrzyStoliku = new HashMap<Stolik, TreeSet<Podrozny>>();
		this.rozsadzPodroznych(podrozni);
	}
	
	private void rozsadzPodroznych(TreeSet<Podrozny> podrozni) {
		for (Podrozny podrozny: podrozni) {
			Bilet bilet = podrozny.getBilet();
			Stolik stolik = bilet.getNazwaStolika();
			if (pasazerowiePrzyStoliku.containsKey(stolik)) {
				TreeSet<Podrozny> starzyPodrozni = pasazerowiePrzyStoliku.get(stolik);
				starzyPodrozni.add(podrozny);
				pasazerowiePrzyStoliku.put(stolik, starzyPodrozni);
			}
			else {
				pasazerowiePrzyStoliku.put(stolik, podrozni);
			}
		}
	}
	
	public TreeSet<Podrozny> getPasazerowiePrzyStoliku(Stolik stolik){
		TreeSet<Podrozny> podrozni = pasazerowiePrzyStoliku.get(stolik);
		return podrozni;
	}

	public static int getLiczbaStolikow() {
		return liczbaStolikow;
	}

	public Map<Stolik, TreeSet<Podrozny>> getPasazerowiePrzyStoliku() {
		return pasazerowiePrzyStoliku;
	}
	
}
