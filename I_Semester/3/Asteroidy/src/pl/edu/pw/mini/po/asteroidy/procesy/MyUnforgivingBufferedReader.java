package pl.edu.pw.mini.po.asteroidy.procesy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class MyUnforgivingBufferedReader extends BufferedReader {

	private Map<String, Integer> liczbawystapien;
	
	public MyUnforgivingBufferedReader(Reader in) {
		super(in);
		this.liczbawystapien = new HashMap<String, Integer>();
	}

	public String readLine() throws IOException {
		String line = super.readLine();
		if (line != null) {
			if (liczbawystapien.containsKey(line)) {
				liczbawystapien.replace(line, liczbawystapien.get(line)+1);
			}
			else {
				liczbawystapien.put(line, 1);
			}
		}
		return super.readLine();
	}
	
	public String myReadLine() throws IOException {
		String line = super.readLine();
		if (line != null) {
			if (liczbawystapien.containsKey(line)) {
				liczbawystapien.replace(line, liczbawystapien.get(line)+1);
				System.out.println(line + "liczba wystapien: " + liczbawystapien.get(line));
			}
			else {
				liczbawystapien.put(line, 1);
			}
		}
		return super.readLine();
	}
	

}
