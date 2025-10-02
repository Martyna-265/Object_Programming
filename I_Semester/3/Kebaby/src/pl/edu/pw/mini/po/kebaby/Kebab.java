package pl.edu.pw.mini.po.kebaby;

import java.util.Objects;

import pl.edu.pw.mini.po.kebaby.processor.KebabVisitor;
import pl.edu.pw.mini.po.kebaby.wartosci.Mieso;
import pl.edu.pw.mini.po.kebaby.wartosci.Rozmiar;

public abstract class Kebab {

	private Rozmiar rozmiar;
	private Mieso mieso;
	private int waga;
	private double cena;
	
	public Kebab(Rozmiar rozmiar, Mieso mieso, int waga, double cena) {
		this.rozmiar = rozmiar;
		this.mieso = mieso;
		this.waga = waga;
		this.cena = cena;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cena, mieso, rozmiar, waga);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kebab other = (Kebab) obj;
		return Double.doubleToLongBits(cena) == Double.doubleToLongBits(other.cena) && mieso == other.mieso
				&& rozmiar == other.rozmiar && waga == other.waga;
	}
	
	public void apply(KebabVisitor visitor) {}

	public Rozmiar getRozmiar() {
		return rozmiar;
	}

	public Mieso getMieso() {
		return mieso;
	}

	public int getWaga() {
		return waga;
	}

	public double getCena() {
		return cena;
	}
	
}
