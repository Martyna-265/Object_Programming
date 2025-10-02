package pl.edu.pw.mini.po.konduktor.bilety;

import java.util.Objects;

import pl.edu.pw.mini.po.konduktor.wagon.Stolik;

public class Bilet {

	private Imie imieNabywcy;
	private Nazwisko nazwiskoNabywcy;
	private Relacja relacjaPociagu;
	private Stolik nazwaStolika;
	private boolean skasowany;
	private final int kodZabezpieczajacy; //final?
	
	public Bilet(Imie imieNabywcy, Nazwisko nazwiskoNabywcy, Relacja relacjaPociagu, Stolik nazwaStolika,
			boolean skasowany) {
		this.imieNabywcy = imieNabywcy;
		this.nazwiskoNabywcy = nazwiskoNabywcy;
		this.relacjaPociagu = relacjaPociagu;
		this.nazwaStolika = nazwaStolika;
		this.skasowany = skasowany;
		this.kodZabezpieczajacy = generujHash();
	}

	public int generujHash() { // chyba trochę zbyt trywialny
		return Objects.hash(imieNabywcy, nazwiskoNabywcy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bilet other = (Bilet) obj;
		return nazwaStolika == other.nazwaStolika && relacjaPociagu == other.relacjaPociagu;
	}

	public void skasuj() {
		this.skasowany = true;
	}

	public Stolik getNazwaStolika() {
		return nazwaStolika;
	}
	
}
