package mini.afera.narzedzia;

import mini.afera.wedliny.Mieso;
import mini.afera.wedliny.Szynka;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class SausageReviewer {

    private SausageHolder sausageHolder;

    public SausageReviewer(SausageHolder sausageHolder) {
        this.sausageHolder = sausageHolder;
    }

    public LinkedList<Mieso> getHamUnit4Consumption () {
        LinkedList<Mieso> szynki = new LinkedList<>();

        Consumer<Mieso> HamUnit4Consumer = mieso -> {
            if (mieso instanceof Szynka) {
                Period period = Period.between(((Szynka) mieso).getDataPrzydatnosci(), LocalDate.now());
                if (period.getDays() >= 5 && period.getDays() <= 8) {
                    szynki.add(mieso);
                }
            }
        };

        sausageHolder.getWedliny().forEach(HamUnit4Consumer);
        return szynki;
    }

    public void printTheWorstHams () {
        Consumer<Mieso> TheWorstHamsPrinter = mieso -> {
            if (mieso instanceof Szynka) {
                if (!((Szynka) mieso).isSzczelneOpakowanie() && ((Szynka) mieso).isBakteriaListeria() &&
                ((Szynka) mieso).getDataPrzydatnosci().isAfter(LocalDate.now())) {
                    System.out.println(mieso);
                }
            }
        };
        sausageHolder.getWedliny().forEach(TheWorstHamsPrinter);
    }

    public void printLessThanAvg () {
        Consumer<Mieso> LessThanAvgPrinter = new Consumer<Mieso>() {
            private int counter = 0;
            private int suma = 0;

            @Override
            public void accept(Mieso mieso) {
                counter++;
                if (counter < 10) {
                    suma += mieso.getIdProduktu();
                }
                else {
                    if (mieso.getIdProduktu() < suma) {
                        Mieso.printId(mieso);
                    }
                }
            }
        };

        sausageHolder.getWedliny().forEach(LessThanAvgPrinter);
    }

    public Szynka getListeriaNegativeAndFitSingleHam () {
        LinkedList<Mieso> szynki = new LinkedList<>();

        Consumer<Mieso> HamConsumer = mieso -> {
            if (mieso instanceof Szynka) {
                if (!((Szynka) mieso).isBakteriaListeria() &&
                        ((Szynka) mieso).getDataPrzydatnosci().isBefore(LocalDate.now())) {
                    szynki.add(mieso);
                }
            }
        };

        Comparator<Mieso> IdComparator = (Mieso mieso1, Mieso mieso2) -> {
            return Integer.compare(mieso1.getIdProduktu(), mieso2.getIdProduktu());
        };

        sausageHolder.getWedliny().forEach(HamConsumer);
        szynki.sort(IdComparator);
        return (Szynka) szynki.getFirst();
    }

    public SausageHolder getSausageHolder() {
        return sausageHolder;
    }
}
