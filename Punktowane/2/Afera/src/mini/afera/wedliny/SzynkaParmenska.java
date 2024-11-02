package mini.afera.wedliny;

import java.util.Random;

public class SzynkaParmenska extends Szynka {

    private Certyfikat certyfikat;
    private static Random random = new Random();

    public SzynkaParmenska() {
        super();
        this.certyfikat = Certyfikat.values()[random.nextInt(3)];
    }

    @FunctionalInterface
    interface SzynkaParmenskaMakeUp {
        void makeUp(SzynkaParmenska szynkaParmenska);
    }

    public void makeMeReadyForConsumption(SzynkaParmenskaMakeUp makeUp) {
        makeUp.makeUp(this);
    }

}
