package pl.edu.pw.mini.po.termika.teren.piasek;

import pl.edu.pw.mini.po.termika.teren.ElementTerenu;

public class Piasek extends ElementTerenu {

	private Sypkosc sypkosc;

	public Piasek() {
		super();
		this.sypkosc = Sypkosc.values()[random.nextInt(3)];
		double prady = this.getTemperatura()*0.2*random.nextDouble(1);
		this.setPradyNoszace(prady);
	}

	@Override
	public void modyfikujTemperature(int deltaT) {
		if (this.getTemperatura()+deltaT<=50) {
			super.modyfikujTemperature(deltaT);
		}
	}
	
}
