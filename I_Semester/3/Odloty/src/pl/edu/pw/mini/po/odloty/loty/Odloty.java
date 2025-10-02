package pl.edu.pw.mini.po.odloty.loty;

import java.util.Scanner;

import pl.edu.pw.mini.po.odloty.procesy.ZlyCheckInZakresException;

public class Odloty extends Loty{

	private String dokad;
	private Status status;
	private String checkIn;
	private int checkInOd;
	private int checkInDo;
	
	public Odloty(String godzina, String dokad, String idLotu, String linia, Status status, String checkIn) throws ZlyCheckInZakresException {
		super(godzina, idLotu, linia);
		this.dokad = dokad;
		this.status = status;
		this.checkIn = checkIn;
		zakresCheckIn();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	private void zakresCheckIn() throws ZlyCheckInZakresException{
		Scanner skaner = new Scanner(this.checkIn);
		skaner.useDelimiter("-");
		this.checkInOd = Integer.valueOf(skaner.next());
		this.checkInDo = Integer.valueOf(skaner.next());
		if (this.checkInOd > this.checkInDo) {
			throw new ZlyCheckInZakresException();
		}
	}
	
}
