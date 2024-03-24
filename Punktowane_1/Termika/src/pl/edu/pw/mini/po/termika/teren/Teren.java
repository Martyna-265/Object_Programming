package pl.edu.pw.mini.po.termika.teren;

import java.util.Random;

import pl.edu.pw.mini.po.termika.teren.gleby.GlebaKamienista;
import pl.edu.pw.mini.po.termika.teren.gleby.GlebaNiekamienista;
import pl.edu.pw.mini.po.termika.teren.piasek.Piasek;
import pl.edu.pw.mini.po.termika.teren.wodne.PodmoklaLaka;
import pl.edu.pw.mini.po.termika.teren.wodne.TerenWodny;

public class Teren {

	private ElementTerenu[][] tablica;

	public Teren(int x, int y) {
		Random random = new Random();
		
		if (x<=0) {
			x = 100;
		}
		if (y<=0) {
			y = 100;
		}
		this.tablica = new ElementTerenu[y][x];
		
		for (int i=0; i<y; i++) {
			for (int j=0; j<x; j++) {
				int p = random.nextInt(4);
				switch (p) {
					case 0:
						tablica[i][j] = new Piasek();
						break;
					case 1:
						tablica[i][j] = new GlebaKamienista();
						break;
					case 2:
						tablica[i][j] = new GlebaNiekamienista();
						break;
					case 3:
						tablica[i][j] = new PodmoklaLaka();
						break;
					case 4:
						tablica[i][j] = new TerenWodny();
						break;
				}
			}
		}
		
	}

	public ElementTerenu[][] getTablica() {
		return tablica;
	}
	
	public void modyfikujAtmosfere() {
		
		Random random = new Random();
		
		for (int i=0; i<tablica.length; i++) {
			for (int j=0; j<tablica[i].length; j++) {
				int p = random.nextInt(5)-1;
				tablica[i][j].modyfikujTemperature(p);
			}
		}
		
	}
	
}
