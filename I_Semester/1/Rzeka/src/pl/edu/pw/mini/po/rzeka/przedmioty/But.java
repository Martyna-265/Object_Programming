package pl.edu.pw.mini.po.rzeka.przedmioty;

public class But extends Suweniry {

	private static String rodzaj = "Kalosz";
	
	public But() {
		super(0);
	}
	
	@Override
	public String toString() {
		return " @ ";
	}

	@Override
	public int distance() {
		return random.nextInt(1)+2;
	}

}
