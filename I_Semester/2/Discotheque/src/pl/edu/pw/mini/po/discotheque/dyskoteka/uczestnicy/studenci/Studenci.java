package pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.studenci;

import java.util.Random;

import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.Uczestnik;

public abstract class Studenci extends Uczestnik{

	private static final Random random = new Random();
	
	public Studenci() {
		super(random.nextInt(9)+18);
	}

}
