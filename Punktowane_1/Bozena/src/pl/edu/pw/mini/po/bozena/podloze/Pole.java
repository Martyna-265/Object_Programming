package pl.edu.pw.mini.po.bozena.podloze;

import java.util.Random;

import pl.edu.pw.mini.po.bozena.podloze.miny.Mina;
import pl.edu.pw.mini.po.bozena.podloze.miny.MinaPrzeciwczolgowa;
import pl.edu.pw.mini.po.bozena.podloze.miny.MinaPrzeciwpiechotna;
import pl.edu.pw.mini.po.bozena.podloze.rosliny.Purchawka;
import pl.edu.pw.mini.po.bozena.podloze.rosliny.Trawa;

public class Pole {

	Random random = new Random();
	public ElementyPodloza[][] tablica;
	
	public Pole() {
		
		tablica = new ElementyPodloza[100][100];

		for (int i=0; i<tablica.length; i++) {
			for (int j=0; j<tablica.length; j++) {
				int p = random.nextInt(100);
				if (p<10) {
					tablica[i][j] = new Trawa();
				}
				else if (p<20) {
					tablica[i][j] = new Purchawka();
				}
				else if (p<40) {
					if (p<30) {
						tablica[i][j] = new MinaPrzeciwczolgowa();
					}
					else {
						tablica[i][j] = new MinaPrzeciwpiechotna();
					}
					int pp = random.nextInt(100);
					if (pp<90) {
						((Mina)tablica[i][j]).armMe();
					}
				}
				else {
					tablica[i][j] = null;
				}
			}
		}
	}

}