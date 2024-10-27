package mini.nawiedzone;

public abstract class MieszkanieOpodatkowane extends Mieszkanie {

    private static int podatek = 15;

    public MieszkanieOpodatkowane(int wartosc) {
        super(wartosc);
    }

    public int getWartoscZPodatkiem() {
        return this.getWartosc() + podatek;
    }

    protected void zbadajKuchnie(Wizytor wizytor){

        class DuchSprzedawcy extends Straszydlaki {
        }

        if (this.getWartoscZPodatkiem() > 55000) {
            DuchSprzedawcy duch1 = new DuchSprzedawcy();
            DuchSprzedawcy duch2 = new DuchSprzedawcy();
            duch1.nastraszKogos(wizytor);
            duch2.nastraszKogos(wizytor);
        }

    }

    protected void zbadajSalon(Wizytor wizytor){

    }

}
