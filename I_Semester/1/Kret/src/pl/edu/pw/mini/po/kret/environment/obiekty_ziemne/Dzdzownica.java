package pl.edu.pw.mini.po.kret.environment.obiekty_ziemne;

import java.util.Random;

public class Dzdzownica extends ObiektyZiemne {

	private double masa;
	
	public Dzdzownica(int wartoscOdzywcza) {
		super(wartoscOdzywcza);
		Random random = new Random();
		this.masa = random.nextDouble(0.5) + 1;
	}
	
	@Override
	public String toString() {
		return "{}";
	}
	
}
