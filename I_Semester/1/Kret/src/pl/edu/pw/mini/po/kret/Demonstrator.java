package pl.edu.pw.mini.po.kret;

import pl.edu.pw.mini.po.kret.environment.Environment;
import pl.edu.pw.mini.po.kret.environment.obiekty_ziemne.Gatunek;

public class Demonstrator {

	public static void main(String[] args) {
		
		Environment las = new Environment(10, 10, 10, 10, Gatunek.EUROPAEA);
		System.out.println("Przed ruchem kreta: \n" + las);
		las.runMole();

	}

}
