package mini.mafia;

public abstract class Department extends MafiaOrganization {

    private WallColor wallColor;

    public void internalControl() {
        Controller controller = new Controller();
        controller.check();
    }

    public Department(WallColor wallColor) {
        this.wallColor = wallColor;
    }

    public Department(int n) {
        if (n == 0) {
            this.wallColor = WallColor.Green;
        }
        else {
            this.wallColor = WallColor.Blue;
        }
    }

    protected abstract class Seller extends MafiaWorker {

        protected int transactionSummary;

        public Seller() {
            this.transactionSummary = 0;
        }

        public void makeDeal() {}

    }

    protected class LegalSeller extends Seller {

        public void makeDeal() {
            System.out.println("Legalna transakcja dokonana");
            this.transactionSummary += 2 * VALUE_OF_SINGLE_LEGAL_TRANSACTION;
        }

    }

    protected class Controller extends MafiaWorker {
        public void check() {
            if (wallColor == WallColor.Green) {
                System.out.println("Nie trzeba kontrolowac!");
            }
            else {
                System.out.println("Kontroluje");            }
        }
    }

}
