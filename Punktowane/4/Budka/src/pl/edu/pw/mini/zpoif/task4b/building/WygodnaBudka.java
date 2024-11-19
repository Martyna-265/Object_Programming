package pl.edu.pw.mini.zpoif.task4b.building;

public class WygodnaBudka extends Budka {
    public String bazgrol;
    private String szyfrDoSejfu;
    public Sejf sejf;

    public WygodnaBudka() {
        this.bazgrol = "Default Bazgrol";
        this.sejf = new Sejf();
    }

    public WygodnaBudka(String param1, String param2) {
        this.bazgrol = param1;
        this.szyfrDoSejfu = param2;
        this.sejf = new Sejf();
    }

    public Integer exampleMethod() {
        return 42;
    }

    protected class Sejf {
        public void open(String szyfr) {
            System.out.println("Sejf otwarty z szyfrem: " + szyfr);
        }
    }
}

