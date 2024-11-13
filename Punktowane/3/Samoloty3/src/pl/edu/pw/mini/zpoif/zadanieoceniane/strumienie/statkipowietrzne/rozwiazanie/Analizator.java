package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.rozwiazanie;

import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.*;

import java.util.*;
import java.util.stream.Collectors;

public class Analizator {

    List<StatekPowietrzny> wszystkieStatki;
    List<NapedzanyStatekPowietrzny> napedzaneStatki;

    public Analizator(List<StatekPowietrzny> wszystkieStatki, List<NapedzanyStatekPowietrzny> napedzaneStatki) {
        this.wszystkieStatki = wszystkieStatki;
        this.napedzaneStatki = napedzaneStatki;
    }

    NapedzanyStatekPowietrzny getNajszybciejWznoszacySieStatek() {
        return napedzaneStatki.stream()
                .max(Comparator.comparingDouble(NapedzanyStatekPowietrzny::getPredkoscWznoszenia))
                .orElse(null);
    }

    StatekPowietrzny getSamolotONajwPowierzchniNosnej() {
        return napedzaneStatki.stream().skip(5)
                //.filter(Samolot.class::isInstance)
                .filter(statek -> statek instanceof Samolot)
                .map(Samolot.class::cast)
                .max(Comparator.comparingDouble(Samolot::getPowierzchniaNosna))
                .orElse(null);
    }

    Smiglowiec getSmiglowiecONajmniejszejMasie() {
        return napedzaneStatki.stream()
                .filter(Smiglowiec.class::isInstance)
                .skip(3). map(Smiglowiec.class::cast)
                .filter(smiglowiec -> !smiglowiec.getTyp().startsWith("Mi"))
                .min(Comparator.comparingDouble(Smiglowiec::getMasa))
                .orElse(null);
    }

    Set<StatekPowietrzny> getSamolotyLubSmiglowceBezPierwszych4() {
        return napedzaneStatki.stream()
                .filter(statek -> statek instanceof Samolot || statek instanceof Smiglowiec)
                .filter(statek -> statek.getPredkoscWznoszenia() <= 15 && statek.getMasa() < 13000)
                .skip(4).limit(3)
                .collect(Collectors.toSet());
    }

    public List<NapedzanyStatekPowietrzny>get4SmiglowceONajwiekszymZasiegu() {
        int rozmiar = napedzaneStatki.stream()
                .filter(Smiglowiec.class::isInstance)
                .collect(Collectors.toSet()).size();

        return napedzaneStatki.stream()
                .filter(Smiglowiec.class::isInstance)
                .limit(rozmiar-3)
                .map(Smiglowiec.class::cast)
                .filter(statek -> statek.getSrednicaWirnika()>=15)
                .sorted(Comparator.comparingDouble(NapedzanyStatekPowietrzny::getZasieg).reversed())
                .limit(4)
                .collect(Collectors.toList());
    }

    SpadochronRatowniczy getSiedzeniowySpadochron() {
        return wszystkieStatki.stream()
                .filter(SpadochronRatowniczy.class::isInstance)
                .map(SpadochronRatowniczy.class::cast)
                .filter(SpadochronRatowniczy::isSiedzeniowy)
                .max(Comparator.comparingInt(SpadochronRatowniczy::getMinimalnaWysokosc))
                .orElse(null);
    }

    Map<Integer, Szybowiec> getMapaSzybowcowPerDoskonalosc() {
        return wszystkieStatki.stream()
                .filter(Szybowiec.class::isInstance).skip(1)
                .map(Szybowiec.class::cast)
                .collect(Collectors.toMap(Szybowiec::getDoskonalosc, szybowiec -> szybowiec,
                        (existing, replacement) -> existing.getTyp().length() >= replacement.getTyp().length() ?
                        existing : replacement));
    }

    double getSumaPredkosciWznoszeniaSamolotow() {
        List<Samolot> samoloty = napedzaneStatki.stream()
                .filter(Samolot.class::isInstance)
                .map(Samolot.class::cast)
                .skip(3)
                .filter(samolot -> samolot.getMasa() <= 15000)
                .collect(Collectors.toList());

        if (!samoloty.isEmpty()) {
            samoloty.removeLast();
        }

        return samoloty.stream().limit(5)
                .mapToDouble(Samolot::getPredkoscWznoszenia).sum();

    }

    Map<String, StatekPowietrzny> getPosortowaneSmiglowceLubSamoloty() {

        return napedzaneStatki.stream()
                .skip(10)
                .filter(statek -> statek instanceof Samolot || statek instanceof Smiglowiec)
                .sorted(Comparator.comparingDouble(NapedzanyStatekPowietrzny::getMasa))
                //.distinct()
                .limit(10)
                //.collect(Collectors.toMap(StatekPowietrzny::getTyp, statek -> statek));
                .collect(Collectors.groupingBy(StatekPowietrzny::getTyp,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                List::getFirst)
                        ));
    }

    List<String> zwrocNazwy() {
        List<SpadochronRatowniczy> spadochrony = wszystkieStatki.stream()
                .filter(SpadochronRatowniczy.class::isInstance)
                .map(SpadochronRatowniczy.class::cast)
                .distinct()
                .collect(Collectors.toList());

        if (!spadochrony.isEmpty()) {
            spadochrony.removeLast();
        }

        return spadochrony.stream()
                .limit(2)
                .map(Spadochron::toString)
                .toList();
    }

    void modyfikujNazwy() {
        Random random = new Random();
        napedzaneStatki.stream()
                .filter(Samolot.class::isInstance)
                .map(Samolot.class::cast)
                .filter(samolot -> samolot.getMasa()>5000)
                .sorted(Comparator.comparingDouble(Samolot::getPredkoscWznoszenia).reversed())
                .skip(5)
                .limit(15)
                .forEach(samolot -> {
                    if (random.nextInt(100) < 50) { // inne prawdopodobieństwo, zeby bylo cos widac
                        samolot.setTyp("[" + samolot.getTyp() + "]");
                        System.out.println(samolot); // zeby bylo widac
                    }
                });

    }

}
