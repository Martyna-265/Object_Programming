package pl.edu.pw.mini.po.bozena.podloze.rosliny;

import java.util.Random;

public class Purchawka extends Roslina {

	Random random = new Random();

	public Purchawka() {
		super();
		this.wysokosc = random.nextDouble(4) + 3.5;
		this.ekologiczna = random.nextBoolean();
	}
	
	@Override
	public void pressMe() {
		System.out.println("Puffff");
	}
	
	public String toString() {
		return "o";
	}
	
}
