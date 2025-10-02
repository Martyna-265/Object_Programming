package pl.edu.pw.mini.po.rzeka.przedmioty;

import java.util.Random;

public abstract class Suweniry {

	private double wartosc; //2 miejsca po przecinku?
	public static Random random = new Random();
	
	public void setWartosc(double wartosc) {
		this.wartosc = wartosc;
	}

	public Suweniry(double wartosc) {
		this.wartosc = wartosc;
	}
	
	public int distance() {
		return 0;
	}
	
}
