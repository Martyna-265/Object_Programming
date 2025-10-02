package pl.edu.pw.mini.po.kret.environment;

import java.util.Random;

import pl.edu.pw.mini.po.kret.Kret;
import pl.edu.pw.mini.po.kret.MoleMotion;
import pl.edu.pw.mini.po.kret.environment.obiekty_ziemne.Dzdzownica;
import pl.edu.pw.mini.po.kret.environment.obiekty_ziemne.Gatunek;
import pl.edu.pw.mini.po.kret.environment.obiekty_ziemne.Gleba;
import pl.edu.pw.mini.po.kret.environment.obiekty_ziemne.Larwa;
import pl.edu.pw.mini.po.kret.environment.obiekty_ziemne.ObiektyZiemne;

public class Environment {

	private ObiektyZiemne[][] tablica;
	private static int wartoscOdzywczaDzdzownicy = 3;
	private MoleMotion kret;

	public Environment(int m, int n, int iloscLarw, int iloscDzdzownic) {
		Random random = new Random();
		this.tablica = new ObiektyZiemne[m][n];
		
		int i = 0;
		while (i<iloscLarw) {
			int x = random.nextInt(m);
			int y = random.nextInt(n);
			if (this.tablica[x][y] == null) {
				int wartoscOdzywczaLarwy = random.nextInt(2)+3;
				this.tablica[x][y] = new Larwa(wartoscOdzywczaLarwy);
				i++;
			}
		}
		
		int j = 0;
		while (j<iloscDzdzownic) {
			int x = random.nextInt(m);
			int y = random.nextInt(n);
			if (this.tablica[x][y] == null) {
				this.tablica[x][y] = new Dzdzownica(this.wartoscOdzywczaDzdzownicy);
				j++;
			}
		}
		
		for (int a=0; a<tablica.length; a++) {
			for (int b=0; b<tablica[a].length; b++) {
				if (tablica[a][b] == null) {
					tablica[a][b] = new Gleba(0);
				}
			}
		}
	}
	
	public Environment(int m, int n, int iloscLarw, int iloscDzdzownic, Gatunek gatunek) {
		this(m, n, iloscLarw, iloscDzdzownic);
		this.kret = new Kret(tablica, gatunek);
	}
	
	@Override
	public String toString() {
		String w = "";
		for (int i=0; i<tablica.length; i++) {
			for (int j=0; j<tablica[i].length; j++) {
				if (tablica[i][j] == null) {
					w += "  ";
				}
				else {
					w += tablica[i][j];
				}
			}
			w += "\n";
		}
		return w;
	}
	
	public void runMole() {
		for (int i=0; i<10; i++) {
			kret.goMole();
			System.out.println(this);
		}
	}
	
}
