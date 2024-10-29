package mini.hospital;

import mini.patients.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PatientHolder {

    private ArrayList<Patient> patients;
    private int diagnoses;
    private static Random random = new Random();

    public PatientHolder() {
        this.diagnoses = 0;
        this.patients = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            patients.add(new CooperatingPatient(50));
            patients.add(new DemandingPatient(100));
            patients.add(new UnderagePatient(18));
            patients.add(new UninsuredPatient(70));
        }
        Collections.shuffle(patients);
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public static void isCovidPositive(Patient patient) {
        int p = random.nextInt(100);
        if (p < 10) {
            System.out.println("Tak");
        }
        else {
            System.out.println("Nie");
        }
    }

    public void generalDiagnose(Patient patient) {
        diagnoses++;
        if (diagnoses > 10) {
            System.out.println("Brak limitu punktow");
        }
        else {
            boolean p = random.nextBoolean();
            if (p) {
                System.out.println("Chory");
            }
            else {
                System.out.println("Zdrowy");
            }
        }
    }

}
