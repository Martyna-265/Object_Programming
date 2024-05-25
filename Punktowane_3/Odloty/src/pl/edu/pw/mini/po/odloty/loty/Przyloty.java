package pl.edu.pw.mini.po.odloty.loty;

public class Przyloty extends Loty {

	private String skad;
	private Boolean wyladowal;
	private int nrWyjscia;
	
	public Przyloty(String godzina, String skad, String idLotu, String linia, Boolean wyladowal, int nrWyjscia) {
		super(godzina, idLotu, linia);
		this.skad = skad;
		this.wyladowal = wyladowal;
		this.nrWyjscia = nrWyjscia;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public Boolean getWyladowal() {
		return wyladowal;
	}
	
}
