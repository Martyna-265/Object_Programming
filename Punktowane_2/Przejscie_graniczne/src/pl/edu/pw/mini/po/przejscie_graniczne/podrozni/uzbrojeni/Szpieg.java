package pl.edu.pw.mini.po.przejscie_graniczne.podrozni.uzbrojeni;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pl.edu.pw.mini.po.przejscie_graniczne.towary.Towar;

public class Szpieg extends UzbrojonyPodrozny {

	private static final Random random = new Random();
	
	public Szpieg(int unikalneId) {
		super(unikalneId);
		
		List<Towar> towary = new LinkedList<Towar>();
		int liczbaTowarow = random.nextInt(2, 4);
		for (int i = 0; i < liczbaTowarow; i++) {
			Towar towar = new Towar();
			towary.add(towar);
		}
		this.setTowary(towary);
	}

	public String toString() {
		return "Szpieg lat " + this.getWiek();
	}

}
