package pl.edu.pw.mini.zpoif.task5.model;

import pl.edu.pw.mini.zpoif.task5.annotations.CokolwiekNaCieploLubZimno;
import pl.edu.pw.mini.zpoif.task5.annotations.DanieDnia;
import pl.edu.pw.mini.zpoif.task5.annotations.NiebezpiecznyPosilek;
import pl.edu.pw.mini.zpoif.task5.annotations.StopienRyzyka;

@CokolwiekNaCieploLubZimno
public class Kucharz extends Pracownik {

    public Kucharz(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void wykonajZadanie(String zamowienie) {
        System.out.println("Kucharz " + getImie() + " " + getNazwisko() + " przygotowuje " + zamowienie);
    }

    @DanieDnia
    public void schabowy() {
        System.out.println("Przygotowanie schabowego.");
    }

    @DanieDnia
    public void strogonov() {
        System.out.println("Przygotowanie strogonova.");
    }

    @NiebezpiecznyPosilek(stopienRyzyka = StopienRyzyka.BARDZO_RYZYKOWNE)
    public void trzydniowyTatarZJajkiem() {
        System.out.println("Przygotowanie tatara z jajkiem.");
    }
}
