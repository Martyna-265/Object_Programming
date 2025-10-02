package pl.edu.pw.mini.po.przejscie_graniczne.kontrola;

import java.util.List;
import java.util.Random;
import java.util.Set;

import pl.edu.pw.mini.po.przejscie_graniczne.podrozni.Podrozny;
import pl.edu.pw.mini.po.przejscie_graniczne.towary.Towar;
import pl.edu.pw.mini.po.przejscie_graniczne.towary.TrefnyTowar;
import pl.edu.pw.mini.po.przejscie_graniczne.towary.TowarVisitor;

public class Celnik {

	private static final Random random = new Random();
	
	private Areszt areszt;
	private List<Podrozny> podrozni;
	
	public Celnik(Areszt areszt, List<Podrozny> podrozni) {
		this.areszt = areszt;
		this.podrozni = podrozni;
	}
	
	public void control(Podrozny podrozny) throws NieletniException {
		int sprawdzenie = random.nextInt(10);
		if (sprawdzenie < 2) {
			System.out.println("Kontrola podróżnego: " + podrozny);
			System.out.println("Towary:");
			sprawdzTowar(podrozny);
		}
	}
	
	public void sprawdzTowar(Podrozny podrozny) throws NieletniException {
		List<Towar> towary = podrozny.getTowary();
		int sumaWartosciCzarnorynkowej = 0;
		for (Towar towar : towary) {
			// Tutaj powinno być sprawdzenie visitorem, ale nie ma
			System.out.println("- " + towar.getNazwa());
//			if (towar instanceof TrefnyTowar) {
//				towar = (TrefnyTowar) towar;
//				System.out.println("wartosc czarnorynkowa: " + ((TrefnyTowar) towar).getWartoscCzarnorynkowa());
//				sumaWartosciCzarnorynkowej += ((TrefnyTowar) towar).getWartoscCzarnorynkowa();
//			}
			// Już jest sprawdzenie visitorem! :)
			TowarVisitor visitor = new TowarVisitor();
			towar.accept(visitor);
			sumaWartosciCzarnorynkowej += visitor.getSumaWartosciCzarnorynkowej();
		}
		System.out.println("Suma wartosci czarnorynkowej: " + sumaWartosciCzarnorynkowej);
		if (sumaWartosciCzarnorynkowej > 25000) {
			System.out.println("Jest pan aresztowany!");
			areszt.aresztuj(podrozny);
		}
		else {
			System.out.println("Wszystko w porządku, może pan jechać dalej.");
		}
	}
	
}
