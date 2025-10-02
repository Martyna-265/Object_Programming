package pl.edu.pw.mini.po.bozena;

import pl.edu.pw.mini.po.bozena.podloze.Pole;

public class Uzytkownik {

	public static void main(String[] args) {
		
		Pole pole = new Pole();
		Przeciwminowy bozena = new Bozena(pole);
		Demonstrator demo = new Demonstrator();
		demo.uruchomTral(bozena);

	}

}
