package pl.edu.pw.mini.po.rzeka.przedmioty;

public class Butelka extends Suweniry {
	
	private RodzajButelki rodzaj;
	
	public Butelka() {
		super(0.25);
		this.rodzaj = RodzajButelki.values()[random.nextInt(3)];
		if (rodzaj.equals(RodzajButelki.ZWROTNA)) {
			this.setWartosc(0.5);
		}
	}
	
	@Override
	public String toString() {
		return " ()";
	}

	@Override
	public int distance() {
		return random.nextInt(2)+2;
	}

}
