package pl.edu.pw.mini.zpoif.task5.main;

import pl.edu.pw.mini.zpoif.task5.model.*;

public class Main {
    public static void main(String[] args) {
        Kelner kelner = new Kelner();

        // Dodajemy pracowników do kelnera
        kelner.dodajPracownika(new Kucharz("Jan", "Kowalski"));
        kelner.dodajPracownika(new Barman("Marek", "Nowak"));
        kelner.dodajPracownika(new LadaChlodnicza("Anna", "Kaczmarek"));

        // Przyjmujemy zamówienia
        kelner.przyjmijZlecenie("schabowy");
        kelner.przyjmijZlecenie("terminator");
        kelner.przyjmijZlecenie("wezWodeMineralna");
        kelner.przyjmijZlecenie("nieistniejaceDanie");
    }
}
