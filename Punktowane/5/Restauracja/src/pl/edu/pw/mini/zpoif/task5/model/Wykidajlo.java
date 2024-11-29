package pl.edu.pw.mini.zpoif.task5.model;

import pl.edu.pw.mini.zpoif.task5.annotations.PozbycieSieNiechcianychKlientow;

public class Wykidajlo extends Pracownik {

    public Wykidajlo(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void wykonajZadanie(String zamowienie) {
        System.out.println("Wykidajło " + getImie() + " " + getNazwisko() + " rozwiązuje problem: " + zamowienie);
    }

    @PozbycieSieNiechcianychKlientow(informacjaDlaKlienta = "Zakłócanie porządku")
    public void kulturalneWyproszenieKlienta(String powod) {
        System.out.println("Proszę opuścić lokal. Powód: " + powod);
    }

    @PozbycieSieNiechcianychKlientow
    public void niekulturalneWyrzucenieKlienta() {
        System.out.println("Wyrzucam klienta siłą!");
    }
}
