package pl.edu.pw.mini.zpoif.task5.main;

import pl.edu.pw.mini.zpoif.task5.model.*;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Kelner kelner = new Kelner();

        kelner.dodajPracownika(new Kucharz("Jan", "Kowalski"));
        kelner.dodajPracownika(new Barman("Marek", "Nowak"));
        kelner.dodajPracownika(new LadaChlodnicza("Anna", "Kaczmarek"));
        kelner.dodajPracownika(new Wykidajlo("Krzysztof", "Pazura"));

        try {
            kelner.przyjmijZlecenie(Zamowienie.CokolwiekNaCieploLubZimno);
            kelner.przyjmijZlecenie(Zamowienie.DanieDnia);
            kelner.przyjmijZlecenie(Zamowienie.NiebezpiecznyPosilek);
            kelner.przyjmijZlecenie(Zamowienie.PolecanyDrink);
            kelner.przyjmijZlecenie(Zamowienie.PozbycieSieNiechcianychKlientow);
        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
