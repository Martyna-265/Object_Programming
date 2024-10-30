package mini.patients;

import java.util.Random;
import java.util.Set;

public abstract class InsuredPatient extends Patient {

    private int idUbezpieczenia;

    @FunctionalInterface
    interface InsuranceIdGenerator {
        int generateInsuranceId();
    }

    public InsuredPatient(int ageLimit) {
        super(ageLimit);

        InsuranceIdGenerator insuranceIdGenerator = () -> {
            Random random = new Random();
            int id = random.nextInt(10000)+10440000;
            return id;
        };

        this.idUbezpieczenia = insuranceIdGenerator.generateInsuranceId();
    }

    public int getIdUbezpieczenia() {
        return idUbezpieczenia;
    }

}
