package pl.edu.pw.mini.zpoif.task5.main;

import pl.edu.pw.mini.zpoif.task5.annotations.InterakcjeZObiektem;

public enum Zamowienie {
    CokolwiekNaCieploLubZimno("pl.edu.pw.mini.zpoif.task5.annotations.CokolwiekNaCieploLubZimno"),
    DanieDnia("pl.edu.pw.mini.zpoif.task5.annotations.DanieDnia"),
    NiebezpiecznyPosilek("pl.edu.pw.mini.zpoif.task5.annotations.NiebezpiecznyPosilek"),
    PolecanyDrink("pl.edu.pw.mini.zpoif.task5.annotations.PolecanyDrink"),
    //InterakcjeZObiektem("pl.edu.pw.mini.zpoif.task5.annotations.InterakcjeZObiektem"),
    PozbycieSieNiechcianychKlientow("pl.edu.pw.mini.zpoif.task5.annotations.PozbycieSieNiechcianychKlientow");

    private final String nazwaKlasy;

    Zamowienie(String nazwaKlasy) {
        this.nazwaKlasy = nazwaKlasy;
    }

    public String getNazwaKlasy() {
        return nazwaKlasy;
    }
}
