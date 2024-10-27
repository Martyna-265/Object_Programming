package mini.nawiedzone;

import java.util.Random;

public class MieszkanieZabalaganione extends MieszkanieOpodatkowane {

    private static Random random = new Random();

    public MieszkanieZabalaganione() {
        super(random.nextInt(50001)+25000);
    }

    @Override
    public void zbadaj(Wizytor wizytor) {
        int p = random.nextInt(100);
        if (p < 40) {
            this.zbadajKuchnie(wizytor);
            this.zbadajSalon(wizytor);
        }
    }

    @Override
    protected void zbadajSalon(Wizytor wizytor) {
        super.zbadajSalon(wizytor);

        class DuchStudenta extends Straszydlaki {
            @Override
            public void nastraszKogos(Wizytor wizytor) {
                if (wizytor instanceof Sprzedawca) {
                    wizytor.nastraszMnie();
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            DuchStudenta duch = new DuchStudenta();
            duch.nastraszKogos(wizytor);
        }

    }
}
