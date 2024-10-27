package mini.pszczoly;

public class Main {
    public static void main(String[] args) {

        Apis ul = new Apis();
        ul.wypiszPszczoly();
        ul.dodajPszczole();
        ul.dodajPszczole();
        ul.dodajPszczole();
        ul.zyciePszczol();
        ul.wypiszPszczoly();
        ul.dodajPszczole();
        ul.dodajPszczole();
        ul.watkiPszczol();
        for (int i = 0; i < 10; i++){
            ul.dodajPszczole();
        }
        ul.wypiszPszczoly();
        ul.zyciePszczol();
        ul.wypiszPszczoly();

    }
}
