package pl.edu.pw.mini.po.bozena;

import java.util.Random;

import pl.edu.pw.mini.po.bozena.podloze.ElementyPodloza;
import pl.edu.pw.mini.po.bozena.podloze.Pole;

public class Bozena implements Przeciwminowy{

	private Pole pole;
	
	public Bozena(Pole pole) {
		this.pole = pole;
	}
	
	public void destroyMines() {
		Random random = new Random();
		ElementyPodloza tablica[][] = this.pole.tablica;
		
		int wiersz = random.nextInt(tablica.length);
		//System.out.println("Wiersz: " + wiersz);
		
		for (int j=0; j<tablica.length; j++) {
			if (tablica[wiersz][j] != null) {
				tablica[wiersz][j].pressMe();
				tablica[wiersz][j] = null;
			}
		}
	}
	
}
