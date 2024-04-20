package pl.edu.pw.mini.po.przejscie_graniczne.kontrola;

import java.util.Set;
import java.util.TreeSet;

import pl.edu.pw.mini.po.przejscie_graniczne.podrozni.Podrozny;

public class Areszt {

	private Set<Podrozny> aresztowani;

	public Areszt() {
		this.aresztowani = new TreeSet<Podrozny>();
	}
	
	public void aresztuj(Podrozny zbrodniarz) throws NieletniException {
		if (zbrodniarz.getWiek() < 18){
			throw new NieletniException();
		}
		else {
			aresztowani.add(zbrodniarz);
		}
	}
	
}
