package pl.edu.pw.mini.po.ryby;

import java.util.Random;

public class Plansza {

	public Random random = new Random();
	
	private ObiektyMorskie[][] tablica;

	public ObiektyMorskie[][] getTablica() {
		return tablica;
	}

	public Plansza(int liczbaRekinowOstronosow, int liczbaRekinowPolarnych, int liczbaKutrow, int liczbaTrawlerow) {
		this.tablica = new ObiektyMorskie[100][100];
		
		int licznik=0;
		while (licznik <liczbaRekinowOstronosow) {
			int i = random.nextInt(100);
			int j = random.nextInt(100);
			if (tablica[i][j] == null) {
				tablica[i][j] = new RekinOstronosy();
				licznik++;
			}
		}
		
		licznik=0;
		while (licznik <liczbaRekinowPolarnych) {
			int i = random.nextInt(100);
			int j = random.nextInt(100);
			if (tablica[i][j] == null) {
				tablica[i][j] = new RekinPolarny(i, j);
				licznik++;
			}
		}
		
		licznik=0;
		while (licznik <liczbaKutrow) {
			int i = random.nextInt(100);
			int j = random.nextInt(100);
			if (tablica[i][j] == null) {
				tablica[i][j] = new Kuter(i, j);
				licznik++;
			}
		}
		
		licznik=0;
		while (licznik <liczbaTrawlerow) {
			int i = random.nextInt(100);
			int j = random.nextInt(100);
			if (tablica[i][j] == null) {
				tablica[i][j] = new Trawler(i, j);
				licznik++;
			}
		}
		
	}
	
}
