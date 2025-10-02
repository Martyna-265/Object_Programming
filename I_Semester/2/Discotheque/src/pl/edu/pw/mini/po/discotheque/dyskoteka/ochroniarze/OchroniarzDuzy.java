package pl.edu.pw.mini.po.discotheque.dyskoteka.ochroniarze;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import pl.edu.pw.mini.po.discotheque.dyskoteka.Hol;
import pl.edu.pw.mini.po.discotheque.dyskoteka.Sala;
import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.Uczestnik;
import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.ludzie_z_zewnatrz.CzlowiekZZewnatrz;
import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.ludzie_z_zewnatrz.CzlowiekZZewnatrzVisitor;

public class OchroniarzDuzy extends OchroniarzMaly {
	
	private RejestrObcych rejestrObcych;
	
	public OchroniarzDuzy(Sala salaMala, Sala salaDuza, Hol hol) {
		super(salaMala, salaDuza, hol);
		this.rejestrObcych = new RejestrObcych();
	}

	@Override
	public boolean check(Uczestnik uczestnik) {
//		if (uczestnik instanceof CzlowiekZZewnatrz) {
//			if (rejestrObcych.moznaDodac((CzlowiekZZewnatrz)uczestnik)) {
//				rejestrObcych.dodaj((CzlowiekZZewnatrz)uczestnik);
//			}
//		}
		CzlowiekZZewnatrzVisitor visitor = new CzlowiekZZewnatrzVisitor(rejestrObcych);
		uczestnik.accept(visitor);
		return super.check(uczestnik);
	}
	
	public void printStrangers() {
		System.out.println("Rejestr obcych:");
		HashMap<String, Set<CzlowiekZZewnatrz>> lista = rejestrObcych.getListaObcych();
		for (String imiona : lista.keySet()) {
			Set<CzlowiekZZewnatrz> osoby = lista.get(imiona);
			for (CzlowiekZZewnatrz czlowiek : osoby) {
				System.out.println(czlowiek.getImie() + " " + czlowiek.getNazwisko() + " " + czlowiek.getWiek());
			}
		}
	}
	

}
