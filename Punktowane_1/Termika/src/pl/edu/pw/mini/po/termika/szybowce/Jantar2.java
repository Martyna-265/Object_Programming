package pl.edu.pw.mini.po.termika.szybowce;

import pl.edu.pw.mini.po.termika.teren.Teren;

public class Jantar2 extends Szybowce {

	public Jantar2(Teren generatorTerenu, int aktualnaWysokosc) {
		super(generatorTerenu, aktualnaWysokosc);
	}
	
	@Override
	public String toString() {
		return "Jantar 2 [aktualna wysokosc: " + this.getAktualnawysokosc() + "]";
	}

	@Override
	public void fly() {
		super.fly();
		if (this.getAktualnawysokosc()!=0) {
			System.out.println(this.getAktualnawysokosc());
		}
	}

}
