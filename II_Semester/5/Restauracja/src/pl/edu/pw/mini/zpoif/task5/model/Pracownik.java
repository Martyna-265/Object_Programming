package pl.edu.pw.mini.zpoif.task5.model;

public abstract class Pracownik extends ObiektGastronomiczny{
    private String imie;
    private String nazwisko;

    public Pracownik(String imie, String nazwisko) {
        super();
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public abstract void wykonajZadanie(String zamowienie);
}
