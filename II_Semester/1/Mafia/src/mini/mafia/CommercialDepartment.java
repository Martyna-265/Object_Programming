package mini.mafia;

import java.util.Random;

public class CommercialDepartment extends Department {

    private int moneyAmount;

    private static Random random = new Random();

    public CommercialDepartment() {
        super(random.nextInt(2));
        this.moneyAmount = random.nextInt(450001)+100000;
    }

    @Override
    public void work() {
        int p = random.nextInt(100);
        if (p < 90) {
            LegalSeller seller = new LegalSeller();
            seller.makeDeal();
        }
        else {
            System.out.println("Dealu nie bedzie!");
        }
    }

}
