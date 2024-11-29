package pl.edu.pw.mini.zpoif.task5.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Kelner implements Kelnerable{

    private List<Pracownik> pracownicy;

    public Kelner() {
        pracownicy = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public void przyjmijZlecenie(String zamowienie) {
        boolean znaleziono = false;

        for (Pracownik pracownik : pracownicy) {
            if (pracownik instanceof Pracownik) {
                Pracownik pracownikInst = (Pracownik) pracownik;
                Method[] metody = pracownikInst.getClass().getMethods();
                for (Method metoda : metody) {

                }
            }
            if (znaleziono) break;
        }

        if (!znaleziono) {
            System.out.println("Dania nie będzie!");
        }
    }
}

