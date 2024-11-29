package pl.edu.pw.mini.jrafalko;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Pracownik> pracownicy = FabrykaTajnePrzezPoufne.tworzZalogeFabryki();
        System.out.println("Przed cenzurą");
        pracownicy.forEach(System.out::println);
        Cenzura cenzura = new Cenzura();
        System.out.println("\nPo cenzurze:");
        for(Pracownik p : cenzura.cenzuruj(pracownicy)){
            System.out.println(p);
        }
    }
}
