package pl.edu.pw.mini.po.grzybobranie.las;

import java.util.Random;

import pl.edu.pw.mini.po.grzybobranie.las.grzyby.Grzyb;
import pl.edu.pw.mini.po.grzybobranie.las.grzyby.MuchomorCesarski;
import pl.edu.pw.mini.po.grzybobranie.las.grzyby.MuchomorKolczastoglowy;
import pl.edu.pw.mini.po.grzybobranie.las.grzyby.MuchomorSromotnikowy;
import pl.edu.pw.mini.po.grzybobranie.las.grzyby.MuchomorSzarawy;

public class Las implements SaGrzyby {

	Random random = new Random();
	
	private Grzyb[][] tablica;

	public Las(int x, int y) {
		
		if (x<=0) {
			x = 100;
		}
		if (y<=0) {
			y = 100;
		}
		tablica = new Grzyb[x][y];
		
		int brakGrzyba = random.nextInt(y);
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				if (j!=brakGrzyba) {
					int jestGrzyb = random.nextInt(100);
					if (jestGrzyb<=20) {
						int grzyb = random.nextInt(4);
						switch(grzyb){
							case 0:
								tablica[i][j] = new MuchomorSromotnikowy();
								break;
							case 1:
								tablica[i][j] = new MuchomorCesarski();
								break;
							case 2:
								tablica[i][j] = new MuchomorKolczastoglowy();
								break;
							case 3:
								tablica[i][j] = new MuchomorSzarawy();
								break;
						}
					}
					else {
						tablica[i][j] = null;
					}
				}
			}
		}
	}
	
	public Grzyb zwrocGrzyba() {
		int x = random.nextInt(tablica.length);
		int y = random.nextInt(tablica[x].length);
		if (tablica[x][y] == null) {
			return null;
		}
		else {
			Grzyb grzyb = tablica[x][y];
			tablica[x][y] = null;
			return grzyb;
		}
	}
	
}
