package pl.edu.pw.mini.po.rtv;

import java.time.LocalDate;

public abstract class Telewizor extends UrzadzenieRTV implements Obrazowanie, Udzwiekowienie {
	
	protected int przekatna;
	protected Sygnal rodzajSygnalu;
	protected int odbieranyKanal;
	
	public Telewizor(LocalDate dataProdukcji, Boolean wlaczone, int przekatna) {
		super(dataProdukcji, wlaczone);
		this.przekatna = przekatna;
	}
	
	void odbieranie(int odbieranyKanal) {
		if (odbieranyKanal >=0 && odbieranyKanal<100) {
			this.odbieranyKanal = odbieranyKanal;
		}
	}
	
	public void wlacz(int kanal) {
		if (iloscWlaczen > 0) {
			this.wlaczone = true;
			this.wlaczDzwiek();
			this.wlaczObraz();
			this.iloscWlaczen--;
			this.odbieranie(kanal);
		}
		else {
			System.out.println("Urzadzenie jest zepsute");
		}
	}
	
	public void wylacz() {
		this.wlaczone = false;
		this.wylaczDzwiek();
		this.wylaczObraz();
	}
	
}
