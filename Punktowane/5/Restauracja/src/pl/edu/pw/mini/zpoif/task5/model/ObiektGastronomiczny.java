package pl.edu.pw.mini.zpoif.task5.model;

import pl.edu.pw.mini.zpoif.task5.annotations.InterakcjeZObiektem;

public abstract class ObiektGastronomiczny {
    @InterakcjeZObiektem
    private int liczbaInterakcji;

    public ObiektGastronomiczny() {
        this.liczbaInterakcji = 0;
    }

    public int getLiczbaInterakcji() {
        return liczbaInterakcji;
    }

    public void zwiekszLiczbeInterakcji() {
        liczbaInterakcji++;
    }
}
