package pl.edu.pw.mini.po.rtv;

import java.time.LocalDate;

public class TelewizorCRT extends Telewizor {

	private Kolor kolor;
	
	public TelewizorCRT(LocalDate dataProdukcji, Boolean wlaczone, int przekatna, Kolor kolor) {
		super(dataProdukcji, wlaczone, przekatna);
		this.kolor = kolor;
		this.rodzajSygnalu = Sygnal.ANALOGOWY;
	}
	
	public String toString() {
		if (wlaczone) {
			return "Telewizor o nazwie " + nazwa + " wyprodukowany w roku " +
					dataProdukcji.getYear() + " o przekatnej " + przekatna + " cale odbiera sygnał " + 
					rodzajSygnalu + " na kanale " + odbieranyKanal;
		}
		else {
			return "Telewizor o nazwie " + nazwa + " wyprodukowany w roku " +
					dataProdukcji.getYear() + " o przekatnej " + przekatna + " cale jest wyłączony";
	
		}
	}
	
	public void napraw() {
		System.out.println("Nie da się naprawić tego telewizora");
	}

}
