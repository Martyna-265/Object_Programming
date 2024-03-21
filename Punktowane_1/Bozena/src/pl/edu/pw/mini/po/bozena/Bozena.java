package pl.edu.pw.mini.po.bozena;

import java.util.Random;

import pl.edu.pw.mini.po.bozena.podloze.ElementyPodloza;
import pl.edu.pw.mini.po.bozena.podloze.Pole;

public class Bozena {

	public Pole pole;
	
	public Bozena() {
		this.pole = new Pole();
	}
	
	public static void destroyMines(ElementyPodloza tablica[][]) {
		Random random = new Random();
		
		int wiersz = random.nextInt(tablica.length);
		
		for (int j=0; j<tablica.length; j++) {
			if (tablica[wiersz][j] != null) {
				tablica[wiersz][j].pressMe();
				tablica[wiersz][j] = null;
			}
		}
	}
	
}
