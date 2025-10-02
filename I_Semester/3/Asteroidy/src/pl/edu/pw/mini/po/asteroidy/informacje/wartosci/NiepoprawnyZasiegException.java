package pl.edu.pw.mini.po.asteroidy.informacje.wartosci;

public class NiepoprawnyZasiegException extends Exception {

	public NiepoprawnyZasiegException() {
		super("Minimum nie moze być wieksze od maksimum");
	}
	
}
