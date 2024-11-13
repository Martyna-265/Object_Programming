package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.rozwiazanie;

import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.NapedzanyStatekPowietrzny;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.StatekPowietrzny;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.generator.GeneratorStatkowPowietrznych;

import java.util.List;

public class Demonstrator {

    public static void main(String[] args) {

        List<StatekPowietrzny> wszystkieStatki = GeneratorStatkowPowietrznych.generujWszystkieStatkiPowietrzne();
        List<NapedzanyStatekPowietrzny> napedzaneStatki = GeneratorStatkowPowietrznych.generujNapedzaneStatkiPowietrzne();
        Analizator analizator = new Analizator(wszystkieStatki, napedzaneStatki);

        System.out.println("Najszybciej wznoszacy sie statek:");
        System.out.println(analizator.getNajszybciejWznoszacySieStatek());

        System.out.println();
        System.out.println("Samolot o najwiekszej powierzchni nosnej:");
        System.out.println(analizator.getSamolotONajwPowierzchniNosnej());

        System.out.println();
        System.out.println("Smiglowiec o najmniejszej masie:");
        System.out.println(analizator.getSmiglowiecONajmniejszejMasie());

        System.out.println();
        System.out.println("Samoloty lub smiglowce:");
        System.out.println(analizator.getSamolotyLubSmiglowceBezPierwszych4());

        System.out.println();
        System.out.println("Smiglowce o najwiekszym zasiegu:");
        System.out.println(analizator.get4SmiglowceONajwiekszymZasiegu());

        System.out.println();
        System.out.println("Spadochron siedzeniowy:");
        System.out.println(analizator.getSiedzeniowySpadochron());

        System.out.println();
        System.out.println("Mapa szybowcow:");
        System.out.println(analizator.getMapaSzybowcowPerDoskonalosc());

        System.out.println();
        System.out.println("Suma predkosci wznoszenia samolotow:");
        System.out.println(analizator.getSumaPredkosciWznoszeniaSamolotow());

        System.out.println();
        System.out.println("Posortowane smiglowce i samoloty:");
        System.out.println(analizator.getPosortowaneSmiglowceLubSamoloty());

        System.out.println();
        System.out.println("Nazwy spadochronow ratowniczych:");
        System.out.println(analizator.zwrocNazwy());

        System.out.println();
        System.out.println("Zmiana nazwy:");
        analizator.modyfikujNazwy();

    }

}
