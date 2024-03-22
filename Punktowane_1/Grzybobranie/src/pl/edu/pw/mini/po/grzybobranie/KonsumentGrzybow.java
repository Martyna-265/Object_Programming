package pl.edu.pw.mini.po.grzybobranie;

import java.util.Random;

import pl.edu.pw.mini.po.grzybobranie.las.Las;
import pl.edu.pw.mini.po.grzybobranie.las.grzyby.Grzyb;

public class KonsumentGrzybow {

	Las las;

	public KonsumentGrzybow(Las las) {
		this.las = las;
	}
	
	public void konsumujGrzyby() {
		Random random = new Random();
		int n = random.nextInt(99)+51;
		
		for (int i=0; i<n; i++) {
			Object object = las.zwrocGrzyba();
			if (object instanceof Grzyb) {
				Grzyb grzyb = (Grzyb)object;
				System.out.println("Gotuje grzyba " + grzyb);
				grzyb.ugotuj();
				boolean koniec = zjedz(grzyb);
				if (koniec) {
					break;
				}
			}
		}
	}
	
	private boolean zjedz(Grzyb grzyb) {
		if (grzyb.isTrujacy()) {
			System.out.println("Uuuuups!");
		}
		else {
			System.out.println("Mniam");
		}
		return grzyb.isTrujacy();
	}
	
}
