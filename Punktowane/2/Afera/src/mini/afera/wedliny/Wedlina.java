package mini.afera.wedliny;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

public abstract class Wedlina extends Mieso {

    private LocalDate dataPrzydatnosci;
    private boolean szczelneOpakowanie;
    private static Random random = new Random();

    private static Supplier<LocalDate> dateGenerator = () -> {
        LocalDate now = LocalDate.now();
        LocalDate date = now.plusDays(random.nextInt(141)-70);
        return date;
    };

    public Wedlina() {
        super();
        int p = random.nextInt(100);
        if (p < 6) {
            this.szczelneOpakowanie = true;
        }
        else {
            this.szczelneOpakowanie = false;
        }
        this.dataPrzydatnosci = dateGenerator.get();
    }
}
