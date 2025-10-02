package mini.lotnisko;

public class Main {
    public static void main(String[] args) {
        Lotnisko lotnisko = new Lotnisko(5);

        System.out.println("Samoloty na lotnisku:");
        System.out.println("---------------------");
        lotnisko.wypiszSamoloty();

        System.out.println();
        System.out.println("Próba odlotu:");
        System.out.println("---------------------");
        lotnisko.odlotSamolotow();

        System.out.println();
        System.out.println("Odprawa:");
        System.out.println("---------------------");
        lotnisko.odprawaSamolotow();
        lotnisko.wypiszSamoloty();

        System.out.println();
        System.out.println("Odlot:");
        System.out.println("---------------------");
        lotnisko.odlotSamolotow();
        lotnisko.wypiszSamoloty();

        System.out.println();
        System.out.println("Działania lotniskowe:");
        System.out.println("---------------------");
        lotnisko.dzialaniaLotniskowe();

        System.out.println();
        System.out.println("Sortowanie samolotów:");
        System.out.println("---------------------");
        System.out.println("Sortowanie po prędkości maksymalnej:");
        lotnisko.sortowanieSamolotow(0);
        lotnisko.wypiszSamoloty();
        System.out.println();
        System.out.println("Sortowanie po nazwie:");
        lotnisko.sortowanieSamolotow(1);
        lotnisko.wypiszSamoloty();

        System.out.println();
        System.out.println("Sortowanie losowe:");
        System.out.println("---------------------");
        lotnisko.sortowanieLosowe();
        lotnisko.wypiszSamoloty();

    }
}
