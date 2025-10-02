package pl.edu.pw.mini.po.przejscie_graniczne.podrozni;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pl.edu.pw.mini.po.przejscie_graniczne.towary.Towar;
import pl.edu.pw.mini.po.przejscie_graniczne.towary.TrefnyTowar;

public class Turysta extends Podrozny {

	private static final Random random = new Random();
	
	public Turysta(int unikalneId) {
		super(unikalneId, random.nextInt(14, 61));
		
		//Set<Towar> towary = new LinkedHashSet<Towar>();
		List<Towar> towary = new LinkedList<Towar>();
		int liczbaTowarow = random.nextInt(10, 21);
		for (int i = 0; i < liczbaTowarow; i++) {
			int p = random.nextInt(10);
			if (p < 1) {
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
		return "Turysta lat " + this.getWiek();
	}

}
