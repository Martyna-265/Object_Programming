package pl.edu.pw.mini.po.bozena;

import java.util.Random;

public class Demonstrator {

	public static void main(String[] args) {
		
		Bozena bozena = new Bozena();
		
		//System.out.println(bozena.pole);
		
		System.out.println("Dzialanie Bozeny:");

		for (int i=0; i<50; i++) {
			Bozena.destroyMines(bozena.pole.tablica);
			System.out.println();
		}
		
		//System.out.println(bozena.pole);
		
	}

}
