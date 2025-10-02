package mini.samoloty;

public class SamolotTowarowy extends Samolot {

    private int maxLadunek;
    private int aktualnyLadunek;

    public SamolotTowarowy(String nazwa, int predkoscMax, int maxLadunek) {
        super(nazwa, predkoscMax);
        this.maxLadunek = maxLadunek;
        this.aktualnyLadunek = 0;
    }

    @Override
    public void odprawa(int iloscZaladunku) throws WyjatekLotniczy {
        super.odprawa(iloscZaladunku);
        if (iloscZaladunku+aktualnyLadunek < maxLadunek/2) {
            this.setStan(Stan.przedOdprawa);
            throw new WyjatekEkonomiczny("Zbyt mały ładunek, nie opłaca się lecieć");
        }
        else if (iloscZaladunku+aktualnyLadunek > maxLadunek) {
            int zaDuzo = iloscZaladunku+aktualnyLadunek-maxLadunek;
            this.aktualnyLadunek = maxLadunek;
            throw new WyjatekEkonomiczny("Za dużo o " + zaDuzo + " ton ładunku");
        }
        else {
            this.aktualnyLadunek += iloscZaladunku;
        }
    }

    @Override
    public String toString() {
        String s = "Samolot towarowy o nazwie '" + this.getNazwa() + "'. Prędkość maksymalna " +
                this.getPredkoscMax() + ", w powietrzu spędził łącznie " + this.getIloscGodzinWPowietrzu() +
                " godzin, moze zabrac na pokład " + this.maxLadunek + " ton ładunku.";
        if (this.getStan() == Stan.wPowietrzu) {
            return s + " Obecnie leci z " + this.aktualnyLadunek + " tonami ładunku.";
        }
        else {
            return s + " Aktualnie uziemiony.";
        }
    }

}
