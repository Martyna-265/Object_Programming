package pl.edu.pw.mini.po.asteroidy.informacje;

import pl.edu.pw.mini.po.asteroidy.informacje.visitor.InformacjeVisitor;
import pl.edu.pw.mini.po.asteroidy.informacje.wartosci.Srednica;

public class InformacjeOgolne implements Comparable<InformacjeOgolne>{

	private int id;
	private String nazwa;
	private Srednica srednica;
	
	public InformacjeOgolne(int id, String nazwa, Srednica srednica) {
		this.id = id;
		this.nazwa = nazwa;
		this.srednica = srednica;
	}

	@Override
	public int compareTo(InformacjeOgolne o) {
		if (this.id > o.id) {
			return 1;
		}
		else if (this.id < o.id) {
			return -1;
		}
		return 0;
	}
	
	public void apply(InformacjeVisitor informacjeVisitor) {}
	
}
