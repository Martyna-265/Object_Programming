package pl.edu.pw.mini.po.przejscie_graniczne.towary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TrefnyTowar extends Towar{

private static final Random random = new Random();
	
	private int wartoscCzarnorynkowa;
//	private Map<String, List<Integer>> nazwyZWartosciami;
//	private List<String> dostepneNazwy;
//	{
//		nazwyZWartosciami = new HashMap<>();
//		List<Integer> wartosci = new ArrayList<Integer>();
//		
//		wartosci.add(15000);
//		wartosci.add(12000);
//		nazwyZWartosciami.put("bron", wartosci);
//		
//		wartosci.clear();
//		wartosci.add(700);
//		wartosci.add(750);
//		wartosci.add(800);
//		nazwyZWartosciami.put("alkohol bez banderoli", wartosci);
//		
//		wartosci.clear();
//		wartosci.add(3500);
//		nazwyZWartosciami.put("bursztyn", wartosci);
//		
//		wartosci.clear();
//		wartosci.add(1450);
//		wartosci.add(1350);
//		nazwyZWartosciami.put("lopatka wieprzowa", wartosci);
//		
//	}
	
	
	public TrefnyTowar() {
		//this.setNazwyZWartosciami();
		//this.dostepneNazwy = new ArrayList<String>(nazwyZWartosciami.keySet());
		//String nazwa = dostepneNazwy.get(random.nextInt(nazwyZWartosciami.size()));
		//this.setNazwa(nazwa);
		//List<Integer> wartosci = nazwyZWartosciami.get(nazwa);
		//this.wartoscCzarnorynkowa = wartosci.get(random.nextInt(wartosci.size()));
		this.setNazwa("bron");
		this.wartoscCzarnorynkowa = 15000;
	}

//	private void setNazwyZWartosciami() {
//		nazwyZWartosciami = new HashMap<>();
//		List<Integer> wartosci = new ArrayList<Integer>();
//		
//		wartosci.add(15000);
//		wartosci.add(12000);
//		nazwyZWartosciami.put("bron", wartosci);
//		
//		wartosci.clear();
//		wartosci.add(700);
//		wartosci.add(750);
//		wartosci.add(800);
//		nazwyZWartosciami.put("alkohol bez banderoli", wartosci);
//		
//		wartosci.clear();
//		wartosci.add(3500);
//		nazwyZWartosciami.put("bursztyn", wartosci);
//		
//		wartosci.clear();
//		wartosci.add(1450);
//		wartosci.add(1350);
//		nazwyZWartosciami.put("lopatka wieprzowa", wartosci);
//		
//	}
	
//	public void printMe() {
//		System.out.println(dostepneNazwy);
//	}

	public int getWartoscCzarnorynkowa() {
		return wartoscCzarnorynkowa;
	}
	
}
