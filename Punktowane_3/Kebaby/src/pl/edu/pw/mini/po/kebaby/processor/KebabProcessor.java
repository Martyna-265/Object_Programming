package pl.edu.pw.mini.po.kebaby.processor;

import java.util.List;

import pl.edu.pw.mini.po.kebaby.Kebab;
import pl.edu.pw.mini.po.kebaby.KebabNaTalerzu;

public class KebabProcessor {

	public static List<KebabNaTalerzu> getSmallTellerKebabs(List<Kebab> kebaby) {
		KebabNaTalerzuVisitor visitor = new KebabNaTalerzuVisitor();
		for (Kebab kebab : kebaby) {
			kebab.apply(visitor);
		}
		return visitor.getKebabyNaTalerzu();
	}
	
	public static void getSummary(List<Kebab> kebaby) {
		Double cena = 0d;
		int waga = 0;
		for (Kebab kebab : kebaby) {
			System.out.println(kebab);
			cena += kebab.getCena();
			waga += kebab.getWaga();
		}
		System.out.println("Srednia cena: " + cena / kebaby.size());
		System.out.println("Laczna waga: " + waga);
	}
	
}
