package pl.edu.pw.mini.po.przejscie_graniczne.podrozni;

import java.util.List;
import java.util.Set;

import pl.edu.pw.mini.po.przejscie_graniczne.towary.Towar;

public abstract class Podrozny implements Comparable<Podrozny>{

	private int unikalneId;
	private int wiek;
	private List<Towar> towary;
	
	public Podrozny(int unikalneId, int wiek) {
		this.unikalneId = unikalneId;
		this.wiek = wiek;
	}

	protected void setTowary(List<Towar> towary) {
		this.towary = towary;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Podrozny other = (Podrozny)o;
		if (unikalneId != other.unikalneId)
			return false;
		return true;
	}
	
	public int compareTo(Podrozny o) {
		return unikalneId - o.unikalneId;
	}

	public int getWiek() {
		return wiek;
	}

	public List<Towar> getTowary() {
		return towary;
	}
	
	public String toString() {
		return "";
	}
	
}
