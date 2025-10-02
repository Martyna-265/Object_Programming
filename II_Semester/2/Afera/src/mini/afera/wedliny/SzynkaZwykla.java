package mini.afera.wedliny;

public class SzynkaZwykla extends Szynka {

    public SzynkaZwykla() {
        super();
    }

    @FunctionalInterface
    interface SzynkaZwyklaMakeUp {
        void makeUp(SzynkaZwykla szynkaZwykla);
    }

    public void makeMeReadyForConsumption(SzynkaZwyklaMakeUp makeUp) {
        makeUp.makeUp(this);
    }

}
