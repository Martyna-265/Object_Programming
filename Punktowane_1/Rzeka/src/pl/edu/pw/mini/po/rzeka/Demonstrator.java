package pl.edu.pw.mini.po.rzeka;

import pl.edu.pw.mini.po.rzeka.wycinek.TrzeciWycinekRzeki;

public class Demonstrator {

	public static void main(String[] args) {
		
		TrzeciWycinekRzeki rzeka = new TrzeciWycinekRzeki(5, 15);
		for (int i=0; i<10; i++) {
			rzeka.moveAll();
		}

	}

}
