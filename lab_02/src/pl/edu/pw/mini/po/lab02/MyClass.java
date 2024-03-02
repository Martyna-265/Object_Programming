package pl.edu.pw.mini.po.lab02;

public class MyClass {
	private int value1 = 14;
	int defaultValue = 8;
	protected int protectedValue = 9;
	public int publicValue = 1;
	
	public int getProtectedValue() {
		return protectedValue;
	}
	public void setProtectedValue(int protectedValue) {
		this.protectedValue = protectedValue;
	}
	
	public void setValue(int value1) {
		this.value1 = value1;
	}
	
	public int getValue1() {
		return value1;
	}
	
	// Alt + Shift + S + R - generowanie setterów i getterów
	
	
}
