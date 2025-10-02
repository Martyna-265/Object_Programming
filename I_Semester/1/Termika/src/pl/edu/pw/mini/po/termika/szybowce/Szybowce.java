package pl.edu.pw.mini.po.termika.szybowce;

import java.util.Random;

import pl.edu.pw.mini.po.termika.teren.Teren;

public abstract class Szybowce implements Latajace{

	public Random random = new Random();
	
	private Teren generatorTerenu;
	private int aktualnaWysokosc;
	private int wspolrzednaX;
	private int wspolrzednaY;

	public Szybowce(Teren generatorTerenu, int aktualnaWysokosc) {
		
		this.generatorTerenu = generatorTerenu;
		this.aktualnaWysokosc = aktualnaWysokosc;
		this.wspolrzednaX = 0;
		this.wspolrzednaY = random.nextInt(generatorTerenu.getTablica().length);
		
	}
	
	public void fly() {
		
		if (aktualnaWysokosc!=0) {
			
			wspolrzednaX+=1;
			int p = random.nextInt(3);
			if (p==0) {
				wspolrzednaY+=1;
			}
			if (p==1) {
				wspolrzednaY-=1;
			}
			if (wspolrzednaX>=generatorTerenu.getTablica()[0].length || wspolrzednaY>=generatorTerenu.getTablica().length || wspolrzednaY<0) {
				System.out.println("Lot poza strefa");
				if (wspolrzednaX>=generatorTerenu.getTablica()[0].length) {
					wspolrzednaX-=1;
				}
				if (wspolrzednaY>=generatorTerenu.getTablica().length) {
					wspolrzednaY-=1;
				}
				if (wspolrzednaY<0) {
					wspolrzednaY+=1;
				}
			}
			
			aktualnaWysokosc-=generatorTerenu.getTablica()[wspolrzednaY][wspolrzednaX].getPradyNoszace();
			if (aktualnaWysokosc<=0) {
				System.out.println("Ooops, ladowanie w polu!");
				aktualnaWysokosc=0;
			}
		}
		
	}

	public int getAktualnawysokosc() {
		return aktualnaWysokosc;
	}
	
	
	
}
