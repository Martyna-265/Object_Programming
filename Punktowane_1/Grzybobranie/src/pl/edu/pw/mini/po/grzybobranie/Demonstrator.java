package pl.edu.pw.mini.po.grzybobranie;

import pl.edu.pw.mini.po.grzybobranie.las.Las;

public class Demonstrator {

	public static void main(String[] args) {
		
		Las las = new Las(10, 10);
//		for (int i=0; i<10; i++) {
//			for (int j=0; j<10; j++) {
//				System.out.print(las.tablica[i][j] + " ");
//			}
//			System.out.println();
//		}
		KonsumentGrzybow Grzegorz = new KonsumentGrzybow(las);
		Grzegorz.konsumujGrzyby();

	}

}
