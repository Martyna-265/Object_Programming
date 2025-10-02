package mini.afera.narzedzia;

import mini.afera.wedliny.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Random;
import java.util.function.Consumer;

public class SausageFreshmaker {

    private SausageReviewer sausageReviewer;
    private static Random random = new Random();

    public SausageFreshmaker(SausageReviewer sausageReviewer) {
        this.sausageReviewer = sausageReviewer;
    }

    public void upgradeHams() {
        LinkedList<Mieso> szynki = sausageReviewer.getHamUnit4Consumption();

        Consumer<Mieso> HamUpgrader = szynka -> {
            ((Wedlina)szynka).setGoodDataPrzydatnosci();
            ((Szynka)szynka).setBakteriaListeria();
        };

        szynki.forEach(HamUpgrader);
    }

    public void upgradeDates() {
        LinkedList<Mieso> miesa = sausageReviewer.getSausageHolder().getWedliny();

        Consumer<Mieso> DateUpgrader = mieso -> {
            LocalDate date = LocalDate.now().plusDays(random.nextInt());
            if (mieso instanceof Wedlina) {
                ((Wedlina)mieso).setDataPrzydatnosci(date);
            }
        };

        miesa.forEach(DateUpgrader);
    }

    public void upgraeSausages() {
        LinkedList<Mieso> miesa = sausageReviewer.getSausageHolder().getWedliny();

        Consumer<Mieso> SausageUpgrader = mieso -> {
            if (mieso instanceof Kielbasa) {
                if (((Kielbasa)mieso).getStopienUwedzenia() == StopienUwedzenia.maly) {
                    ((Kielbasa)mieso).setStopienUwedzenia(StopienUwedzenia.duzy);
                }
            }
        };

        miesa.forEach(SausageUpgrader);
    }

}
