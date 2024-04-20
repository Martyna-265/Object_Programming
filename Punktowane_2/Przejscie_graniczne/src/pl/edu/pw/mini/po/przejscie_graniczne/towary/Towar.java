package pl.edu.pw.mini.po.przejscie_graniczne.towary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Towar {

	private static final Random random = new Random();
	
	private String nazwa;
//	private List<String> dostepneNazwy;
//	{
//	dostepneNazwy = new ArrayList<String>();
//	dostepneNazwy.add("woda");
//	dostepneNazwy.add("kanapka");
//	dostepneNazwy.add("laptop");
//	dostepneNazwy.add("zasilacz");
//	dostepneNazwy.add("mysz");
//	dostepneNazwy.add("ksiazka");
//	}

	public Towar() {
		//this.setDostepneNazwy();
		//this.setNazwa(dostepneNazwy.get(random.nextInt(dostepneNazwy.size())));
		this.setNazwa("woda");
	}

	protected void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

//	private void setDostepneNazwy() {
//		dostepneNazwy = new ArrayList<String>();
//		dostepneNazwy.add("woda");
//		dostepneNazwy.add("kanapka");
//		dostepneNazwy.add("laptop");
//		dostepneNazwy.add("zasilacz");
//		dostepneNazwy.add("mysz");
//		dostepneNazwy.add("ksiazka");
//	}

	public String getNazwa() {
		return nazwa;
	}
	
}
