package mini.nawiedzone;

import java.util.Random;

public class MieszkanieSpalone extends Mieszkanie {

    private static Random random = new Random();

    public MieszkanieSpalone() {
        super(random.nextInt(25001)+10000);
    }

    @Override
    public void zbadaj(Wizytor wizytor) {
        Straszydlaki straszydlak = new Straszydlaki() {
            @Override
            public void nastraszKogos(Wizytor wizytor) {
                if (wizytor instanceof Kupiec) {
                    Stan stan = ((Kupiec) wizytor).getStan();
                    if (stan == Stan.CHETNY || stan == Stan.POIRYTOWANY) {
                        wizytor.nastraszMnie();
                    }
                }
            }
        };

        if (this.getWartosc() < 15000){
            Straszydlaki.DuchStrazaka duch = new Straszydlaki.DuchStrazaka();
            duch.nastraszKogos(wizytor);
        }

    }
}
