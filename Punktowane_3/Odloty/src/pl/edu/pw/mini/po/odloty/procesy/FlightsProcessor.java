package pl.edu.pw.mini.po.odloty.procesy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import pl.edu.pw.mini.po.odloty.loty.Loty;
import pl.edu.pw.mini.po.odloty.loty.Przyloty;

public class FlightsProcessor {

	private List<Loty> allFlights;
	
	public FlightsProcessor(List<Loty> allFlights) {
		super();
		this.allFlights = allFlights;
	}

	public List<Przyloty> getExpectedArrivals() {
		List <Przyloty> przyloty = new LinkedList<Przyloty>();
		for (Loty lot : allFlights) {
			if (lot instanceof Przyloty) {
				if (!((Przyloty) lot).getWyladowal()){
					przyloty.add((Przyloty)lot);
				}
			}
		}
		return przyloty;
	}
	
	public List<Loty> getFlightsOrdered() {
		List<Loty> flightsOrdered = new LinkedList<Loty>(allFlights);
		Collections.sort(flightsOrdered);
		return flightsOrdered;
	}
	
}
