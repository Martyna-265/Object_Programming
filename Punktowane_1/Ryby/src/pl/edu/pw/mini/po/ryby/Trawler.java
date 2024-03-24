package pl.edu.pw.mini.po.ryby;

public class Trawler extends Statek {

	private int licznoscZalogi;
	
	public Trawler(int poczatkowaPozycjaX, int poczatkowaPozycjaY) {
		super(50000, poczatkowaPozycjaX, poczatkowaPozycjaY);
		this.licznoscZalogi = random.nextInt(100);
	}

}
