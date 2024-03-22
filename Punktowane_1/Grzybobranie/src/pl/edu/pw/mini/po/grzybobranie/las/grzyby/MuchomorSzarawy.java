package pl.edu.pw.mini.po.grzybobranie.las.grzyby;

import java.util.Random;
import java.time.Year;

public class MuchomorSzarawy extends Grzyb {

	Random random = new Random();
	
	private Toksyny toksyny;
	private Year rokOdkryciaGatunku;
	
	public MuchomorSzarawy() {
		super();
		this.masaOwocnika = random.nextInt(50) + 25;
		this.toksyny = Toksyny.TRUJACE;
		this.rokOdkryciaGatunku = Year.of(1783);
	}
	
	@Override
	public String toString() {
		return "Muchomor Szarawy [twardosc = " + twardosc + ", masa owocnika = " + masaOwocnika + ", toksyny = " + toksyny + ", rok odkrycia gatunku = " + rokOdkryciaGatunku + "]";
	}

	@Override
	public void ugotuj() {
		super.ugotuj();
		this.toksyny = Toksyny.NIEOBECNE;
		this.trujacy = false;
	}
	
}
