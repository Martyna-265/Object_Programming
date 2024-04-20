package pl.edu.pw.mini.po.przejscie_graniczne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import pl.edu.pw.mini.po.przejscie_graniczne.kontrola.Areszt;
import pl.edu.pw.mini.po.przejscie_graniczne.kontrola.Celnik;
import pl.edu.pw.mini.po.przejscie_graniczne.kontrola.NieletniException;
import pl.edu.pw.mini.po.przejscie_graniczne.podrozni.Podrozny;
import pl.edu.pw.mini.po.przejscie_graniczne.podrozni.Turysta;
import pl.edu.pw.mini.po.przejscie_graniczne.podrozni.uzbrojeni.Przemytnik;
import pl.edu.pw.mini.po.przejscie_graniczne.podrozni.uzbrojeni.Szpieg;

public class PrzejscieGraniczne {

	private static final Random random = new Random();
	
	private List<Podrozny> podrozni;
	private List<Celnik> celnicy;
	private Areszt areszt;

	public PrzejscieGraniczne() {
		this.podrozni = new LinkedList<Podrozny>();
		this.celnicy = new ArrayList<Celnik>();
		
		int i = 0;
		while (i < 50) {
			podrozni.add(new Turysta(i));
		}
		System.out.println("Dodano turystow");
		while (i < 100) {
			podrozni.add(new Przemytnik(i));
		}
		System.out.println("Dodano przemytnikow");
		while (i < 150) {
			podrozni.add(new Szpieg(i));
		}
		System.out.println("Dodano szpiegow");
		Collections.shuffle(podrozni);
		
		for (int j = 0; j < 5; j++) {
			celnicy.add(new Celnik(areszt, podrozni));
		}
	}
	
	public void doJob() {
		for (Podrozny podrozny : podrozni) {
			Celnik celnik = celnicy.get(random.nextInt(celnicy.size()));
			try {
				celnik.control(podrozny);
			} catch (NieletniException e) {
				e.printStackTrace();
			}
			podrozni.remove(podrozny);
		}
	}
	
}
