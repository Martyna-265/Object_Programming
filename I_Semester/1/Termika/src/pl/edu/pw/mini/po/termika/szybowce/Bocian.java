package pl.edu.pw.mini.po.termika.szybowce;

import pl.edu.pw.mini.po.termika.teren.Teren;

public class Bocian extends Szybowce {

	public Bocian(Teren generatorTerenu, int aktualnaWysokosc) {
		super(generatorTerenu, aktualnaWysokosc);
	}

	@Override
	public String toString() {
		return "Bocian [aktualna wysokosc: " + this.getAktualnawysokosc() + "]";
	}

	@Override
	public void fly() {
		if (this.getAktualnawysokosc()!=0) {
			System.out.println("Lece jak prawdziwy Bocian!");
		}
		super.fly();
	}

}
