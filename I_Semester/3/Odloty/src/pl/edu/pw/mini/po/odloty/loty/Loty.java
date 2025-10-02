package pl.edu.pw.mini.po.odloty.loty;

import java.util.Objects;

public abstract class Loty implements Comparable<Loty>{

	private String godzina;
	private String idLotu;
	private String linia;
	
	public Loty(String godzina, String idLotu, String linia) {
		super();
		this.godzina = godzina;
		this.idLotu = idLotu;
		this.linia = linia;
	}

	public String getIdLotu() {
		return idLotu;
	}

	@Override
	public int compareTo(Loty o) {
		if (this.idLotu.length() < o.idLotu.length()){
			return -1;
		}
		else if (this.idLotu.length() > o.idLotu.length()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLotu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loty other = (Loty) obj;
		return Objects.equals(idLotu, other.idLotu);
	}
	
}
