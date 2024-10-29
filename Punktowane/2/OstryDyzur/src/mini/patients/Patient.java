package mini.patients;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Patient {

    private int age;
    private Set<Problem> problems;

    @FunctionalInterface
    interface AgeGenerator {
        int generateLimitedAge(int limit);
    }

    @FunctionalInterface
    interface ProblemGenerator {
        Set<Problem> generateProblem(boolean tick);
    }

    public Patient(int ageLimit) {

        AgeGenerator ageGenerator = (int limit) -> {
            Random random = new Random();
            return random.nextInt(limit-1)+1;
        };

        ProblemGenerator problemGenerator = (boolean tick) -> {
            Set<Problem> generatedProblems = new HashSet<>();
            Random random = new Random();
            int p = random.nextInt(4);
            generatedProblems.add(Problem.values()[p]);
            if (tick) {
                generatedProblems.add(Problem.pogryzieniePrzezKleszcza);
            }
            return generatedProblems;
        };

        Random random = new Random();
        this.age = ageGenerator.generateLimitedAge(ageLimit);
        this.problems = problemGenerator.generateProblem(random.nextBoolean());
    }

    public interface Diagnose {
        void diagnoseMe(Patient patient);
    }

    public void applyDiagnose(Diagnose diagnose) {
        diagnose.diagnoseMe(this);
    }

}
