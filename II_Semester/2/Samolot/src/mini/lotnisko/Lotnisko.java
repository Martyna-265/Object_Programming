package mini.lotnisko;

import mini.samoloty.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;

public class Lotnisko {

    private ArrayList<Samolot> samoloty;
    private Random random = new Random();

    public Lotnisko(int liczbaSamolotow) {
        this.samoloty = new ArrayList<>();
        this.generujSamoloty(liczbaSamolotow);

    }

    private void generujSamoloty(int liczbaSamolotow) {

        @FunctionalInterface
        interface Generator {
            String generuj();
        }

        for (int i = 0; i < liczbaSamolotow; i++) {

            Generator generator = () -> {
                int dlugosc = random.nextInt(20)+1;
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < dlugosc; j++){
                    s.append((char) ('a' + random.nextInt(26)));
                }
                return s.toString();
            };

            int p = random.nextInt(3);
            if (p == 0) {
                samoloty.add(new SamolotPasazerski(generator.generuj(),
                        random.nextInt(501)+500,
                        random.nextInt(201)+100));
            }
            else if (p == 1) {
                samoloty.add(new SamolotTowarowy(generator.generuj(),
                        random.nextInt(401)+300,
                        random.nextInt(91)+10));
            }
            else {
                samoloty.add(new Mysliwiec(generator.generuj(),
                        random.nextInt(2101)+900));
            }
        }
    }

    public void odprawaSamolotow() {
        for (Samolot samolot : samoloty) {
            try {
                int zaladunek = 0;
                if (samolot instanceof SamolotPasazerski) {
                    zaladunek = random.nextInt(401);
                } else if (samolot instanceof SamolotTowarowy) {
                    zaladunek = random.nextInt(200);
                } else {
                    zaladunek = random.nextInt(10);
                }
                samolot.odprawa(zaladunek);
            } catch (WyjatekLotniczy e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void dzialaniaLotniskowe() {

        Consumer<Samolot> samolotyToString = samolot -> {
            System.out.println(samolot);
        };

        Consumer<Samolot> samolotyLaduj = samolot -> {
            samolot.ladujemy();
        };

        Consumer<Samolot> samolotyOdprawa = samolot -> {
            try {
                int p = random.nextInt(400);
                samolot.odprawa(p);
            } catch (WyjatekLotniczy e) {
                System.out.println(e.getMessage());
            }
        };

        Consumer<Samolot> samolotyLec = samolot -> {
            samolot.lec(10);
        };

        Consumer<Samolot> samolotyAtak = samolot -> {
            if (samolot instanceof Mysliwiec) {
                ((Mysliwiec) samolot).atak();
            }
        };

        samoloty.forEach(samolotyToString);
        samoloty.forEach(samolotyLaduj);
        samoloty.forEach(samolotyToString);
        samoloty.forEach(samolotyOdprawa);
        samoloty.forEach(samolotyToString);
        samoloty.forEach(samolotyLec);
        samoloty.forEach(samolotyToString);
        samoloty.forEach(samolotyAtak);
        samoloty.forEach(samolotyToString);

    }

    public void wypiszSamoloty() {
        for (Samolot samolot : samoloty) {
            System.out.println(samolot);
        }
    }

    public void odlotSamolotow() {
        for (Samolot samolot : samoloty) {
            samolot.lec(10);
        }
    }

    public void sortowanieSamolotow(int opcja) {

        Comparator<Samolot> maxPredkoscComparator = (Samolot s1, Samolot s2) -> {
            return Integer.compare(s1.getPredkoscMax(), s2.getPredkoscMax());
        };

        Comparator<Samolot> nazwaComparator = (Samolot s1, Samolot s2) -> {
            if (s1.getNazwa().length() > 5 && s2.getNazwa().length() > 5) {
                return s1.getNazwa().compareTo(s2.getNazwa());
            }
            else {
                return Integer.compare(s1.getNazwa().length(), s2.getNazwa().length());
            }
        };

        if (opcja == 0) {
            samoloty.sort(maxPredkoscComparator);
        }
        else {
            samoloty.sort(nazwaComparator);
        }

    }

    interface RandomGenerator {
        void losoweSortowanie();
    }

    public void sortowanieLosowe() {
        RandomGenerator randomSort = () -> {
            int p = random.nextInt(2);
            sortowanieSamolotow(p);
        };

        randomSort.losoweSortowanie();
    }

}
