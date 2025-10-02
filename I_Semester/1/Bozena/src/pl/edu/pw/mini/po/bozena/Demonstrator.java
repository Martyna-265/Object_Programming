package pl.edu.pw.mini.po.bozena;

public class Demonstrator {

//	public static void main(String[] args) {
//		
//		Pole pole = new Pole();
//		Bozena bozena = new Bozena(pole);
//		
//		//System.out.println(bozena.pole);
//		
//		System.out.println("Dzialanie Bozeny:");
//
//		for (int i=0; i<50; i++) {
//			//Przeciwminowy.destroyMines(bozena.pole.tablica);
//			bozena.destroyMines();
//			System.out.println();
//		}
//		
//		//System.out.println(bozena.pole);
//		
//	}
	
	public void uruchomTral(Przeciwminowy urzadzenie) {
		
		System.out.println("Dzialanie Bozeny:");
		for (int i=0; i<50; i++) {
			urzadzenie.destroyMines();
			System.out.println();
		}
		
	}

}
