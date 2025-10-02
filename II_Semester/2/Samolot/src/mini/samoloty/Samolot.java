package mini.samoloty;

public abstract class Samolot {

    private String nazwa;
    private int predkoscMax;
    private int iloscGodzinWPowietrzu;
    private Stan stan;

    public Samolot(String nazwa, int predkoscMax) {
        this.nazwa = nazwa;
        this.predkoscMax = predkoscMax;
        this.iloscGodzinWPowietrzu = 0;
        this.stan = Stan.przedOdprawa;
    }

    public void lec (int liczbaGodzin) {
        if (stan == Stan.poOdprawie) {
            System.out.println("Startujemy");
            this.iloscGodzinWPowietrzu += liczbaGodzin;
            this.stan = Stan.wPowietrzu;
        }
        else if (stan == Stan.wPowietrzu) {
            System.out.println("Lecimy");
        }
        else if (stan == Stan.przedOdprawa) {
            System.out.println("Nie możemy wystartować");
        }
    }

    public void ladujemy () {
        if (stan == Stan.wPowietrzu) {
            System.out.println("Ladujemy");
            stan = Stan.przedOdprawa;
        }
        else {
            System.out.println("I tak jestesmy na ziemi");
        }
    }

    public void odprawa (int iloscZaladunku) throws WyjatekLotniczy {
        if (this.stan != Stan.przedOdprawa) {
            throw new WyjatekLotniczy("Błąd odprawy");
        }
        this.stan = Stan.poOdprawie;
    }

    public Stan getStan() {
        return stan;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getPredkoscMax() {
        return predkoscMax;
    }

    public int getIloscGodzinWPowietrzu() {
        return iloscGodzinWPowietrzu;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }
}
