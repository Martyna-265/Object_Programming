package pl.edu.pw.mini.po.grzybobranie.las.grzyby;

import java.util.Random;

public abstract class Grzyb {

	Random random = new Random();
	
	protected Twardosc twardosc;
	protected int masaOwocnika;
	protected boolean trujacy;

	public Grzyb() {
		this.twardosc = Twardosc.values()[random.nextInt(3)];
		this.trujacy = true;
	}
	
	public void ugotuj() {
		this.twardosc = Twardosc.values()[0];
	}
	
	public boolean isTrujacy() {
		return trujacy;
	}
	
}
