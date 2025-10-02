package pl.edu.pw.mini.po.ryby;

public class RekinPolarny extends Ryba {

	private int wiek;
	private int poczatkowaPozycjaX;
	private int poczatkowaPozycjaY;
	
	public RekinPolarny(int poczatkowaPozycjaX, int poczatkowaPozycjaY) {
		super(random.nextInt(1000)+500);
		this.wiek = random.nextInt(100)+300;
		this.poczatkowaPozycjaX = poczatkowaPozycjaX;
		this.poczatkowaPozycjaY = poczatkowaPozycjaY;
	}
}
