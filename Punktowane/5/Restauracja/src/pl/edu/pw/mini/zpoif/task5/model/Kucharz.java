package pl.edu.pw.mini.zpoif.task5.model;

public class Kucharz extends Pracownik {

    public Kucharz(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void wykonajZadanie(String zamowienie) {
        System.out.println("Kucharz " + getImie() + " " + getNazwisko() + " przygotowuje " + zamowienie);
    }

    public void schabowy() {
        System.out.println("Przygotowanie schabowego.");
    }

    public void strogonov() {
        System.out.println("Przygotowanie strogonova.");
    }
}
