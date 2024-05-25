package pl.edu.pw.mini.po.odloty.procesy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.edu.pw.mini.po.odloty.loty.Loty;
import pl.edu.pw.mini.po.odloty.loty.Odloty;
import pl.edu.pw.mini.po.odloty.loty.Przyloty;
import pl.edu.pw.mini.po.odloty.loty.Status;

public class FlightsParser {

	public static List<Loty> parseFlights(String plik) {
		List<Loty> loty = new ArrayList<Loty>();
		
		File file = new File("resources" + File.separator + plik);
		Scanner skaner;
		try {
			skaner = new Scanner(file);
			skaner.useDelimiter("###");
			while (skaner.hasNextLine()) {
				String typ = skaner.next();
				if (typ.equals("O")){
					loty.add(parseOdloty(skaner));
				}	
				else {
					loty.add(parsePrzyloty(skaner));
				}
				skaner.nextLine();
			}
			skaner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ZlyCheckInZakresException e) {
			e.printStackTrace();
		}
		
		return loty;
	}
	
	private static Loty parseOdloty(Scanner skaner) throws ZlyCheckInZakresException {
		String godzina = skaner.next();
		String dokad = skaner.next();
		String idLotu = skaner.next();
		String linia = skaner.next();
		Status status = Status.valueOf(skaner.next());
		String checkIn = skaner.next();
		Loty odlot = new Odloty(godzina, dokad, idLotu, linia, status, checkIn);
		return odlot;
	}
	
	private static Loty parsePrzyloty(Scanner skaner) {
		String godzina = skaner.next();
		String skad = skaner.next();
		String idLotu = skaner.next();
		String linia = skaner.next();
		Boolean wyladowal = skaner.nextBoolean();
		int nrWyjscia = skaner.nextInt();
		Loty przylot = new Przyloty(godzina, skad, idLotu, linia, wyladowal, nrWyjscia);
		return przylot;
	}
	
}
