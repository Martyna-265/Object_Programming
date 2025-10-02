package mini.samoloty;

public class SamolotPasazerski extends Samolot {

    private int maxLiczbaPasazerow;
    private int aktualnaLiczbaPasazerow;

    public SamolotPasazerski(String nazwa, int predkoscMax, int maxLiczbaPasazerow) {
        super(nazwa, predkoscMax);
        this.maxLiczbaPasazerow = maxLiczbaPasazerow;
        this.aktualnaLiczbaPasazerow = 0;
    }

    @Override
    public void odprawa(int iloscZaladunku) throws WyjatekLotniczy {
        super.odprawa(iloscZaladunku);
        if (iloscZaladunku+aktualnaLiczbaPasazerow < maxLiczbaPasazerow/2) {
            this.setStan(Stan.przedOdprawa);
            throw new WyjatekEkonomiczny("Za mało pasażerów, nie opłaca się lecieć");
        }
        else if (iloscZaladunku+aktualnaLiczbaPasazerow > maxLiczbaPasazerow) {
            int zaDuzo = iloscZaladunku+aktualnaLiczbaPasazerow-maxLiczbaPasazerow;
            this.aktualnaLiczbaPasazerow = maxLiczbaPasazerow;
            throw new WyjatekEkonomiczny("Za dużo o " + zaDuzo + " pasażerów");
        }
        else {
            this.aktualnaLiczbaPasazerow += iloscZaladunku;
        }
    }

    @Override
    public String toString() {
        String s = "Samolot pasażerski o nazwie '" + this.getNazwa() + "'. Prędkość maksymalna " +
                this.getPredkoscMax() + ", w powietrzu spędził łącznie " + this.getIloscGodzinWPowietrzu() +
                " godzin, moze zabrac na pokład " + this.maxLiczbaPasazerow + " pasażerów.";
        if (this.getStan() == Stan.wPowietrzu) {
            return s + " Obecnie leci z " + this.aktualnaLiczbaPasazerow + " pasażerami na pokładzie.";
        }
        else {
            return s + " Aktualnie uziemiony.";
        }
    }

}
