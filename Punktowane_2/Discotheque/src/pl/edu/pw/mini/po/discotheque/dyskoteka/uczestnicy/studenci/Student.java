package pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.studenci;

import java.util.Random;

public class Student extends Studenci {

	private static final Random random = new Random();
	
	public Student() {
		super();
		this.setImie(this.getImiona().get(random.nextInt(5)+4));
		this.setNazwisko(this.getNazwiska().get(random.nextInt(5)+4));
	}
	
}
