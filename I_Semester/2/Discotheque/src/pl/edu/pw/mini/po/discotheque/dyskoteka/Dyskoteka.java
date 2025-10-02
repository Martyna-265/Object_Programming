package pl.edu.pw.mini.po.discotheque.dyskoteka;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

import pl.edu.pw.mini.po.discotheque.dyskoteka.ochroniarze.OchroniarzDuzy;
import pl.edu.pw.mini.po.discotheque.dyskoteka.ochroniarze.OchroniarzMaly;
import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.Uczestnik;

public class Dyskoteka {

	private static final Random random = new Random();
	
	private Hol hol;
	private Sala salaMala;
	private Sala salaDuza;
	private OchroniarzDuzy ochroniarzDuzy;
	private OchroniarzMaly ochroniarzMaly;
	
	public Dyskoteka() {
		this.hol = new Hol();
		this.salaMala = new Sala(51);
		this.salaDuza = new Sala(75);
		this.ochroniarzDuzy = new OchroniarzDuzy(salaMala, salaDuza, hol);
		this.ochroniarzMaly = new OchroniarzMaly(salaMala, salaDuza, hol);
	}
	
	private void inviteAll() {
		LinkedHashSet<Uczestnik> uczestnicy = hol.getUczestnicy();
		Iterator<Uczestnik> i = uczestnicy.iterator();
		while(i.hasNext()) {
			int p = random.nextInt(2);
			if (p==0) {
				if(ochroniarzDuzy.check(i.next())) {
					i.remove();
				}
			}
			else {
				if(ochroniarzMaly.check(i.next())) {
					i.remove();
				}
			}
		}
	}
	
	public void goLive() {
		inviteAll();
		ochroniarzDuzy.printStrangers();
	}
	
}
