package pl.edu.pw.mini.po.rtv;

public interface Udzwiekowienie {
	default void wlaczDzwiek() {
		System.out.println("Wlaczono dzwiek");
	}
	
	default void wylaczDzwiek() {
		System.out.println("Wylaczono dzwiek");
	}
}
