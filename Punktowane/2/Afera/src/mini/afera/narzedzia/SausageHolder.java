package mini.afera.narzedzia;

import mini.afera.wedliny.*;

import java.util.Collections;
import java.util.LinkedList;

public class SausageHolder {

    private LinkedList<Mieso> wedliny;

    public SausageHolder() {
        this.wedliny = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            wedliny.add(new Kielbasa());
            wedliny.add(new SzynkaZwykla());
            wedliny.add(new SzynkaParmenska());
            wedliny.add(new Poledwica());
        }
        Collections.shuffle(wedliny);
    }

    public LinkedList<Mieso> getWedliny() {
        return wedliny;
    }
}
