package pl.edu.pw.mini.po.rzeka.przedmioty.blyszczace.zegarki;

public class ZegarekPodwodny extends Zegarek {

	private boolean dziala;
	
	public ZegarekPodwodny() {
		super();
		this.dziala = random.nextBoolean();
	}
	
	@Override
	public String toString() {
		return "-*-";
	}
	
}
