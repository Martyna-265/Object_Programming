package mini.afera.wedliny;

import java.util.Random;

public class Kielbasa extends Mieso {

    private StopienUwedzenia stopienUwedzenia;
    private static Random random = new Random();

    public Kielbasa() {
        super();
        this.stopienUwedzenia = StopienUwedzenia.values()[random.nextInt(3)];
    }
}
