package pl.edu.pw.mini.zpoif.task5.model;

import pl.edu.pw.mini.zpoif.task5.annotations.CokolwiekNaCieploLubZimno;
import pl.edu.pw.mini.zpoif.task5.annotations.PolecanyDrink;
import pl.edu.pw.mini.zpoif.task5.annotations.TypDrinka;

@CokolwiekNaCieploLubZimno
public class LadaChlodnicza extends Pracownik {

    public LadaChlodnicza(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void wykonajZadanie(String zamowienie) {
        System.out.println("LadaChlodnicza " + getImie() + " " + getNazwisko() + " przygotowuje " + zamowienie);
    }

    @PolecanyDrink(typDrinka = TypDrinka.OSZUKANY)
    public void wezWodeMineralna() {
        System.out.println("Podanie wody mineralnej.");
    }
}
