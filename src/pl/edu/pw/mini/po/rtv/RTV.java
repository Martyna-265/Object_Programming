package pl.edu.pw.mini.po.rtv;

import java.time.LocalDate;

public class RTV {

	public static void main(String[] args) {
		UrzadzenieRTV[] urzadzenia = new UrzadzenieRTV[3];
		urzadzenia[0] = new Radio(LocalDate.now(), false, Czestotliwosc.KROTKIE);
		urzadzenia[1] = new TelewizorCRT(LocalDate.now(), false, 32, Kolor.KOLOROWY);
		urzadzenia[2] = new TelewizorPlaski(LocalDate.now(), false, 32, Matryca.LED);
	
		for (int i = 0; i < urzadzenia.length; i++) {
			if (urzadzenia[i] instanceof TelewizorCRT) {
				urzadzenia[i].wlacz(i+5);
			}
			if (urzadzenia[i] instanceof TelewizorPlaski) {
				urzadzenia[i].wlacz(i+7, Sygnal.CYFROWY);
			}
			System.out.println(urzadzenia[i]);
		}
		
		urzadzenia[0].wlacz();
		System.out.println(urzadzenia[0]);
		urzadzenia[0].wylacz();
		
	}

}
