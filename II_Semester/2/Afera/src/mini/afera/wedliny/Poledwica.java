package mini.afera.wedliny;

public class Poledwica extends Wedlina {

    public Poledwica() {
        super();
    }

    @FunctionalInterface
    interface PoledwicaMakeUp {
        void makeUp(Poledwica poledwica);
    }

    public void makeMeReadyForConsumption(PoledwicaMakeUp makeUp) {
        makeUp.makeUp(this);
    }

}
