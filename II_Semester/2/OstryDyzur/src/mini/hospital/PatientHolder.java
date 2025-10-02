package mini.hospital;

import mini.patients.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

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

    public ArrayList<Patient> extractDemandingPatients() {
        ArrayList<Patient> demandingPatients = new ArrayList<>();

        Consumer<Patient> demandingPatientsExtractor = p -> {
            if (p instanceof DemandingPatient && ((DemandingPatient) p).getDemandingLevel() != DemandingLevel.big) {
                demandingPatients.add(p);
            }
        };

        patients.forEach(demandingPatientsExtractor);

        return demandingPatients;
    }

    public void detectNotInsuredPatients() {

        Consumer<Patient> notInsuredPatientsDetector = p -> {
            if (!(p instanceof InsuredPatient)) {
                System.out.println("Brak ubezpieczenia!");
            }
        };

        patients.forEach(notInsuredPatientsDetector);
    }

    public void detectTickBiten() {

        patients.forEach(new Consumer<Patient>() {
            int numberOfTickBiten = 0;

            @Override
            public void accept(Patient patient) {
                Set<Problem> patientsProblems = patient.getProblems();
                if (patientsProblems.contains(Problem.tickBite)) {
                    numberOfTickBiten++;
                }
                if (numberOfTickBiten % 3 == 0) {
                    System.out.println("To juz kolejna trojka pacjentow pogryzionych przez kleszcze w tym tygodniu");
                }
            }
        });

    }

}
