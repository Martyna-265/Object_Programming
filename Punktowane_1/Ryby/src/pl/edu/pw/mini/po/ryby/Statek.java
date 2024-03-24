package pl.edu.pw.mini.po.ryby;

public abstract class Statek extends ObiektyMorskie {
	
	private String kod;
	private static int counter;
	private int numer;
	private int maksymalnaLadownosc;
	private int masaZlowionychRyb;
	private int poczatkowaPozycjaX;
	private int poczatkowaPozycjaY;
	
	public Statek(int maksymalnaLadownosc, int poczatkowaPozycjaX, int poczatkowaPozycjaY) {
		double kodLiczba = Math.sqrt(random.nextLong());
		this.kod = Double.toString(kodLiczba);
		this.numer = counter++;
		this.maksymalnaLadownosc = maksymalnaLadownosc;
		this.masaZlowionychRyb = 0;
		this.poczatkowaPozycjaX = poczatkowaPozycjaX;
		this.poczatkowaPozycjaY = poczatkowaPozycjaY;
	}
	
}
