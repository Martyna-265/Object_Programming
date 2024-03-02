package pl.edu.pw.mini.po.first.init;

public class MyClass {
	public static void main(String[] args) {
		
		System.out.print("Hello world!\n");
		// Ctrl + F11 - włączenie ostatniej klasy
		// Ctrl + Space - podpowiedz
		
		byte myByte = (byte)152; // byte <-127, 127>
		short myShort = (short)33000;
		int myInteger = 1_000_0_0000_0;
		long myLong = 1_000_000_000_000_000l;
		
		float myFloat = 2.5f;
		double myDouble = 4.5d;
		
		System.out.println("My byte: " + myByte + " my short: " + myShort + " my integer: " + myInteger);
		
		for(int i=0; i<=100; i++)
		{
			System.out.println(i + " Blabla");
		}
		System.out.println();
		
		int[] myArray = new int[10];
		
		myArray[0] = 1;
		myArray[1] = 2;
		myArray[2] = 3;
		myArray[3] = 4;
		myArray[4] = 5;
		myArray[5] = 6;
		
		for (int i=6; i<10; i++)
		{
			myArray[i] = i+1;
		}
		
		for (int i=0; i<10; i++)
		{
			System.out.print(myArray[i] + " ");
		}
		
	}
	
}
