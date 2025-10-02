package pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.ludzie_z_zewnatrz;

import pl.edu.pw.mini.po.discotheque.dyskoteka.ochroniarze.RejestrObcych;

public class CzlowiekZZewnatrzVisitor implements Visitor{

	private RejestrObcych rejestr;
	
	public CzlowiekZZewnatrzVisitor(RejestrObcych rejestr) {
		this.rejestr = rejestr;
	}

	@Override
	public void visit(CzlowiekZZewnatrz czlowiek) {
		if (rejestr.moznaDodac(czlowiek)) {
			rejestr.dodaj(czlowiek);
		}
	}
	
}
