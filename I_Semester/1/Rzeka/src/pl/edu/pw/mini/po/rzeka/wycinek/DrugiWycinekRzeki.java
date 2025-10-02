package pl.edu.pw.mini.po.rzeka.wycinek;

public class DrugiWycinekRzeki extends WycinekRzeki {

	private int wywolania;
	
	public DrugiWycinekRzeki(int szerokosc, int dlugosc) {
		super(szerokosc, dlugosc);
		this.wywolania = 0;
	}

	@Override
	public void moveAll() {
		super.moveAll();
		wywolania++;
	}

	public int getWywolania() {
		return wywolania;
	}

}
