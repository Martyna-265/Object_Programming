package mini.samoloty;

// protected
public class Mysliwiec extends Samolot {

    private int iloscRakiet;

    public Mysliwiec(String nazwa, int predkoscMax) {
        super(nazwa, predkoscMax);
        this.iloscRakiet = 0;
    }

    @Override
    public void odprawa(int iloscZaladunku) throws WyjatekLotniczy {
        super.odprawa(iloscZaladunku);
        this.iloscRakiet += iloscZaladunku;
    }

    public void atak() {
        if (iloscRakiet <= 0) {
            this.ladujemy();
        }
        else if (this.getStan() == Stan.wPowietrzu) {
            this.iloscRakiet--;
            System.out.println("Ataaaak");
            if (iloscRakiet <= 0) {
                this.ladujemy();
            }
        }
    }

    @Override
    public String toString() {
        String s = "Myśliwiec o nazwie '" + this.getNazwa() + "'. Prędkość maksymalna " +
                this.getPredkoscMax() + ", w powietrzu spędził łącznie " + this.getIloscGodzinWPowietrzu() +
                " godzin.";
        if (this.getStan() == Stan.wPowietrzu) {
            return s + " Obecnie leci, rakiet: " + this.iloscRakiet;
        }
        else {
            return s + " Aktualnie uziemiony.";
        }
    }

}
