package pl.edu.pw.mini.po.asteroidy;

import java.util.TreeSet;

import pl.edu.pw.mini.po.asteroidy.informacje.InformacjeOgolne;
import pl.edu.pw.mini.po.asteroidy.informacje.wartosci.NiepoprawnyZasiegException;
import pl.edu.pw.mini.po.asteroidy.procesy.AsteroidProcessor;
import pl.edu.pw.mini.po.asteroidy.procesy.AstroParser;

public class Demonstrator {

	public static void main(String[] args) {
		try {
			TreeSet<InformacjeOgolne> asteroidy = AstroParser.parseReliableAsteroidInformation("asteroidy.txt");
			AsteroidProcessor processor = new AsteroidProcessor();
			System.out.println(processor.getDangerousAsteroidsOnly(asteroidy));
		} catch (NiepoprawnyZasiegException e) {
			e.printStackTrace();
		}

	}

}
