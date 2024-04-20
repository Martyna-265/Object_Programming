package pl.edu.pw.mini.po.przejscie_graniczne.podrozni.uzbrojeni;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pl.edu.pw.mini.po.przejscie_graniczne.towary.Towar;
import pl.edu.pw.mini.po.przejscie_graniczne.towary.TrefnyTowar;

public class Przemytnik extends UzbrojonyPodrozny {

	private static final Random random = new Random();
	
	public Przemytnik(int unikalneId) {
		super(unikalneId);
		
		List<Towar> towary = new LinkedList<Towar>();
		int liczbaTowarow = random.nextInt(31);
		for (int i = 0; i < liczbaTowarow; i++) {
			int p = random.nextInt(10);
			if (p < 4) {
				Towar towar = new TrefnyTowar();
				towary.add(towar);
			}
			else {
				Towar towar = new Towar();
				towary.add(towar);
			}
		}
		this.setTowary(towary);
	}
	
	public String toString() {
		return "Przemytnik lat " + this.getWiek();
	}

}
