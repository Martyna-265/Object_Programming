package pl.edu.pw.mini.po.kret;

import java.util.Random;

import pl.edu.pw.mini.po.kret.environment.obiekty_ziemne.Gatunek;
import pl.edu.pw.mini.po.kret.environment.obiekty_ziemne.ObiektyZiemne;

public class Kret implements MoleMotion{

	private Gatunek gatunek;
	private int wartoscOdzywcza;
	private ObiektyZiemne[][] tablica;
	
	public Kret(ObiektyZiemne[][] tablica) {
		Random random = new Random();
		this.tablica = tablica;
		this.wartoscOdzywcza = random.nextInt(40) + 200;
	}
	
	public Kret(ObiektyZiemne[][] tablica, Gatunek gatunek) {
		this(tablica);
		this.gatunek = gatunek;
	}

	@Override
	public void goMole() {
		Random random = new Random();
		int x = random.nextInt(tablica.length);
		int y = random.nextInt(tablica[x].length);
		
		if (tablica[x][y] == null) {
			System.out.println("Pusto :(");
		}
		
		else {
			wartoscOdzywcza += tablica[x][y].getWartoscOdzywcza();
			System.out.println("Mniam!\nZnalezisko: " + tablica[x][y] + "\nWartosc odzywcza: " + tablica[x][y].getWartoscOdzywcza() + "\nIndeksy: " + x + ", " + y);
			tablica[x][y] = null;
		}
	}

	@Override
	public String getNutritionalValue() {
		String w = "" + wartoscOdzywcza;
		return w;
	}
	
}
