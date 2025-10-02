package pl.edu.pw.mini.po.odloty;

import java.util.List;

import pl.edu.pw.mini.po.odloty.loty.Loty;
import pl.edu.pw.mini.po.odloty.procesy.FlightsParser;
import pl.edu.pw.mini.po.odloty.procesy.FlightsProcessor;

public class Demonstrator {

	public static void main(String[] args) {
		List<Loty> loty = FlightsParser.parseFlights("loty.txt");
		FlightsProcessor processor = new FlightsProcessor(loty);
		System.out.println(processor.getExpectedArrivals());
		System.out.println(processor.getFlightsOrdered());
		
		FlightsParser.parseFlights("loty_bad.txt");

	}

}
