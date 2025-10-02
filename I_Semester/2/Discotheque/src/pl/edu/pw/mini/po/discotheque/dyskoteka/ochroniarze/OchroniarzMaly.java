package pl.edu.pw.mini.po.discotheque.dyskoteka.ochroniarze;

import java.util.Random;

import pl.edu.pw.mini.po.discotheque.dyskoteka.Hol;
import pl.edu.pw.mini.po.discotheque.dyskoteka.PrzepelnionaSalaException;
import pl.edu.pw.mini.po.discotheque.dyskoteka.Sala;
import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.Uczestnik;

public class OchroniarzMaly {

	private static final Random random = new Random();
	
	private Sala salaMala;
	private Sala salaDuza;
	private Hol hol;
	
	public OchroniarzMaly(Sala salaMala, Sala salaDuza, Hol hol) {
		this.salaMala = salaMala;
		this.salaDuza = salaDuza;
		this.hol = hol;
	}
	
	public boolean check(Uczestnik uczestnik) {
		if (uczestnik.getWiek()>=18) {
			int sala = random.nextInt(2);
			if (sala == 0) {
				try {
					salaMala.dodajUczestnika(uczestnik);
					return true;
				} catch (PrzepelnionaSalaException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					salaDuza.dodajUczestnika(uczestnik);
					return true;
				} catch (PrzepelnionaSalaException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
}
