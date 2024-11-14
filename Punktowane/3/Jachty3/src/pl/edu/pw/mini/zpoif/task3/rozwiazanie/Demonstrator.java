package pl.edu.pw.mini.zpoif.task3.rozwiazanie;

public class Demonstrator {

    public static void main(String[] args) {

        Analizator analizator = new Analizator();

        System.out.println("Najciezszy statek:");
        System.out.println(analizator.getNajciezszyStatek());

        System.out.println();
        System.out.println("Statek o najdluzszej nazwie producenta:");
        System.out.println(analizator.getStatekONajdluzszejNazwieProducentaNaR());

        System.out.println();
        System.out.println("Jacht motorowy o najwiekszej mocy silnika:");
        System.out.println(analizator.getJachtMotorowyONajwiekszejMocySilnika());

        System.out.println();
        System.out.println("Lekki jacht kabinowy o najmniejszym ozaglowaniu:");
        System.out.println(analizator.getLekkiJachtKabinowyONajmniejszymOzaglowaniu());

        System.out.println();
        System.out.println("Dlugie i ciezkie jachty:");
        System.out.println(analizator.getCoNajwyzej11DlugichICiezkichJachtow());

        System.out.println();
        System.out.println("Statki posortowane wzgledem dlugosci:");
        System.out.println(analizator.getStatkiPosortowaneWzgledemDlugosciBez2());

        System.out.println();
        System.out.println("Jachty posortowane wzgledem ozaglowania:");
        System.out.println(analizator.getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych());

        System.out.println();
        System.out.println("Oznaczanie jachtow dobrych na plycizny:");
        analizator.oznaczJachtyDobreNaPlycizny();

        System.out.println();
        System.out.println("Unikalne nazwy typow:");
        System.out.println(analizator.get12UnikalnychNazwTypow());

        System.out.println();
        System.out.println("Jachty motorowe:");
        System.out.println(analizator.getMapaJachtowMotorowych());

        System.out.println();
        System.out.println("Jachty odkrytopokladowe i motorowe:");
        System.out.println(analizator.getJachtyOdkrytopokladoweIMotoroweJednePoDrugich());

    }

}
