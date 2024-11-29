package pl.edu.pw.mini.zpoif.task5.model;

public class Barman extends Pracownik {

    public Barman(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void wykonajZadanie(String zamowienie) {
        System.out.println("Barman " + getImie() + " " + getNazwisko() + " przygotowuje " + zamowienie);
    }

    public void terminator() {
        System.out.println("Przygotowanie drinka terminator.");
    }

    public void terazPolska() {
        System.out.println("Przygotowanie drinka teraz Polska.");
    }
}
