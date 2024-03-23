package pl.edu.pw.mini.po.rzeka.przedmioty.blyszczace.zegarki;

import pl.edu.pw.mini.po.rzeka.przedmioty.blyszczace.SuweniryBlyszczace;

public class Zegarek extends SuweniryBlyszczace {

	static int counter=10;
	private int numerSeryjny;
	
	public Zegarek() {
		super(random.nextInt(50)+200, random.nextBoolean());
		this.numerSeryjny = counter++;
		
	}

	@Override
	public String toString() {
		return " * ";
	}
	
}
