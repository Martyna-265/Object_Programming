package pl.edu.pw.mini.po.rtv;

import java.time.LocalDate;

public final class Radio extends UrzadzenieRTV implements Udzwiekowienie {
	private Czestotliwosc czestotliwosc;
	
	public Radio(LocalDate dataProdukcji, Boolean wlaczone, Czestotliwosc czestotliwosc) {
		super(dataProdukcji, wlaczone);
		this.czestotliwosc = czestotliwosc;
	}

	public void odbieranie(Czestotliwosc czestotliwosc) {
		int fale;
		switch(czestotliwosc){
			case DLUGIE:
				fale = 20;
			case SREDNIE:
				fale = 1000;
			case KROTKIE:
				fale = 200;
			case UHF:
				fale = 10;
		}
	}
	
	public void wlacz() {
		if (iloscWlaczen > 0) {
			this.wlaczone = true;
			this.wlaczDzwiek();
			this.iloscWlaczen--;
		}
		else {
			System.out.println("Urzadzenie jest zepsute");
		}
	}
	
	public void wylacz() {
		this.wlaczone = false;
		this.wylaczDzwiek();
	}
	
	public String toString() {
		if (wlaczone) {
			return "Radio o nazwie " + nazwa + " wyprodukowane w roku " +
					dataProdukcji.getYear() + " jest włączone na falach " + czestotliwosc;
		}
		else {
			return "Radio o nazwie " + nazwa + " wyprodukowane w roku " +
					dataProdukcji.getYear() + " jest wyłączone";
	
		}
	}
}
