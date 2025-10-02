package pl.edu.pw.mini.po.termika.teren.wodne;

import pl.edu.pw.mini.po.termika.teren.ElementTerenu;

public abstract class ElementTerenuWodnego extends ElementTerenu {

	private boolean spelniaWymogiNatura2000;

	public ElementTerenuWodnego() {
		super();
		this.spelniaWymogiNatura2000 = random.nextBoolean();
		double prady = this.getTemperatura()/10-random.nextDouble(3)+1;
		this.setPradyNoszace(prady);
	}
	
	@Override
	public void modyfikujTemperature(int deltaT) {
		if (this.getTemperatura()+deltaT>20) {
			super.modyfikujTemperature(deltaT);
		}
	}
	
}
