package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.rozwiazanie;

import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.NapedzanyStatekPowietrzny;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Samolot;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Smiglowiec;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.StatekPowietrzny;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
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
        return napedzaneStatki.stream()
                .filter(Smiglowiec.class::isInstance)
                .limit(napedzaneStatki.size()-3) //śmigłowce już nie są rozmiaru napedzanych statków
                .map(Smiglowiec.class::cast)
                .filter(statek -> statek.getSrednicaWirnika()>=15)
                .sorted(Comparator.comparingDouble(NapedzanyStatekPowietrzny::getZasieg).reversed())
                .limit(4)
                .collect(Collectors.toList());
    }

}
