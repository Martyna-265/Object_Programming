package pl.edu.pw.mini.po.asteroidy.procesy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

import pl.edu.pw.mini.po.asteroidy.informacje.InformacjeOgolne;
import pl.edu.pw.mini.po.asteroidy.informacje.InformacjeSzczegolowe;
import pl.edu.pw.mini.po.asteroidy.informacje.wartosci.NiepoprawnyZasiegException;
import pl.edu.pw.mini.po.asteroidy.informacje.wartosci.Orbita;
import pl.edu.pw.mini.po.asteroidy.informacje.wartosci.Srednica;

public class AstroParser {

	public static TreeSet<InformacjeOgolne> parseReliableAsteroidInformation(String nazwaPliku) throws NiepoprawnyZasiegException{
		TreeSet<InformacjeOgolne> asteroidy = new TreeSet<InformacjeOgolne>(Collections.reverseOrder());
		
		File plik = new File("from_nasa" + File.separator + nazwaPliku);
		try {
			Scanner scanner = new Scanner(plik);
			scanner.useDelimiter("___");
			
			while (scanner.hasNextLine()) {
//				int id = scanner.nextInt();
//				String nazwa = scanner.next();
//				Srednica srednica = new Srednica(scanner.next());
//				Boolean zagrozenie = scanner.nextBoolean();
//				String dataBliskiegoPrzejscia = scanner.next();
//				double predkosc = scanner.nextDouble();
//				double dystans = scanner.nextDouble();
//				Orbita oributujeWokol = Orbita.valueOf(scanner.next().toUpperCase());
//				String link = scanner.next();
				
				String line = scanner.nextLine();
                String[] parts = line.split("___");

                int id = Integer.parseInt(parts[0]);
                String nazwa = parts[1];
                Srednica srednica = new Srednica(parts[2]);
                boolean zagrozenie = Boolean.parseBoolean(parts[3].toLowerCase());
                String dataBliskiegoPrzejscia = parts[4];
                double predkosc = Double.parseDouble(parts[5]);
                double dystans = Double.parseDouble(parts[6]);
                Orbita oributujeWokol = Orbita.valueOf(parts[7].toUpperCase());
                String link = parts[8];
				
                InformacjeOgolne asteroida;
				if (zagrozenie) {
					asteroida = new InformacjeSzczegolowe(id, nazwa, srednica, zagrozenie, dataBliskiegoPrzejscia, predkosc, dystans, oributujeWokol, link);
				}	
				else {
					asteroida = new InformacjeOgolne(id, nazwa, srednica);
				}
				asteroidy.add(asteroida);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return asteroidy;
	}
	
}
