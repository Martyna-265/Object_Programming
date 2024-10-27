package mini.nawiedzone;

import java.util.ArrayList;
import java.util.List;

public class Demonstrator {

    public static void main(String[] args) {

        List<Miejsce> miejsca = new ArrayList<>();
        miejsca.add(new MieszkanieSpalone());
        miejsca.add(new MieszkanieZabalaganione());
        miejsca.add(new MieszkanieZalane());
        miejsca.add(new SklepRybka());

        List<Wizytor> ludzie = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ludzie.add(new Kupiec());
            ludzie.add(new Sprzedawca());
        }

        for (Wizytor wizytor : ludzie) {
            for (Miejsce miejsce : miejsca) {
                miejsce.zbadaj(wizytor);
            }
        }

        Straszydlaki.DuchStrazaka duch = new Straszydlaki.DuchStrazaka();
        duch.nastraszKogos(ludzie.get(0));

    }

}
