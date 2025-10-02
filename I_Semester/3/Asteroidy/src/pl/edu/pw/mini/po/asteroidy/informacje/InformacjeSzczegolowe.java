package pl.edu.pw.mini.po.asteroidy.informacje;

import pl.edu.pw.mini.po.asteroidy.informacje.visitor.InformacjeVisitor;
import pl.edu.pw.mini.po.asteroidy.informacje.wartosci.Orbita;
import pl.edu.pw.mini.po.asteroidy.informacje.wartosci.Srednica;

public class InformacjeSzczegolowe extends InformacjeOgolne {

	private Boolean zagrozenieDlaZiemi;
	private String dataBliskiegoPrzejscia;
	private double predkosc;
	private double dystans;
	private String predkoscS;
	private String dystansS;
	private Orbita oributujeWokol;
	private String link;
	
	public InformacjeSzczegolowe(int id, String nazwa, Srednica srednica, Boolean zagrozenieDlaZiemi,
			String dataBliskiegoPrzejscia, double predkosc, double dystans, Orbita oributujeWokol, String link) {
		super(id, nazwa, srednica);
		this.zagrozenieDlaZiemi = zagrozenieDlaZiemi;
		this.dataBliskiegoPrzejscia = dataBliskiegoPrzejscia;
		this.predkosc = Math.round(predkosc*10d)/10d;
		this.dystans = Math.round(dystans*10d)/10d;
		this.oributujeWokol = oributujeWokol;
		this.link = link;
	}
	
	public void apply (InformacjeVisitor informacjeVisitor) {
		informacjeVisitor.visitInformacjeSzczegolowe(this);
	}
	
}
