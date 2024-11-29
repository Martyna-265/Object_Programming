package pl.edu.pw.mini.zpoif.task5.model;

public class LadaChlodnicza extends Pracownik {

    public LadaChlodnicza(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void wykonajZadanie(String zamowienie) {
        System.out.println("LadaChlodnicza " + getImie() + " " + getNazwisko() + " przygotowuje " + zamowienie);
    }

    public void wezWodeMineralna() {
        System.out.println("Podanie wody mineralnej.");
    }
}
