package pl.edu.pw.mini.po.rtv;

import java.time.LocalDate;
import java.util.Random;

public abstract class UrzadzenieRTV implements Odbieranie {

	protected LocalDate dataProdukcji;
	protected String nazwa;
	protected int iloscWlaczen;
	protected Boolean wlaczone;
	
	public UrzadzenieRTV(LocalDate dataProdukcji, Boolean wlaczone) {
		this.dataProdukcji = dataProdukcji;
		this.wlaczone = wlaczone;
		Random random = new Random();
		this.iloscWlaczen = random.nextInt(4)+3;
		this.nazwa = "abc"; //???
	}
	
	
	@Override
	public void odbieranie() {
		// TODO Auto-generated method stub

	}
	
	public void napraw() {
		if (this.iloscWlaczen == 0) {
			Random random = new Random();
			this.iloscWlaczen = random.nextInt(4)+3;
		}
	}
	
	public void wlacz() {
		
	}
	
	public void wlacz(int kanal) {
		
	}
	
	public void wlacz(int kanal, Sygnal cyfrowy) {
		
	}
	
	public void wylacz() {
		
	}

}
