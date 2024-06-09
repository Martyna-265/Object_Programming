package pl.edu.pw.mini.po.lab02.b;

public class MethodClass {
	
	public void myGreetingsPublic(String name) {
		System.out.println("Greeting " + name + "!");
	}
	
	protected void myGreetingsProtected(String name) {
		System.out.println("Greeting " + name + "!");
	}
	
	void myGreetings(String name) {
		System.out.println("Greeting " + name + "!");
	}
	
	private void myGreetingsPrivate(String name) {
		System.out.println("Greeting " + name + "!");
	}
	
}
