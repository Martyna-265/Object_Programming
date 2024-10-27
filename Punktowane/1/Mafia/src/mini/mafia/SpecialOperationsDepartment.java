package mini.mafia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecialOperationsDepartment extends Department {

    private int illegalTransactionalValue;

    private static Random random = new Random();

    public SpecialOperationsDepartment() {
        super(WallColor.Red);
        this.illegalTransactionalValue = random.nextInt(11)+10;
    }

    @Override
    public void internalControl() {
        System.out.println("Kontrola nie jest mozliwa.");
    }

    @Override
    public void work() {

        class Cleaner extends MafiaWorker {
            public void doJob() {
                System.out.println("Wykonuje mokra robote!");
            }
        }

        List<MafiaWorker> cleaners = new ArrayList<>();
        int p = random.nextInt(3);
        for (int i = 0; i < 3; i++) {
            Cleaner cleaner = new Cleaner();
            if (i == p) {
                cleaner.doJob();
            }
            cleaners.add(cleaner);
        }

    }

    private class IllegalSeller extends Seller {

        public void makeDeal() {
            System.out.println("Nielegalna transakcja dokonana");
            this.transactionSummary += illegalTransactionalValue;
        }

    }

}
