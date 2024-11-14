package pl.edu.pw.mini.zpoif.task3.rozwiazanie;

import pl.edu.pw.mini.zpoif.task3.generator.GeneratorStatkow;
import pl.edu.pw.mini.zpoif.task3.model.StatekNawodny;
import pl.edu.pw.mini.zpoif.task3.model.jacht.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analizator implements Statki {

    List<StatekNawodny> statkiNawodne = GeneratorStatkow.generujStatkiNawodne();

    @Override
    public StatekNawodny getNajciezszyStatek() {
        return statkiNawodne.stream()
                .max(Comparator.comparingDouble(StatekNawodny::getMasa))
                .orElse(null);
    }

    @Override
    public StatekNawodny getStatekONajdluzszejNazwieProducentaNaR() {
        return statkiNawodne.stream()
                .filter(statek -> statek.getNazwaProducenta().startsWith("R"))
                .max(Comparator.comparingInt(statek -> statek.getNazwaProducenta().length()))
                .orElse(null);
    }

    @Override
    public JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika() {
        return statkiNawodne.stream()
                .filter(JachtMotorowy.class::isInstance)
                .map(JachtMotorowy.class::cast)
                .max(Comparator.comparingDouble(JachtMotorowy::getMocSilnika))
                .orElse(null);
    }

    @Override
    public JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu() {
        return statkiNawodne.stream()
                .filter(JachtKabinowy.class::isInstance)
                .map(JachtKabinowy.class::cast)
                .filter(statek -> statek.getMasa()<=1000)
                .min(Comparator.comparingDouble(JachtKabinowy::getPowierzchniaZagla))
                .orElse(null);
    }

    @Override
    public Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow() {
        return statkiNawodne.stream()
                .filter(Jacht.class::isInstance)
                .map(Jacht.class::cast)
                .filter(statek -> statek.getMasa()>=1400 && statek.getDlugosc()>700)
                .limit(11)
                .collect(Collectors.toSet());
    }

    @Override
    public List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2() {
        return statkiNawodne.stream()
                .skip(2)
                .sorted(Comparator.comparingDouble(StatekNawodny::getDlugosc).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych() {
        return statkiNawodne.stream()
                .filter(statek ->
                        statek instanceof JachtKabinowy || statek instanceof JachtOdkrytopokladowy)
                .map(JachtZaglowy.class::cast)
                .sorted(Comparator.comparingDouble(JachtZaglowy::getPowierzchniaZagla).reversed())
                .skip(3).limit(8).collect(Collectors.toList());
    }

    @Override
    public void oznaczJachtyDobreNaPlycizny() {
        statkiNawodne.stream()
                .filter(statek -> statek instanceof JachtKabinowy &&
                        ((JachtKabinowy) statek).getZanurzenie() <= 30 &&
                        statek.getMasa() <= 1300)
                .forEach(statek -> System.out.println("Jachtem " + ((JachtKabinowy) statek).getTyp() +
                        " wplyniesz na kazda plycizne!"));
    }

    @Override
    public String get12UnikalnychNazwTypow() {
        return statkiNawodne.stream()
                .filter(statek -> statek.getMasa() > 2000 && statek instanceof Jacht)
                .skip(3).map(statek -> ((Jacht) statek).getTyp())
                .distinct().limit(12)
                .collect(Collectors.joining(" - "));
    }

    @Override
    public Map<String, JachtMotorowy> getMapaJachtowMotorowych() {
        return statkiNawodne.stream()
                .filter(JachtMotorowy.class::isInstance)
                .map(JachtMotorowy.class::cast)
                .collect(Collectors.toMap(Jacht::getTyp, statek -> statek,
                        (statek1, statek2) ->
                                statek1.getNazwaProducenta().length() > statek2.getNazwaProducenta().length() ? statek1 : statek2));
    }

    @Override
    public List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich() {
        List<Jacht> jachty = statkiNawodne.stream()
                .filter(JachtOdkrytopokladowy.class::isInstance)
                .map(JachtOdkrytopokladowy.class::cast)
                .limit(10).collect(Collectors.toList());

        List<Jacht> motorowki = statkiNawodne.stream()
                .filter(JachtMotorowy.class::isInstance)
                .map(JachtMotorowy.class::cast)
                .filter(statek -> statek.getNazwaProducenta().toUpperCase().equals("REGAL"))
                .skip(4).limit(4)
                .collect(Collectors.toList());

        return Stream.concat(jachty.stream(), motorowki.stream()).collect(Collectors.toList());

    }
}
