package pl.edu.pw.mini.po.rzeka.wycinek;

public class TrzeciWycinekRzeki extends WycinekRzeki {

	public TrzeciWycinekRzeki(int szerokosc, int dlugosc) {
		super(szerokosc, dlugosc);
	}

	@Override
	public void moveAll() {
		super.moveAll();
		
		System.out.println("Rzeka:");
		for (int i=0; i<tablica.length; i++) {
			for (int j=0; j<tablica[i].length; j++) {
				if (tablica[i][j] == null) {
					System.out.print(" ~ ");
				}
				else {
					System.out.print(tablica[i][j]);
				}
			}
			System.out.println();
		}
	}

}
