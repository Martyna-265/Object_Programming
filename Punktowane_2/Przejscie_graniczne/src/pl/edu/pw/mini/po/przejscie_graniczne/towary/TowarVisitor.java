package pl.edu.pw.mini.po.przejscie_graniczne.towary;

public class TowarVisitor implements Visitor {
	
	private int sumaWartosciCzarnorynkowej = 0;

    public void visit(TrefnyTowar towar) {
        System.out.println("wartosc czarnorynkowa: " + towar.getWartoscCzarnorynkowa());
        sumaWartosciCzarnorynkowej += towar.getWartoscCzarnorynkowa();
    }

    public int getSumaWartosciCzarnorynkowej() {
        return sumaWartosciCzarnorynkowej;
    }
}
