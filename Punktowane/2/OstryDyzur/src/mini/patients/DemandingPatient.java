package mini.patients;

import java.util.Random;

public class DemandingPatient extends InsuredPatient {

    private DemandingLevel demandingLevel;

    @FunctionalInterface
    interface DemandingLevelGenerator {
        DemandingLevel generateDemandingLevel();
    }

    public DemandingPatient(int ageLimit) {
        super(ageLimit);

        DemandingLevelGenerator demandingLevelGenerator = () -> {
            Random random = new Random();
            int p = random.nextInt(100);
            if (p < 45) {
                return DemandingLevel.small;
            }
            else if (p < 90) {
                return DemandingLevel.average;
            }
            return DemandingLevel.big;
        };

        this.demandingLevel = demandingLevelGenerator.generateDemandingLevel();
    }

    public DemandingLevel getDemandingLevel() {
        return demandingLevel;
    }
}
