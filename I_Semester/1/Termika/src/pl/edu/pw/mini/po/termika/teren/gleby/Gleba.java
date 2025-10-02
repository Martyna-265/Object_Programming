package pl.edu.pw.mini.po.termika.teren.gleby;

import pl.edu.pw.mini.po.termika.teren.ElementTerenu;

public abstract class Gleba extends ElementTerenu {

	private double gestosc;

	public Gleba(double gestosc) {
		super();
		this.gestosc = gestosc;
		double prady = this.getTemperatura()*0.66/8;
		this.setPradyNoszace(prady);
	}
	
	@Override
	public void modyfikujTemperature(int deltaT) {
		if (this.getTemperatura()+deltaT>40) {
			super.modyfikujTemperature(deltaT);
		}
	}
	
}
