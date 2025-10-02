package pl.edu.pw.mini.po.rzeka.przedmioty.blyszczace;

public class Moneta extends SuweniryBlyszczace {
	
	public Moneta() {
		super(random.nextInt(5000), random.nextBoolean());
	}

	@Override
	public String toString() {
		return " O ";
	}
	
}
