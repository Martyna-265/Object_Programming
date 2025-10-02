package pl.edu.pw.mini.po.kebaby;

import java.util.Objects;

import pl.edu.pw.mini.po.kebaby.wartosci.GrubeCiasto;
import pl.edu.pw.mini.po.kebaby.wartosci.Mieso;
import pl.edu.pw.mini.po.kebaby.wartosci.Rozmiar;

public class KebabWCiescie extends Kebab {

	private GrubeCiasto grubeCiasto;

	public KebabWCiescie(Rozmiar rozmiar, GrubeCiasto grubeCiasto, Mieso mieso, int waga, double cena) {
		super(rozmiar, mieso, waga, cena);
		this.grubeCiasto = grubeCiasto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(grubeCiasto);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		KebabWCiescie other = (KebabWCiescie) obj;
		return Objects.equals(grubeCiasto, other.grubeCiasto);
	}
	
	@Override
	public String toString() {
		return "KebabWCiescie [rozmiar=" + this.getRozmiar() + " grubeCiasto=" + grubeCiasto + " mieso=" + this.getMieso() + " waga=" + this.getWaga() + " cena=" + this.getCena()+ "]";
	}
	
}
