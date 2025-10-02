package pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.ludzie_z_zewnatrz.Visitor;

public abstract class Uczestnik {

	private static final Random random = new Random();
	static int counter;
	
	private int unikalneId;
	private int wiek;
	private String imie;
	private String nazwisko;
	private ArrayList<String> imiona = new ArrayList<String>();{
		imiona.add("Ola");
		imiona.add("Ada");
		imiona.add("Kasia");
		imiona.add("Martyna");
		imiona.add("Ania");
		imiona.add("Bartosz");
		imiona.add("Krystian");
		imiona.add("Olek");
		imiona.add("Daniel");
		imiona.add("Piotr");
	}
	private ArrayList<String> nazwiska = new ArrayList<String>();{
		nazwiska.add("Zawadka");
		nazwiska.add("Wojterska");
		nazwiska.add("Skoczylas");
		nazwiska.add("Sadowska");
		nazwiska.add("Rotuska");
		nazwiska.add("Salata");
		nazwiska.add("Ostrowski");
		nazwiska.add("Wiaderny");
		nazwiska.add("Gotowicki");
		nazwiska.add("Sledzik");
	}
	
	public Uczestnik(int wiek) {
		this.unikalneId = counter++;
		this.wiek = wiek;
		this.imie = imiona.get(random.nextInt(10));
		this.nazwisko = nazwiska.get(random.nextInt(10));
	}

	protected void setImie(String imie) {
		this.imie = imie;
	}

	protected void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public ArrayList<String> getImiona() {
		return imiona;
	}

	public ArrayList<String> getNazwiska() {
		return nazwiska;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uczestnik other = (Uczestnik) obj;
		return unikalneId == other.unikalneId;
	}

	public int getWiek() {
		return wiek;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}
	
	public void accept(Visitor visitor) {
	}
	
}
