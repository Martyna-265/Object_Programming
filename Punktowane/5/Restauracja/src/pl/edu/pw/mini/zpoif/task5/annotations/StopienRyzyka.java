package pl.edu.pw.mini.zpoif.task5.annotations;

public enum StopienRyzyka {
    RYZYKOWNE("Ryzyko zatrucia lub lekkich dolegliwości"),
    BARDZO_RYZYKOWNE("Duże ryzyko zatrucia, może być niebezpieczne dla zdrowia"),
    EKSTREMALNIE_RYZYKOWNE("Ekstremalne ryzyko, niezalecane dla spożycia");

    private final String opis;

    StopienRyzyka(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}
