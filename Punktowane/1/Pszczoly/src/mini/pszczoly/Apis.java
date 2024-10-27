package mini.pszczoly;

import java.util.*;

public class Apis {

    private List<Pszczola> listaPszczol;
    Random random = new Random();

    public Apis(){
        this.listaPszczol = new ArrayList<>();
        listaPszczol.add(new KrolowaMatka("Maja"));
    }

    public void zyciePszczol(){

        int licznikTruten = 2;
        int licznikRobotnica = random.nextInt(10);
        for (Pszczola pszczola : listaPszczol){
            if (licznikTruten > 0 && pszczola instanceof Truten){
                pszczola.run();
                licznikTruten--;
            }
            if (licznikRobotnica > 0 && pszczola instanceof Robotnica){
                pszczola.run();
                licznikRobotnica--;
            }
        }

    }

    public void sortujWgSilyIImienia() {
        System.out.println("Pszczoly posortowane wg siły i imienia:");
    }

    public void dodajZolnierza() {
        Pszczola zolnierz = new Pszczola("Kaja", 99) {

            @Override
            public String toString() {
                return "Żołnierz " + this.getImie() + " (atak: " +
                        this.getSilaAtaku() + "), żyję " +
                        this.getWiek() + " dni i potrafię użądlić!";
            }

            @Override
            public void run() {
                System.out.println("Walka to moje życie!!!");
            }
        };
        listaPszczol.add(zolnierz);
    }

    public void dodajPszczole() {
        int p = random.nextInt(4);
        if (p == 0) {
            listaPszczol.add(new KrolowaMatka("Alicja"));
        }
        else if (p == 1) {
            listaPszczol.add(new Truten("Gucio"));
        }
        else if (p == 2) {
            listaPszczol.add(new Robotnica("Marta"));
        }
        else {
            dodajZolnierza();
        }
    }

    public void watkiPszczol() {
        System.out.println("Wątki pszczół:");
        for (Pszczola pszczola : listaPszczol) {
            pszczola.run();
        }
    }

    public void wypiszPszczoly() {
        System.out.println("W ulu jest " + listaPszczol.size() + " pszczół");
        for (Pszczola pszczola : listaPszczol) {
            System.out.println(pszczola);
        }
    }

    public abstract class Pszczola implements Runnable {

        private String imie;
        private int silaAtaku;
        private int wiek;

        public Pszczola(String imie, int silaAtaku) {
            this.imie = imie;
            this.silaAtaku = silaAtaku;
            this.wiek = random.nextInt(25);
        }

        @Override
        public String toString() {
            return "Pszczola";
        }

        public String getImie() {
            return imie;
        }

        public int getSilaAtaku() {
            return silaAtaku;
        }

        public int getWiek() {
            return wiek;
        }

    } // end Pszczola

    public class KrolowaMatka extends Pszczola {

        private int iloscJaj;

        public KrolowaMatka(String imie) {
            super(imie, 100);
            this.iloscJaj = 0;
        }

        @Override
        public void run() {
            System.out.println("Lot godowy...");
        }

        private void zaplodnienie() {
            this.iloscJaj += 1000;
        }

        @Override
        public String toString() {
            return "Królowa " + this.getImie() + " (atak: " + this.getSilaAtaku() +
                    "), żyję " + this.getWiek() + " dni i będę matką dla " +
                    this.iloscJaj + " młodych pszczółek";
        }

    } // end KrolowaMatka

    public class Truten extends Pszczola {
        private boolean przydatny;

        public Truten(String imie) {
            super(imie, 0);
            this.przydatny = true;
        }

        @Override
        public void run() {
            int p = random.nextInt(100);
            if (p < 50){
                for (Pszczola pszczola : listaPszczol){
                    if (pszczola instanceof KrolowaMatka){
                        this.zaplodnienie((KrolowaMatka)pszczola);
                        return;
                    }
                }
            }
        }

        private void zaplodnienie(KrolowaMatka krolowa) {
            krolowa.zaplodnienie();
            System.out.println(this.getImie() + " - byłem z Królową!!! Można umierać...");
            this.przydatny = false;
        }

        @Override
        public String toString() {
            String s = "Truteń " + this.getImie() + " (atak: " + this.getSilaAtaku() + "), ";
            if (this.przydatny){
                s += "żyję " + this.getWiek() + " dni";
            }
            else {
                s += "spełniłem swoje zadanie :(";
            }
            return s;
        }

    } // end Truten

    public class Robotnica extends Pszczola {

        private int iloscWyprodukowanegoMiodu;

        public Robotnica(String imie) {
            super(imie, random.nextInt(30));
            this.iloscWyprodukowanegoMiodu = 0;
        }

        @Override
        public void run() {
            int nektar = random.nextInt(21);
            this.zbierajNektar(nektar);
            System.out.println(this.getImie() + " - kolejna porcja miodu do kubełka");
        }

        private void zbierajNektar(int nektar){
            this.iloscWyprodukowanegoMiodu += nektar;
        }

        @Override
        public String toString() {
            return "Robotnica " + this.getImie() + " (atak: " +
                    this.getSilaAtaku() + "), żyję " + this.getWiek() +
                    " dni i zrobiłam " + this.iloscWyprodukowanegoMiodu +
                    " baryłek miodu :)";
        }

    } // end Robotnica

    private class PorownanieSily implements Comparator<Pszczola> {

        @Override
        public int compare(Pszczola pszczola1, Pszczola pszczola2) {
            return Integer.compare(pszczola1.getSilaAtaku(), pszczola2.silaAtaku);
        }
    } // end PorownanieSily

}
