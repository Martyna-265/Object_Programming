package pl.edu.pw.mini.po.rzeka.przedmioty.blyszczace;

import pl.edu.pw.mini.po.rzeka.przedmioty.Suweniry;

public abstract class SuweniryBlyszczace extends Suweniry {

	private boolean polysk;
	
	public SuweniryBlyszczace(double wartosc, boolean polysk) {
		super(wartosc);
		this.polysk = polysk;
	}

	@Override
	public int distance() {
		return 1;
	}
	
}
