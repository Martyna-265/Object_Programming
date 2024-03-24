package pl.edu.pw.mini.po.termika.teren;

import java.util.Random;

public abstract class ElementTerenu {

	private int temperatura;
	private double pradyNoszace;
	public static Random random = new Random();

	public ElementTerenu() {
		this.temperatura = random.nextInt(10);
		this.pradyNoszace = 0;
	}

	public void setPradyNoszace(double pradyNoszace) {
		this.pradyNoszace = pradyNoszace;
	}

	public double getPradyNoszace() {
		return pradyNoszace;
	}
	
	public int getTemperatura() {
		return temperatura;
	}
	
	public void modyfikujTemperature(int deltaT) {
		if (deltaT<-20 || deltaT>50) {
			System.out.println("Pewnie tutaj jakies exception - zla temperatura");
		}
		else {
			this.temperatura+=deltaT;
		}
	}
	
}
