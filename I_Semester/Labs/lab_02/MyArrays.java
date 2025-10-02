package pl.edu.pw.mini.po.lab02;

public class MyArrays {

	public static void main(String[] args) {
		
		int[] myTab = new int[10];
		int length = myTab.length;
		System.out.println(length);
		
		myTab[0] = 111;
		System.out.println(myTab[0]);
		
		/*
		myTab[10] = 2; - blad
		*/
		
		for (int i=0; i<length; i++) {
			myTab[i] = i*3;
		}
		
		for (int i=0; i<length; i++) {
			System.out.print(myTab[i] + ", ");
		}
		System.out.println();
		
		int[] anotherTab = {1, 2, 3, 4};
		
		int [][] doubleDimension = {{1, 2, 3, 4}, {5, 6}, {7, 8, 9}};
		
		for (int i=0; i < doubleDimension.length; i++) {
			for (int j=0; j < doubleDimension[i].length; j++) {
				System.out.print(doubleDimension[i][j] + " ");
			}
			System.out.println();
		}
		
		int [][] doubleDimension2 = new int[3][];
		
		doubleDimension2[0] = new int[4];
		doubleDimension2[1] = new int[2];
		doubleDimension2[2] = new int[3];

	}

}
