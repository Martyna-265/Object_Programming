package pl.edu.pw.mini.po.konduktor.bilety.kasowniki;

import pl.edu.pw.mini.po.konduktor.bilety.Bilet;

public interface SprawdzaczBiletow {

	public boolean walidujBilet(Bilet bilet) throws BrakZasieguException;
	
}
