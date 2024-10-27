package mini.mafia;

import java.util.Random;

public class Management extends MafiaOrganization {

    private boolean hasGodfather;

    private static Random random = new Random();

    public Management() {
        this.hasGodfather = random.nextBoolean();
    }

    @Override
    public void work() {

//        MafiaWorker godFather = new MafiaWorker() {
//            void bless() {
//                System.out.println("Popieram!");
//            }
//        };

        class GodFather extends MafiaWorker {
            void bless() {
                System.out.println("Popieram!");
            }
        }

        GodFather godFather = new GodFather();

        int p = random.nextInt(100);
        if (p < 40) {
            godFather.bless();
        }

        // tworzy ojca + p=0.4 bless
    }

}
