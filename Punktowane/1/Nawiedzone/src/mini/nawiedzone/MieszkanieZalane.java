package mini.nawiedzone;

import java.util.Random;

public class MieszkanieZalane extends MieszkanieOpodatkowane {

    private static Random random = new Random();

    public MieszkanieZalane() {
        super(random.nextInt(25001)+25000);
    }

    @Override
    public void zbadaj(Wizytor wizytor) {

        class DuchPlywaka extends Straszydlaki {

        }

        int p = random.nextInt(100);
        if (p < 50) {
            this.zbadajKuchnie(wizytor);
            DuchPlywaka duch1 = new DuchPlywaka();
            duch1.nastraszKogos(wizytor);
        }
        else {
            this.zbadajSalon(wizytor);
            DuchPlywaka duch2 = new DuchPlywaka();
            duch2.nastraszKogos(wizytor);
        }
    }

}
