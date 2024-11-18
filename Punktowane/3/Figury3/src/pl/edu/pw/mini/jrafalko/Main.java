package pl.edu.pw.mini.jrafalko;

import pl.edu.pw.mini.jrafalko.figures.Figura2D;
import pl.edu.pw.mini.jrafalko.streams.GeneratorFigur;
import pl.edu.pw.mini.jrafalko.streams.ImplementacjaInterfejsu;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        List<Figura2D> figury = GeneratorFigur.generuj();
        ImplementacjaInterfejsu imp = new ImplementacjaInterfejsu(figury);

        System.out.println("Wszystkie figury:");
        figury.forEach(System.out::println);
        System.out.println();

        System.out.println("1. Największa figura względem pola wysokosc: " + imp.getNajwiekszaFigure() + "\n");

        System.out.println("2. Figura2D o najmniejszym polu powierzchni: " + imp.getFigureONajmniejszymPolu() + "\n");

        System.out.println("3. Najwyższa figura 3D: " + imp.getNajwyzszaFigure3D() + "\n");

        System.out.println("4. Najmniejszy sześcian względem objętości: " + imp.getNajmniejszySzescian() + "\n");

        System.out.println("5. Lista figur posortowanych względem pola powierzchni: ");
        imp.getPosortowaneWzgledemPowiezchni().forEach(System.out::println);
        System.out.println();

        System.out.println("6. 3 figura z posortowanych malejaco względem obwodu: " + imp.getFigureZPosortowanychMalejacoWgObwodu(3) + "\n");

        System.out.println("7. Lista 6 pierwszych figur posortowanych rosnąco względem pola powierzchni: ");
        imp.getPierwszePosortowaneRosnacoWgPowierzchni(6).forEach(System.out::println);
        System.out.println();

        System.out.println("8. Lista wszystkich sześcianów o długości boku nie większej niż 8: ");
        imp.getSzesciany(8).forEach(System.out::println);
        System.out.println();

        System.out.println("9. Koło o najmniejszym polu powierzchni: " + imp.getNajmniejszeKolo() + "\n");

        System.out.println("10. Mapa figur względem ID: " + "\n" + imp.mapaWgId() + "\n");

        System.out.println("11. Ilość figur o polu powierzchni nie większym niż 210: " + imp.getiloscMalych(210) + "\n");

        System.out.println("12. Posortowany ciąg figur zaczynając od 3: ");
        imp.posortowaneWgPolaZaczynajacOd(3).forEach(System.out::println);
        System.out.println();

    }
}
