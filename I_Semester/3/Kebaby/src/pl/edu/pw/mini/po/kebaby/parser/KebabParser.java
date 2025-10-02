package pl.edu.pw.mini.po.kebaby.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import pl.edu.pw.mini.po.kebaby.Kebab;
import pl.edu.pw.mini.po.kebaby.KebabNaTalerzu;
import pl.edu.pw.mini.po.kebaby.KebabWCiescie;
import pl.edu.pw.mini.po.kebaby.wartosci.Dodatek;
import pl.edu.pw.mini.po.kebaby.wartosci.GrubeCiasto;
import pl.edu.pw.mini.po.kebaby.wartosci.Mieso;
import pl.edu.pw.mini.po.kebaby.wartosci.Rozmiar;

public class KebabParser {

	public static List<Kebab> parseKebabs() throws NieznaneMiesoException {
		File plik = new File("data" + File.separator + "kebaby.txt");
		List<Kebab> kebaby = new ArrayList<Kebab>();
		
		try {
			Scanner scanner = new Scanner(plik);
			scanner.useDelimiter("---");
			
			while (scanner.hasNextLine() & scanner.hasNext()) {
				String rozmiarS = scanner.next().trim().toUpperCase();
				Rozmiar rozmiar = Rozmiar.valueOf(rozmiarS);
				if (scanner.hasNext("no") | scanner.hasNext("yes")) {
					kebaby.add(parseKebabWCiescie(scanner, rozmiar));
				}
				else {
					kebaby.add(parseKebabNaTalerzu(scanner, rozmiar));
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return kebaby;
		
	}
	
	private static Kebab parseKebabWCiescie(Scanner scanner, Rozmiar rozmiar) throws NieznaneMiesoException {
		GrubeCiasto grubeCiasto = GrubeCiasto.valueOf(scanner.next());
		String miesoS = scanner.next();
		Mieso mieso = null;
		if (miesoS.equals("kurczak") | miesoS.equals("wolowina") | miesoS.equals("mix")) {
			mieso = Mieso.valueOf(miesoS);
		}
		else {
			throw new NieznaneMiesoException();
		}
		int waga = scanner.nextInt();
		double cena = scanner.nextDouble();
		Kebab kebab = new KebabWCiescie(rozmiar, grubeCiasto, mieso, waga, cena);
		return kebab;
	}
	
	private static Kebab parseKebabNaTalerzu(Scanner scanner, Rozmiar rozmiar) throws NieznaneMiesoException {
		Dodatek dodatek = Dodatek.valueOf(scanner.next());
		String miesoS = scanner.next();
		Mieso mieso = null;
		if (miesoS.equals("kurczak") | miesoS.equals("wolowina") | miesoS.equals("mix")) {
			mieso = Mieso.valueOf(miesoS);
		}
		else {
			throw new NieznaneMiesoException();
		}
		int waga = scanner.nextInt();
		Boolean naWynos = scanner.nextBoolean();
		double cena = scanner.nextDouble();
		Kebab kebab = new KebabNaTalerzu(rozmiar, dodatek, mieso, waga, naWynos, cena);
		return kebab;
	}
	
}
