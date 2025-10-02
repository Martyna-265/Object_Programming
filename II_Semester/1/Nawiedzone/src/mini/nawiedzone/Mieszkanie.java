package mini.nawiedzone;

public abstract class Mieszkanie extends Miejsce {

    private int wartosc;

    public Mieszkanie(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getWartosc() {
        return wartosc;
    }

}
