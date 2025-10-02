package pl.edu.pw.mini.po.lab02;

public class Basic {

	public static void main(String[] arg) {
		System.out.println("Hello");
		
		int value = 10;
		if (value == 10) {
			System.out.println("value is 10");
		} else {
			System.out.println("value is not 10");
		}
		
		switch(value) {
		case 1:
			System.out.println("1");
			// kod dla 1
			break;
		case 15:
			System.out.println("15");
			break;
		default:
			System.out.println("else");
			break;
		}
		
		for (int i=0; i<5; i++) {
			System.out.println(i);
		}
		
		int p = 0;
		while (p < 5) {
			System.out.println(p);
			p++;
		}
		
		int k = 0;
		do {
			System.out.println("do while");
			k++;
		} while(k<5);
		
		for (int i=0; i<100; i++) {
			System.out.println("For break " + i);
			if (i==20) {
				break;
			}
		}
		
		for (int i=0; i<=50; i++) {
			if (i==20) {
				continue;
			}
			System.out.println("For break " + i);
		}
		
		double div = 5/2;
		double divided = 5.0/2.0;
		
		System.out.println("5 / 2 = " + div);
		System.out.println("5 / 2 = " + divided);
		
		int modulo = 5%2;
		System.out.println("5 % 2 = " + modulo);
	}
}
