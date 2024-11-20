package pl.edu.pw.mini.zpoif.task4b;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;
import pl.edu.pw.mini.zpoif.task4b.solution.MySolution;

public class Demonstrator {
    public static void main(String[] args) {
        MySolution mySolution = new MySolution();

        System.out.println("Task 1:");
        WygodnaBudka wygodnaBudka = (WygodnaBudka) mySolution.task1();
        System.out.println(wygodnaBudka);

        System.out.println("\nTask 2:");
        mySolution.task2(wygodnaBudka);

        System.out.println("\nTask 3:");
        mySolution.task3(wygodnaBudka);
        System.out.println(wygodnaBudka);

        System.out.println("\nTask 4:");
        mySolution.task4(wygodnaBudka);

        System.out.println("\nTask 5:");
        mySolution.task5();

        System.out.println("\nTask 6:");
        WygodnaBudka wygodnaBudka2 = (WygodnaBudka) mySolution.task6();
        System.out.println(wygodnaBudka2);

        System.out.println("\nTask 7:");
        mySolution.task7(wygodnaBudka);

        System.out.println("\nTask 8:");
        mySolution.task8();

        System.out.println("\nTask 9:");
        System.out.println(mySolution.task9(wygodnaBudka));

    }
}
