package mini.afera.wedliny;

import java.util.Random;

public abstract class Szynka extends Wedlina {

    private boolean bakteriaListeria;
    private static Random random = new Random();

    public Szynka() {
        super();
        int p = random.nextInt(100);
        if (p < 10) {
            this.bakteriaListeria = true;
        }
        else {
            this.bakteriaListeria = false;
        }
    }

    public boolean isBakteriaListeria() {
        return bakteriaListeria;
    }

    public void setBakteriaListeria() {
        this.bakteriaListeria = false;
    }
}
