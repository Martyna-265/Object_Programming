package pl.edu.pw.mini.po.rzeka.wycinek;

import java.util.Random;

import pl.edu.pw.mini.po.rzeka.przedmioty.But;
import pl.edu.pw.mini.po.rzeka.przedmioty.Butelka;
import pl.edu.pw.mini.po.rzeka.przedmioty.Suweniry;
import pl.edu.pw.mini.po.rzeka.przedmioty.blyszczace.Moneta;
import pl.edu.pw.mini.po.rzeka.przedmioty.blyszczace.zegarki.Zegarek;
import pl.edu.pw.mini.po.rzeka.przedmioty.blyszczace.zegarki.ZegarekPodwodny;

public class WycinekRzeki {

	Random random = new Random();
	protected Suweniry[][] tablica;

	public WycinekRzeki(int szerokosc, int dlugosc) {
		if (szerokosc>=1 && szerokosc<=100 && dlugosc>=1 && dlugosc<=100) {
			this.tablica = new Suweniry[szerokosc][dlugosc];
			
			for (int i=0; i<szerokosc; i++) {
				for (int j=0; j<dlugosc; j++) {
					int p = random.nextInt(50);
					switch(p) {
						case 1:
							tablica[i][j] = new Moneta();
							break;
						case 2:
							tablica[i][j] = new Zegarek();
							break;
						case 3:
							tablica[i][j] = new ZegarekPodwodny();
							break;
						case 4:
							tablica[i][j] = new But();
							break;
						case 5:
							tablica[i][j] = new Butelka();
							break;
						default:
							tablica[i][j] = null;
					}
				}
			}
			
		}
	}
	
	public void moveAll() {
		for (int i=tablica.length-1; i>=0; i--) {
			for (int j=tablica[i].length-1; j>=0; j--) {
				if (tablica[i][j] != null) {
					int ruch = tablica[i][j].distance();
					if (j+ruch < tablica[i].length) {
						if (tablica[i][j+ruch] == null) {
							tablica[i][j+ruch] = tablica[i][j];
							tablica[i][j] = null;
						}
					}
					else {
						tablica[i][j] = null;
					}
				}
			}
		}
	}
	
}
