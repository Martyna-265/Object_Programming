package pl.edu.pw.mini.po.termika;

import pl.edu.pw.mini.po.termika.szybowce.Bocian;
import pl.edu.pw.mini.po.termika.teren.Teren;

public class Demonstrator {

	public static void main(String[] args) {

		Teren teren = new Teren(20, 20);
		Bocian szybowiec = new Bocian(teren, 20);
		
		for (int i=0; i<25; i++) {
			teren.modyfikujAtmosfere();
			szybowiec.fly();
			System.out.println(szybowiec);
		}

	}

}
