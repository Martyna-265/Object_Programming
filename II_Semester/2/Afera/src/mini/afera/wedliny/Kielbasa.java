package mini.afera.wedliny;

import mini.afera.narzedzia.SausageFreshmaker;

import java.util.Random;

public class Kielbasa extends Mieso {

    private StopienUwedzenia stopienUwedzenia;
    private static Random random = new Random();

    public Kielbasa() {
        super();
        this.stopienUwedzenia = StopienUwedzenia.values()[random.nextInt(3)];
    }

    @FunctionalInterface
    interface KielbasaMakeUp {
        void makeUp(Kielbasa kielbasa);
    }

    public void makeMeReadyForConsumption(KielbasaMakeUp makeUp) {
        makeUp.makeUp(this);
    }

    public StopienUwedzenia getStopienUwedzenia() {
        return stopienUwedzenia;
    }

    public void setStopienUwedzenia(StopienUwedzenia stopienUwedzenia) {
        this.stopienUwedzenia = stopienUwedzenia;
    }

}
