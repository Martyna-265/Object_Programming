package pl.edu.pw.mini.po.rtv;

public interface Obrazowanie {
	default void wlaczObraz() {
		System.out.println("Wlaczono obraz");
	}
	
	default void wylaczObraz() {
		System.out.println("Wylaczono obraz");
	}
}
