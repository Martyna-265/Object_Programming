package pl.edu.pw.mini.po.ryby;

import java.util.Random;

public class Symulator implements Generator{

	public Random random = new Random();
	private Plansza plansza;
	
	public Symulator (int liczbaRekinowOstronosow, int liczbaRekinowPolarnych, int liczbaKutrow, int liczbaTrawlerow) {
		inicjalizuj(liczbaRekinowOstronosow, liczbaRekinowPolarnych, liczbaKutrow, liczbaTrawlerow);
	}
	
	public Symulator() {
		inicjalizuj(500, 500, 100, 100);
	}
	
	private void inicjalizuj(int liczbaRekinowOstronosow, int liczbaRekinowPolarnych, int liczbaKutrow, int liczbaTrawlerow) {
		this.plansza = new Plansza(liczbaRekinowOstronosow, liczbaRekinowPolarnych, liczbaKutrow, liczbaTrawlerow);
	}

	@Override
	public void generujKuter() {
		while (true) {
			int i = random.nextInt(100);
			int j = random.nextInt(100);
			if (plansza.getTablica()[i][j] == null) {
				plansza.getTablica()[i][j] = new Kuter(i, j);
				break;
			}
		}
		
	}

	@Override
	public void generujTrawler() {
		while (true) {
			int i = random.nextInt(100);
			int j = random.nextInt(100);
			if (plansza.getTablica()[i][j] == null) {
				plansza.getTablica()[i][j] = new Trawler(i, j);
				break;
			}
		}
		
	}

	@Override
	public void generujRekinaPolarnego() {
		while (true) {
			int i = random.nextInt(100);
			int j = random.nextInt(100);
			if (plansza.getTablica()[i][j] == null) {
				plansza.getTablica()[i][j] = new RekinPolarny(i, j);
				break;
			}
		}
		
	}

	@Override
	public void generujRekinaOstronosego() {
		while (true) {
			int i = random.nextInt(100);
			int j = random.nextInt(100);
			if (plansza.getTablica()[i][j] == null) {
				plansza.getTablica()[i][j] = new RekinOstronosy();
				break;
			}
		}
		
	}
	
}
