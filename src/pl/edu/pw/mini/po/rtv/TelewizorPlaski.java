package pl.edu.pw.mini.po.rtv;

import java.time.LocalDate;

public class TelewizorPlaski extends Telewizor implements OdbieranieRozszerzone {

	private Matryca matryca;
	
	public TelewizorPlaski(LocalDate dataProdukcji, Boolean wlaczone, int przekatna, Matryca matryca) {
		super(dataProdukcji, wlaczone, przekatna);
		this.matryca = matryca;
	}

	@Override
	public void odbierzSygnal(Sygnal sygnal) {
		this.rodzajSygnalu = sygnal;

	}
	
	public String toString() {
		if (wlaczone) {
			return "Telewizor " + matryca + " o nazwie " + nazwa + " wyprodukowany w roku " +
					dataProdukcji.getYear() + " o przekatnej " + przekatna + " cale odbiera sygnał " + 
					rodzajSygnalu + " na kanale " + odbieranyKanal;
		}
		else {
			return "Telewizor " + matryca + " o nazwie " + nazwa + " wyprodukowany w roku " +
					dataProdukcji.getYear() + " o przekatnej " + przekatna + " cale jest wyłączony";
	
		}
	}
	
	public void wlacz(int kanal, Sygnal sygnal) {
		super.wlacz(kanal);
		if (iloscWlaczen > 0) {
			this.odbierzSygnal(sygnal);
		}
	}
}
