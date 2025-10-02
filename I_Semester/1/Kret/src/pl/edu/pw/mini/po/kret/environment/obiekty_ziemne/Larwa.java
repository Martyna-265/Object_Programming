package pl.edu.pw.mini.po.kret.environment.obiekty_ziemne;

import java.util.Random;

public class Larwa extends ObiektyZiemne {

	private double masa;
	
	public Larwa(int wartoscOdzywcza) {
		super(wartoscOdzywcza);
		Random random = new Random();
		this.masa = random.nextDouble(1) + 2;
	}
	
	@Override
	public String toString() {
		return "@ ";
	}
	
}
