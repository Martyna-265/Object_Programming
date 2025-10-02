package pl.edu.pw.mini.zpoif.task5.model;

import pl.edu.pw.mini.zpoif.task5.annotations.NiebezpiecznyPosilek;
import pl.edu.pw.mini.zpoif.task5.annotations.PolecanyDrink;
import pl.edu.pw.mini.zpoif.task5.annotations.StopienRyzyka;
import pl.edu.pw.mini.zpoif.task5.annotations.TypDrinka;

public class Barman extends Pracownik {

    public Barman(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void wykonajZadanie(String zamowienie) {
        System.out.println("Barman " + getImie() + " " + getNazwisko() + " przygotowuje " + zamowienie);
    }

    @NiebezpiecznyPosilek(stopienRyzyka = StopienRyzyka.EKSTREMALNIE_RYZYKOWNE)
    @PolecanyDrink
    public void terminator() {
        System.out.println("Przygotowanie drinka terminator.");
    }

    @PolecanyDrink(typDrinka = TypDrinka.NORMLANY)
    public void terazPolska() {
        System.out.println("Przygotowanie drinka teraz Polska.");
    }

    @PolecanyDrink
    public void blackRussian() {
        System.out.println("Przygotowanie drinka black Russian.");
    }
}
