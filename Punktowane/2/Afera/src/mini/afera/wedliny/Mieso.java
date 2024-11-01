package mini.afera.wedliny;

public abstract class Mieso {

    private int idProduktu;

    @FunctionalInterface
    interface IdGenerator {
        int generateId();
    }

    private static IdGenerator idGenerator = new IdGenerator() {
        int counter = 10;

        @Override
        public int generateId() {
            counter+=3;
            return counter;
        }

    };

    public Mieso() {
        this.idProduktu = idGenerator.generateId();
    }

    public static void printId(Mieso mieso) {
        System.out.println(mieso.idProduktu);
    }

}
