package pl.edu.pw.mini.po.bozena.podloze.miny;

import java.util.Random;

import pl.edu.pw.mini.po.bozena.podloze.ElementyPodloza;

public abstract class Mina extends ElementyPodloza {

	Random random = new Random();
	
	private int identyfikatorMiny;
	static int counter;
	protected boolean uzbrojona;
	
	public Mina() {
		super();
		this.identyfikatorMiny = 10*(counter++);
		this.uzbrojona = false;
	}
	
	public void armMe() {
		this.uzbrojona = true;
	}
	
}
