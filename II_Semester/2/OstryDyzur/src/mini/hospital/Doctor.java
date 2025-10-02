package mini.hospital;

import mini.patients.InsuredPatient;
import mini.patients.Patient;
import mini.patients.Problem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Doctor {

    PatientHolder patientHolder;

    public Doctor() {
        this.patientHolder = new PatientHolder();
    }

    public void diagnoseAll() {
        Random random = new Random();

        Patient.Diagnose tickBiteDiagnose = patient -> {
            int p = random.nextInt(100);
            if ((patient.getAge() < 40 && p < 70) || p < 30) {
                System.out.println("Borelioza!");
            }
            else {
                System.out.println("Pacjent zdrowy!");
            }
        };

        Patient.Diagnose feverDiagnose = patient -> {
            PatientHolder.isCovidPositive(patient);
        };

        Patient.Diagnose comaDiagnose = patient -> {
            patientHolder.generalDiagnose(patient);
        };

        Patient.Diagnose stabWoundDiagnose = patient -> {
            if (patient.getAge() > 60) {
                System.out.println("To nie wyglada dobrze");
            }
            else if (patient instanceof InsuredPatient) {
                System.out.println("Pacjent o nr ubezpieczenia: " + ((InsuredPatient)patient).getIdUbezpieczenia() +
                        " bedzie zyl");
            }
            else {
                System.out.println("Pacjent nie ubezpieczony ale tez bedzie zyl");
            }
        };

        ArrayList<Patient> patients = patientHolder.getPatients();
        for (Patient patient : patients) {
            Set<Problem> problems = patient.getProblems();
            for (Problem problem : problems) {
                if (problem == Problem.tickBite) {
                    patient.applyDiagnose(tickBiteDiagnose);
                }
                if (problem == Problem.fever) {
                    patient.applyDiagnose(feverDiagnose);
                }
                if (problem == Problem.coma) {
                    patient.applyDiagnose(comaDiagnose);
                }
                if (problem == Problem.stabWound) {
                    patient.applyDiagnose(stabWoundDiagnose);
                }
            }
        }
    }

}
