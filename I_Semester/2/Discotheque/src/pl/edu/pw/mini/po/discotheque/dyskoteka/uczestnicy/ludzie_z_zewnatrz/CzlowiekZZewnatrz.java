package pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.ludzie_z_zewnatrz;

import java.util.Random;

import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.Uczestnik;

public class CzlowiekZZewnatrz extends Uczestnik {

	private static final Random random = new Random();
	
	public CzlowiekZZewnatrz() {
		super(random.nextInt(25)+16);
		this.setImie(this.getImiona().get(random.nextInt(10)));
		this.setNazwisko(this.getNazwiska().get(random.nextInt(10)));
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
