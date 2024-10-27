package mini.mafia;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RecruitmentDepartment extends Department {

    private static final int dailyLimit = 5;

    public RecruitmentDepartment() {
        super(WallColor.White);
    }

    @Override
    public void work() {

        class Recruiter extends MafiaWorker {
            private Random random = new Random();

            public void recruit() {
                boolean p = random.nextBoolean();
                if (p) {
                    System.out.println("Zrekrutowalem!");
                }
                else {
                    System.out.println("Porazka! :(");
                }
            }
        }

        Set<MafiaWorker> recruiters = new HashSet<>();
        for (int i = 0; i < 5; i++){
            Recruiter recruiter = new Recruiter();
            recruiter.recruit();
            recruiters.add(recruiter);
        }

    }
}
