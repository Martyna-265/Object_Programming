package pl.edu.pw.mini.po.kebaby;

import java.util.Objects;

import pl.edu.pw.mini.po.kebaby.processor.KebabVisitor;
import pl.edu.pw.mini.po.kebaby.wartosci.Dodatek;
import pl.edu.pw.mini.po.kebaby.wartosci.Mieso;
import pl.edu.pw.mini.po.kebaby.wartosci.Rozmiar;

public class KebabNaTalerzu extends Kebab {

	private Dodatek dodatek;
	private Boolean NaWynos;
	
	public KebabNaTalerzu(Rozmiar rozmiar, Dodatek dodatek, Mieso mieso, int waga, Boolean naWynos, double cena) {
		super(rozmiar, mieso, waga, cena);
		this.dodatek = dodatek;
		this.NaWynos = naWynos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(NaWynos, dodatek);
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
		KebabNaTalerzu other = (KebabNaTalerzu) obj;
		return Objects.equals(NaWynos, other.NaWynos) && dodatek == other.dodatek;
	}
	
	public void apply (KebabVisitor visitor) {
		visitor.kebabNaTalerzuVisit(this);
	}

	@Override
	public String toString() {
		return "KebabNaTalerzu [rozmiar=" + this.getRozmiar() + " dodatek=" + dodatek + " mieso=" + this.getMieso() + " waga=" + this.getWaga() + ", NaWynos=" + NaWynos + " cena=" + this.getCena()+ "]";
	}
	
	
}
