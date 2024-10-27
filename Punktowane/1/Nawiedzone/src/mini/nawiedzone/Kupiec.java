package mini.nawiedzone;

public class Kupiec extends Wizytor{

    private Stan stan;
    private int licznikPrzestraszen;

    public Kupiec() {
        super();
        this.stan = Stan.CHETNY;
        this.licznikPrzestraszen = 0;
    }

    @Override
    public void nastraszMnie() {
        super.nastraszMnie();
        this.licznikPrzestraszen++;
        this.checkLicznik();
        System.out.println(this);
    }

    private void checkLicznik() {
        if (licznikPrzestraszen > 2) {
            this.stan = Stan.NEUTRALNY;
        }
        else if (licznikPrzestraszen > 5) {
            this.stan = Stan.POIRYTOWANY;
        }
        else {
            this.stan = Stan.ZNIECHECONY;
        }
    }

    @Override
    public String toString() {
        return "Kupiec{" +
                "stan=" + stan +
                '}';
    }

    public Stan getStan() {
        return this.stan;
    }

}
